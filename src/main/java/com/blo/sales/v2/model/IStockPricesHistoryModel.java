package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntStockPricesHistory;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntStockPriceHistory;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones sobre el historial de los precios
 * @version 1.0.0
 * @author BLO
 */
public interface IStockPricesHistoryModel {
    
    /**
     * Funcion que guarda un precio en el historial
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param item
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntStockPricesHistory addPriceOnHistory(PojoIntStockPricesHistory item) throws BloSalesV2Exception;
    
    /**
     * Metodo que recupera el historial de precios de un producto
     * @param idProduct
     * @return lista con el historial de precios
     * @throws BloSalesV2Exception
     */
    WrapperPojoIntStockPriceHistory getPriceFromProduct(long idProduct) throws BloSalesV2Exception;
    
}
