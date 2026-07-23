package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Clase modelo para operaciones en la bd de cashbox-orders-vendors
 * @version 1.0.0
 * @author BLO
 */
public interface ICashboxesOrdersVendorsModel {
    
    /**
     * Metodo que se encarga de guardar la relacion entre cashbox y orden-vendedor
     * <br>
     * <b>ESTA FUNCION NO GUARDA CAMBIOS EN LA BD</b>
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
    WrapperPojoIntOrdersVendors getOrdersVendorByIdCashbox(long idCashox) throws BloSalesV2Exception;
}
