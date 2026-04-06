package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntPriceHistory;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para operaciones del historia de precios
 * @version 1.0.0
 * @author BLO
 */
public interface IPricesHistoryController {
    
    /**
     * Metodo que guarda un precio en el historial
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param priceHistory
     * @return precio guardado
     * @throws BloSalesV2Exception 
     */
    PojoIntPriceHistory addPriceHistory(PojoIntPriceHistory priceHistory) throws BloSalesV2Exception;
    
}
