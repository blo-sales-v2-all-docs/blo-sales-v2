package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntSaleProduct;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSaleStock;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones en la bd con la informacion de la venta / producto
 * @version 1.0.0
 * @author BLO
 */
public interface ISaleProductModel {
    
    /**
     * Guarda la relacion venta producto en la bd con la informacion del producto y de la venta
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param sale
     * @return relacion guardada
     * @throws BloSalesV2Exception 
     */
    PojoIntSaleProduct addSaleProduct(PojoIntSaleProduct sale) throws BloSalesV2Exception;
    
    PojoIntSaleProduct getRelationship(long fkSale, long fkProduct) throws BloSalesV2Exception;
    
    PojoIntSaleProduct updateRelationship(PojoIntSaleProduct data) throws BloSalesV2Exception;
    
    WrapperPojoIntSaleStock getSalesStockLiveByIdSale(long idSale) throws BloSalesV2Exception;
    
}
