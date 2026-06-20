package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntFinancialHistory;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para historial de movimientos
 * @version 1.0.0
 * @author BLO
 */
public interface IFinancialHistoryModel {
    
    /**
     * Metodo que guarda un movimiento en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param movement
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntFinancialMovement addMovement(PojoIntFinancialMovement movement) throws BloSalesV2Exception;

    /**
     * Metodo que recupera el historial financiero de una cuenta
     * @param accountId
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntFinancialHistory retrieveFinancialHistoryByAccountId(long accountId) throws BloSalesV2Exception;
    
}
