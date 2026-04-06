package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMobilesCompanies;
import com.blo.sales.v2.utils.BloSalesV2Exception;

/**
 * Interfaz controlador para companias telefonicas
 * @version 1.0.0
 * @author BLO
 */
public interface IMobileCompanyController {
    
    WrapperPojoIntMobilesCompanies getMobilesCompanies() throws BloSalesV2Exception;
    
    /**
     * Crea una nueva compania telefonica
     * @param company
     * @return compania telefonica creada
     * @throws BloSalesV2Exception 
     */
    PojoIntMobileCompany createMobileCompany(PojoIntMobileCompany company) throws BloSalesV2Exception;
    
    /**
     * Recupera una compania telefonica
     * @param id
     * @return compania telefonica
     * @throws BloSalesV2Exception 
     */
    PojoIntMobileCompany getCompanyMobileById(long id) throws BloSalesV2Exception;
    
    /**
     * Actualiza una compania telefonica por id
     * @param companyData
     * @param id
     * @return compania actualizada
     * @throws BloSalesV2Exception 
     */
    PojoIntMobileCompany updateCompanyMobile(PojoIntMobileCompany companyData, long id) throws BloSalesV2Exception;
}
