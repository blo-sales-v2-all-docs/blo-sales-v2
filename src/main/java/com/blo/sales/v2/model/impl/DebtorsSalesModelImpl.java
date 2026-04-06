package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.IDebtorsSalesModel;
import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.model.constants.BloSalesV2Queries;
import com.blo.sales.v2.model.mapper.DebtorSaleEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import java.sql.Statement;

@Singleton
public class DebtorsSalesModelImpl implements IDebtorsSalesModel {
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorsSalesModelImpl.class.getName());
    
    @Inject
    private DebtorSaleEntityMapper mapper;
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Override
    public PojoIntDebtorSale addRelationship(PojoIntDebtorSale debtor) throws BloSalesV2Exception {
        try {
            logger.info("guardando relacion deudor venta");
            final var conn = DBConnection.getConnection();
            transactionManager.disableAutocommit();
            final var relationInner = mapper.toInner(debtor);
            final var ps = conn.prepareStatement(BloSalesV2Queries.INSERT_DEBTOR_SALE, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, relationInner.getFk_debtor());
            ps.setLong(2, relationInner.getFk_sale());
            ps.setString(3, relationInner.getTimestamp());
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_ADD_EXCEPTION_CODE, BloSalesV2Utils.ERROR_SAVED_ON_DATA_BASE);
            
            final var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                relationInner.setId_debtor_sale(rs.getLong(1));
            }
            logger.info("relacion guardada exitosamente %s", String.valueOf(relationInner));
            return mapper.toOuter(relationInner);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public void deleteRelationhip(long fkDebtor) throws BloSalesV2Exception {
         try {
             logger.info("eliminado relacion deudor - venta fkDebtor = %s", fkDebtor);
             final var conn = DBConnection.getConnection();
             transactionManager.disableAutocommit();
            final var ps = conn.prepareStatement(BloSalesV2Queries.DELETE_DEBTOR_SALE);
            ps.setLong(1, fkDebtor);
            final var rowsAffected = ps.executeUpdate();
            
            BloSalesV2Utils.validateRule(rowsAffected == 0, BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
            
            logger.info("relacion eliminada");
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
