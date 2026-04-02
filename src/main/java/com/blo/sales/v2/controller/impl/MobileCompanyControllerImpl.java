package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IMobileCompanyController;
import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMobilesCompanies;
import com.blo.sales.v2.model.IMobileCompanyModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class MobileCompanyControllerImpl implements IMobileCompanyController {
    
    private static final GUILogger logger = GUILogger.getLogger(MobileCompanyControllerImpl.class.getName());
    
    @Inject
    private IMobileCompanyModel model;

    @Override
    public WrapperPojoIntMobilesCompanies getMobilesCompanies() throws BloSalesV2Exception {
        logger.info("Recuperando todas las companias");
        return model.getMobilesCompanies();
    }

    @Override
    public PojoIntMobileCompany createMobileCompany(PojoIntMobileCompany company) throws BloSalesV2Exception {
        logger.info("Creando compania %s", String.valueOf(company));
        return model.createMobileCompany(company);
    }

    @Override
    public PojoIntMobileCompany getCompanyMobileById(long id) throws BloSalesV2Exception {
        logger.info("Recuperando compania por %s", id);
        return model.getCompanyMobileById(id);
    }

    @Override
    public PojoIntMobileCompany updateCompanyMobile(PojoIntMobileCompany companyData, long id) throws BloSalesV2Exception {
        logger.info("Actualizando company %s [%s]", id, String.valueOf(companyData));
        return model.updateCompanyMobile(companyData, id);
    }
    
}
