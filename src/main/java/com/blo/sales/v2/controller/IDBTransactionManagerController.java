package com.blo.sales.v2.controller;

import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 *
 * Enlace entre gestor de transacciones modelo
 * 
 * @author orlndo
 */
public interface IDBTransactionManagerController {
    
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
    
    void doRollback() throws BloSalesV2Exception;
    
}
