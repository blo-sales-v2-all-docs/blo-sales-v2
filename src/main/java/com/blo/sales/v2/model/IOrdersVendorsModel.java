package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones de los proveedores en la db
 * @author BLO
 * @version 1.0.1
 */
public interface IOrdersVendorsModel {
    
    /**
     * Funcion que guarda un movimiento de proveedor en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param movement
     * @return 
     * @throws com.blo.sales.v2.utils.BloSalesV2Exception 
     */
    PojoIntOrderVendor addOrder(PojoIntOrderVendor movement) throws BloSalesV2Exception;
    
    /**
     * Funcion que actualiza una orden de proveedor en la db
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
     * @param order
     * @return 
     * @throws com.blo.sales.v2.utils.BloSalesV2Exception 
     */
    PojoIntOrderVendor updateOrder(PojoIntOrderVendor order) throws BloSalesV2Exception;
    
    /**
     * Funcion que recupera todas las ordenes
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntOrdersVendors getOrders() throws BloSalesV2Exception;
    
    /**
     * Funcion que recupera una orden por id
     * @param idOrder
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntOrderVendor getOrderById(long idOrder) throws BloSalesV2Exception;
    
}
