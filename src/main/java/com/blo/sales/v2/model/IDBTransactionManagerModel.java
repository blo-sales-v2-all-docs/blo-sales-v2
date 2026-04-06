package com.blo.sales.v2.model;

import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 *
 * Gestor de operaciones en base de datos
 * @version 1.0.0
 * @author orlndo
 */
public interface IDBTransactionManagerModel {
    
    /**
     * privene un guardado de cambios en la base de datos
     * @throws BloSalesV2Exception 
     */
    void disableAutocommit() throws BloSalesV2Exception;
    
    /**
     * realiza commit
     * @throws BloSalesV2Exception 
     */
    void doCommit() throws BloSalesV2Exception;
    
    /**
     * Activa autocommit
     * @throws BloSalesV2Exception 
     */
    void enableAutocommit() throws BloSalesV2Exception;
    
    /**
     * Hace rollback de cambios
     * @throws BloSalesV2Exception 
     */
    void doRollback() throws BloSalesV2Exception;
}
