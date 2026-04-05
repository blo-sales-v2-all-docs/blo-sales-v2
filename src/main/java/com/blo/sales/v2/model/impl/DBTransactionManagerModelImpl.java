package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.model.config.DBConnection;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import jakarta.inject.Singleton;
import java.sql.SQLException;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.view.commons.GUILogger;

/**
 * Implementacion de interfaz TransactionManagement
 * @version 1.0.0
 * @author BLO
 */
public @Singleton class DBTransactionManagerModelImpl implements IDBTransactionManagerModel {
    
    private static final GUILogger logger = GUILogger.getLogger(DBTransactionManagerModelImpl.class.getName());
    
    @Override
    public void disableAutocommit() throws BloSalesV2Exception {
        try {
            DBConnection.getConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            logger.error("Error al ejecutar commit en la base de datos: {}", ex.getMessage(), ex);
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
    @Override
    public void doCommit() throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            if (conn != null && !conn.getAutoCommit()) {
                conn.commit();
            }
        } catch (SQLException ex) {
            logger.error("Error al ejecutar commit en la base de datos: {}", ex.getMessage(), ex);
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
    @Override
    public void enableAutocommit() throws BloSalesV2Exception {
        try {
            final var conn = DBConnection.getConnection();
            if (conn != null) {
                conn.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            logger.error("Error al ejecutar commit en la base de datos: {}", ex.getMessage(), ex);
            throw new BloSalesV2Exception(BloSalesV2Utils.SQL_EXCEPTION_CODE, BloSalesV2Utils.SQL_EXCEPTION_MESSAGE);
        }
    }
    
}
