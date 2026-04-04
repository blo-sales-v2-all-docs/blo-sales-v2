package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntSaleProduct;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSaleStock;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para guardar detalles de venta
 * @version 1.0.0
 * @author BLO
 */
public interface ISalesProductController {
    
    /**
     * Guarda la relacion venta producto con toda la informacion de la venta y producto
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param salesProduct
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntSaleProduct addSalesProduct(PojoIntSaleProduct salesProduct) throws BloSalesV2Exception;
    
    PojoIntSaleProduct getRelationship(long idSale, long idProduct) throws BloSalesV2Exception;
    
    PojoIntSaleProduct updateRelationship(PojoIntSaleProduct data) throws BloSalesV2Exception;
    
    WrapperPojoIntSaleStock getSalesStockLiveByIdSale(long idSale) throws BloSalesV2Exception;
}
