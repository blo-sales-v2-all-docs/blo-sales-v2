package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntVendors;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Controlador para operaciones de proveedores
 * @version 1.0.0
 * @author BLO
 */
public interface IVendorsController {
    
    /**
     * Metodo que agrega un nuevo proveedor
     * @param vendor
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntVendor addVendor(PojoIntVendor vendor) throws BloSalesV2Exception;
    
    /**
     * Recupera un proveedor por su contacto
     * @param contact
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntVendor getVendorByContact(String contact) throws BloSalesV2Exception;
    
    /**
     * Recupera un proveedor por id
     * @param id
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntVendor getVendorById(long id) throws BloSalesV2Exception;
    
    /**
     * Recupera todos los proveedores
     * @return
     * @throws BloSalesV2Exception 
     */
    WrapperPojoIntVendors getAllVendors() throws BloSalesV2Exception;
    
    /**
     * Actualiza la informacion de un proveedor
     * @param vendorData
     * @param idVendor
     * @return
     * @throws BloSalesV2Exception 
     */
    PojoIntVendor updateVendor(PojoIntVendor vendorData, long idVendor) throws BloSalesV2Exception;
    
}
