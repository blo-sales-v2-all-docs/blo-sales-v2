package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntPriceHistory;
import com.blo.sales.v2.controller.pojos.PojoIntStockPricesHistory;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntStockPriceHistory;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para operaciones relacionadas con el historial de precios
 * @version 1.0.0
 * @author BLO
 */
public interface IStockPricesHistoryController {
    
    /**
     * Guarda un precio al historial
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param priceItem
     * @param idProduct
     * @return precio guardado
     * @throws BloSalesV2Exception 
     */
    PojoIntStockPricesHistory addPriceOnHistory(PojoIntPriceHistory priceItem, long idProduct) throws BloSalesV2Exception;
    
    WrapperPojoIntStockPriceHistory getPriceFromProduct(long idProduct) throws BloSalesV2Exception;
}
