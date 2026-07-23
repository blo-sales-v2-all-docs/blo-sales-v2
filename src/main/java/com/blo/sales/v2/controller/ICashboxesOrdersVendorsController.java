package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesOrdersVendors;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase controlador para operaciones de cashbox-orders-vendors
 * @version 1.0.0
 * @author BLO
 */
public interface ICashboxesOrdersVendorsController {
    /**
     * Metodo que se encarga de guardar la relacion entre cashbox y orden-vendedor
     * @param orderVendorInfo
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntCashboxOrderVendor addCashboxOrderVendor(PojoIntCashboxOrderVendor orderVendorInfo) throws BloSalesV2Exception;
 
    /**
     * Metodo que recupera las ordenes de relacionadas con una caja
     * @param idCashox
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntCashboxesOrdersVendors getOrdersVendorByIdCashbox(long idCashox) throws BloSalesV2Exception;
}
