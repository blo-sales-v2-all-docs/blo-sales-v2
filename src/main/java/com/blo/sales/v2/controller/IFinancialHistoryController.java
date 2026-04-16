package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntFinancialHistory;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para operaciones del historial financiero
 * @version 1.0.0
 * @author BLO
 */
public interface IFinancialHistoryController {
    
    /**
     * Metodo que guarda un movimiento
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param movement
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntFinancialMovement addMovement(PojoIntFinancialMovement movement) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera todos los movimientos de una cuenta
     * @param accountId
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntFinancialHistory retrieveFinancialHistoryByAccountId(long accountId) throws BloSalesV2Exception;
}
