package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.controller.pojos.enums.TopUpSearchStatusIntEnum;
import com.blo.sales.v2.model.ITopUpModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.MobileCompanyEntity;
import com.blo.sales.v2.model.entities.TopUpEntity;
import com.blo.sales.v2.model.entities.UserEntity;
import com.blo.sales.v2.model.entities.WrapperTopUpsEntity;
import com.blo.sales.v2.model.entities.enums.RolesEntityEnum;
import com.blo.sales.v2.model.mapper.TopUpEntityMapper;
import com.blo.sales.v2.model.mapper.WrapperTopUpsEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TopUpModelImpl implements ITopUpModel {
    
    private static final GUILogger logger = GUILogger.getLogger(TopUpModelImpl.class.getName());
    
    private static final Connection conn = DBConnection.getConnection();
    
    private static final TopUpEntityMapper topUpEntityMapper = TopUpEntityMapper.getInstance();
    
    private static final WrapperTopUpsEntityMapper wrapperToUpsMapper = WrapperTopUpsEntityMapper.getInstance();
    
    private static TopUpModelImpl instance;
    
    private TopUpModelImpl() { }
    
    public static TopUpModelImpl getInstance() {
        if (instance == null) {
            instance = new TopUpModelImpl();
        }
        return instance;
    }

    @Override
    public PojoIntTopUp addTopUp(PojoIntTopUp data) throws BloSalesV2Exception {
        try {
            logger.info("Guardando [%s]", String.valueOf(data));
            final var innerData = topUpEntityMapper.toInner(data);
            DBConnection.disableAutocommit();
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_TOP_UP, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, innerData.getFk_user().getId_user());
            ps.setLong(2, innerData.getFk_mobile_company().getId_mobile_company());
            ps.setBigDecimal(3, innerData.getAmount());
            ps.setBoolean(4, innerData.isChecked());
            ps.setString(5, innerData.getPhone_number());
            ps.setString(6, innerData.getTimestamp());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                innerData.setId_top_up(rs.getLong(1));
            }
            logger.info("TopUp guardada con exito [%s]", String.valueOf(innerData));
            DBConnection.doCommit();
            return topUpEntityMapper.toOuter(innerData);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        } finally {
            try {
                DBConnection.enableAutocommit();
            } catch (SQLException ex) {
                logger.error(ex.getMessage());
                throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
            }
        }
    }

    @Override
    public PojoIntTopUp updateTopUp(PojoIntTopUp data, long idTopUp) throws BloSalesV2Exception {
        try {
            final var innerData = topUpEntityMapper.toInner(data);
            logger.info("Actualizando informacion %s con id %s", String.valueOf(innerData), idTopUp);
            DBConnection.disableAutocommit();
            final var ps = conn.prepareStatement(BloSalesV2Queries.UPDATE_TP_UP);
            ps.setLong(1, innerData.getFk_user().getId_user());
            ps.setLong(2, innerData.getFk_mobile_company().getId_mobile_company());
            ps.setBigDecimal(3, innerData.getAmount());
            ps.setBoolean(4, innerData.isChecked());
            ps.setString(5, innerData.getPhone_number());
            ps.setString(6, innerData.getTimestamp());
            ps.setLong(7, idTopUp);
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_UPDATE_EXCEPTION_CODE, BloSalesV2Utils.ERROR_UPDATING_ON_DATA_BASE);
            
            logger.info("Datos actualizados %s", String.valueOf(innerData));
            DBConnection.doCommit();
            return topUpEntityMapper.toOuter(innerData);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        } finally {
            try {
                DBConnection.enableAutocommit();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
            }
        }
    }

    @Override
    public WrapperPojoIntTopUp getTopUpsByStatus(TopUpSearchStatusIntEnum status) throws BloSalesV2Exception {
        try {
            final var innerStatus = TopUpSearchStatusIntEnum.valueOf(status.name());
            logger.info("recuperando recargas por status [%s]", String.valueOf(status));
            var ps = conn.prepareStatement(BloSalesV2Queries.SELECT_ALL_TOP_UP);
            if (innerStatus != TopUpSearchStatusIntEnum.ALL) {
                logger.info("query cambiada %s", BloSalesV2Queries.SELECT_ALL_TOP_UP);
                ps = conn.prepareStatement(BloSalesV2Queries.SELECT_TOP_UPS_BY_STATUS);
                ps.setBoolean(1, innerStatus.isValue());
            }
            final var rs = ps.executeQuery();
            final var wrapperTopUps = new WrapperTopUpsEntity();
            final var topUps = new ArrayList<TopUpEntity>();
            MobileCompanyEntity companyEntity = null;
            while(rs.next()) {
                final var p = new TopUpEntity();
                companyEntity = new MobileCompanyEntity();
                companyEntity.setId_mobile_company(rs.getLong(BloSalesV2Columns.ID_COMPANY));
                companyEntity.setMobile_company(rs.getString(BloSalesV2Columns.COMPANY));
                p.setFk_mobile_company(companyEntity);
                
                p.setAmount(rs.getBigDecimal(BloSalesV2Columns.AMOUNT));
                p.setChecked(rs.getBoolean(BloSalesV2Columns.CHECKED));
                p.setId_top_up(rs.getLong(BloSalesV2Columns.ID_TOP_UP));
                p.setPhone_number(rs.getString(BloSalesV2Columns.PHONE_NUMBER));
                p.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
                
                // user
                final var u = new UserEntity();
                u.setId_user(rs.getLong(BloSalesV2Columns.ID_USER));
                u.setRole(RolesEntityEnum.valueOf(rs.getString(BloSalesV2Columns.ROL)));
                u.setUsername(rs.getString(BloSalesV2Columns.USER_NAME));
                p.setFk_user(u);
                
                topUps.add(p);
            }
            logger.info("registros encontrados %s", String.valueOf(topUps.size()));
            wrapperTopUps.setTopUps(topUps);
            return wrapperToUpsMapper.toOuter(wrapperTopUps);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
