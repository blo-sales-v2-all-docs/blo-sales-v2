package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.ISaleDeletedDetailModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.mapper.SaleDeletedDetailEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;

@Singleton
public class SaleDeletedDetailModelImpl implements ISaleDeletedDetailModel {
    
    private static final GUILogger logger = GUILogger.getLogger(SaleDeletedDetailModelImpl.class.getName());
    
    @Inject
    private SaleDeletedDetailEntityMapper mapper;
    
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
    
}
