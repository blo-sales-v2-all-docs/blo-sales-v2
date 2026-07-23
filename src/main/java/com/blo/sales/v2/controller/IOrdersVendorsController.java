package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import java.math.BigDecimal;

/**
 * Clase controlador para movimientos de proveedores
 * @author BLO
 * @version 1.0.2
 */
public interface IOrdersVendorsController {
    
    /**
     * Funcion que da de alta una orden
     * @param order
     * @return 
     * @throws com.blo.sales.v2.utils.BloSalesV2Exception 
     */
    PojoIntOrderVendor highOrder(PojoIntOrderVendor order) throws BloSalesV2Exception;
    
    /**
     * Funcion que cierra un pedido
     * @param reason
     * @param amount
     * @param brand
     * @param invoice
     * @param idUser
     * @param idOrder
     * @param productsInfo
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntOrderVendor closeOrder(StatusMovementProviderIntEnum reason, BigDecimal amount, String brand, String invoice, long idUser, long idOrder, String productsInfo) throws BloSalesV2Exception;
    
    /**
     * Funcion que recupera ordenes por un status
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
