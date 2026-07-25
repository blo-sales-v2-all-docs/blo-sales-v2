package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.model.ICreditsModel;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.CreditEntity;
import com.blo.sales.v2.model.entities.WrapperCreditsEntity;
import com.blo.sales.v2.model.mapper.CreditEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class CreditsModelImpl implements ICreditsModel {
    
    private static final GUILogger logger = GUILogger.getLogger(CreditsModelImpl.class.getName());
    
    private static final CreditEntityMapper CREDIT_ENTITY_MAPPER = CreditEntityMapper.INSTANCE;
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Override
    public WrapperPojoIntCredits getAllCredits() throws BloSalesV2Exception {
        try {
            logger.info("recuperando creditos");
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.SELECT_CREDITS);
            
            final var rs = ps.executeQuery();
            
            final var outer = new WrapperCreditsEntity();
            final var lst = new ArrayList<CreditEntity>();
            CreditEntity item = null;
            while(rs.next()) {
                item = new CreditEntity();
                item.setAmount(rs.getBigDecimal(BloSalesV2Columns.AMOUNT));
                item.setAvailable(rs.getBoolean(BloSalesV2Columns.AVAILABLE));
                item.setFk_user(rs.getLong(BloSalesV2Columns.FK_USER));
                item.setId_credit(rs.getLong(BloSalesV2Columns.ID_CREDIT));
                item.setLender_name(rs.getString(BloSalesV2Columns.LENDER_NAME));
                item.setPayed(rs.getBoolean(BloSalesV2Columns.PAYED));
                item.setPayments(rs.getString(BloSalesV2Columns.PAYMENTS));
                item.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
                item.setUpdate_date(rs.getString(BloSalesV2Columns.UPDATE_DATE));
                item.setOriginal_amount(rs.getBigDecimal(BloSalesV2Columns.ORIGINAL_AMOUNT));
                lst.add(item);
            }
            outer.setCredits(lst);
            logger.info("registros encontrados [%s]", lst.size());
            return CREDIT_ENTITY_MAPPER.wrapperCreditsToOuter(outer);
        } catch(SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
    @Override
    public PojoIntCredit getCreditById(long idCredit) throws BloSalesV2Exception {
        try {
            logger.info("recuperando credito por id %s", idCredit);
            final var conn = DBConnection.getConnection();
            final var ps = conn.prepareStatement(BloSalesV2Queries.SELECT_CREDIT_BY_ID);
            ps.setLong(1, idCredit);
            
            final var rs = ps.executeQuery();
            
            CreditEntity item = null;
            while(rs.next()) {
                item = new CreditEntity();
                item.setAmount(rs.getBigDecimal(BloSalesV2Columns.AMOUNT));
                item.setAvailable(rs.getBoolean(BloSalesV2Columns.AVAILABLE));
                item.setFk_user(rs.getLong(BloSalesV2Columns.FK_USER));
                item.setId_credit(rs.getLong(BloSalesV2Columns.ID_CREDIT));
                item.setLender_name(rs.getString(BloSalesV2Columns.LENDER_NAME));
                item.setPayed(rs.getBoolean(BloSalesV2Columns.PAYED));
                item.setPayments(rs.getString(BloSalesV2Columns.PAYMENTS));
                item.setTimestamp(rs.getString(BloSalesV2Columns.TIMESTAMP));
                item.setUpdate_date(rs.getString(BloSalesV2Columns.UPDATE_DATE));
            }
            logger.info("registro encontrado [%s]", String.valueOf(item));
            return CREDIT_ENTITY_MAPPER.toOuter(item);
        } catch(SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntCredit openCredit(PojoIntCredit credit) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            logger.info("registrando credito %s", String.valueOf(credit));
            final var entity = CREDIT_ENTITY_MAPPER.toInner(credit);
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_CREDIT, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, entity.getFk_user());
            ps.setString(2, entity.getLender_name());
            ps.setBigDecimal(3, entity.getAmount());
            ps.setBoolean(4, entity.isPayed());
            ps.setString(5, entity.getTimestamp());
            ps.setString(6, entity.getPayments());
            ps.setString(7, entity.getUpdate_date());
            ps.setBigDecimal(8, entity.getOriginal_amount());
            
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entity.setId_credit(rs.getLong(1));
            }
            logger.info("credito registrado %s", String.valueOf(entity));
            return CREDIT_ENTITY_MAPPER.toOuter(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public PojoIntCredit updateCredit(PojoIntCredit creditInfo) throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            logger.info("actualizando credito %s", String.valueOf(creditInfo));
            final var entity = CREDIT_ENTITY_MAPPER.toInner(creditInfo);
            final var ps = conn.prepareStatement(BloSalesV2Queries.UPDATE_CREDIT);
            ps.setString(1, entity.getLender_name());
            ps.setBoolean(2, entity.isPayed());
            ps.setString(3, entity.getTimestamp());
            ps.setString(4, entity.getPayments());
            ps.setBoolean(5, entity.isAvailable());
            ps.setString(6, entity.getUpdate_date());
            ps.setBigDecimal(7, entity.getAmount());
            ps.setLong(8, entity.getId_credit());
            
            BloSalesV2Utils.validateRule(ps.executeUpdate() == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            logger.info("credito actualizado %s", String.valueOf(entity));
            return CREDIT_ENTITY_MAPPER.toOuter(entity);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
