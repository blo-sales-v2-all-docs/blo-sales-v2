package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSalesDeletedDetails;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.ISaleDeletedDetailModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Columns;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.entities.SaleDeletedDetailEntity;
import com.blo.sales.v2.model.entities.WrapperSalesDeletedDetailsEntity;
import com.blo.sales.v2.model.mapper.SaleDeletedDetailEntityMapper;
import com.blo.sales.v2.model.mapper.WrapperSalesDeletedDetailsEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class SaleDeletedDetailModelImpl implements ISaleDeletedDetailModel {
    
    private static final GUILogger logger = GUILogger.getLogger(SaleDeletedDetailModelImpl.class.getName());
    
    @Inject
    private SaleDeletedDetailEntityMapper mapper;
    
    @Inject
    private WrapperSalesDeletedDetailsEntityMapper wrapperSalesDeletedMapper;
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Override
    public PojoIntSaleDeletedDetail addSaleDeletedDetail(PojoIntSaleDeletedDetail detail) throws BloSalesV2Exception {
        try {
        	final var conn = DBConnection.getConnection();
            logger.info("guardando motivo de baja");
            transactionManager.disableAutocommit();
            final var innerSale = mapper.toInner(detail);
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_SALE_DELETED_DETAIL, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, innerSale.getFk_sale_product());
            ps.setLong(2, innerSale.getFk_user());
            ps.setString(3, innerSale.getReason());
            ps.setString(4, innerSale.getTimestamp());
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()){
                innerSale.setId_sale_deleted(rs.getLong(1));
            }
            logger.info("relacion guardada ", String.valueOf(innerSale));
            return mapper.toOuter(innerSale);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public WrapperPojoIntSalesDeletedDetails getSalesDeleted() throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            logger.info("recuperando informacion de ventas");
            final var results = conn.prepareCall(BloSalesV2Queries.SELECT_DELETEDS_SALES_DETAIL).executeQuery();
            
            final var wrapper = new WrapperSalesDeletedDetailsEntity();
            final var lst = new ArrayList<SaleDeletedDetailEntity>();
            SaleDeletedDetailEntity detail;
            while(results.next()) {
                detail = new SaleDeletedDetailEntity();
                detail.setId_sale_deleted(results.getLong(BloSalesV2Columns.ID_SALE_DELETED));
                detail.setFk_sale_product(results.getLong(BloSalesV2Columns.FK_SALE_PRODUCT));
                detail.setFk_user(results.getLong(BloSalesV2Columns.FK_USER));
                detail.setProduct(results.getString(BloSalesV2Columns.PRODUCT));
                detail.setReason(results.getString(BloSalesV2Columns.REASON));
                detail.setTimestamp(results.getString(BloSalesV2Columns.TIMESTAMP));
                detail.setUsername(results.getString(BloSalesV2Columns.USER_NAME));
                lst.add(detail);
            }
            logger.info("detalles encontrados %s", lst.size());
            wrapper.setSales_details(lst);
            return wrapperSalesDeletedMapper.toOuter(wrapper);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
