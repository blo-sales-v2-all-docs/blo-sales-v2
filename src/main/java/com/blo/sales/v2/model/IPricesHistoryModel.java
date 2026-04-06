package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntPriceHistory;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Modelo para operaciones de historial de precios en la bd
 * @version 1.0.0
 * @author BLO
 */
public interface IPricesHistoryModel {
    
    /**
     * Metodo que guarda un precio en el historial
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param priceHistory
     * @return precio guardado
     * @throws BloSalesV2Exception 
     */
    PojoIntPriceHistory addPriceHistory(PojoIntPriceHistory priceHistory) throws BloSalesV2Exception;
    
}
