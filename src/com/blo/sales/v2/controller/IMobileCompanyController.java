package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMobilesCompanies;
import com.blo.sales.v2.utils.BloSalesV2Exception;

public interface IMobileCompanyController {
    
    WrapperPojoIntMobilesCompanies getMobilesCompanies() throws BloSalesV2Exception;
    
    PojoIntMobileCompany createMobileCompany(PojoIntMobileCompany company) throws BloSalesV2Exception;
    
    PojoIntMobileCompany getCompanyMobileById(long id) throws BloSalesV2Exception;
    
    PojoIntMobileCompany updateCompanyMobile(PojoIntMobileCompany companyData, long id) throws BloSalesV2Exception;
}
