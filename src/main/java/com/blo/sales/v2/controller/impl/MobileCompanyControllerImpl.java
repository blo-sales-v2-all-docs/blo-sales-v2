package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
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
    
    @Inject
    private IDBTransactionManagerController dbtc;

    @Override
    public WrapperPojoIntMobilesCompanies getMobilesCompanies() throws BloSalesV2Exception {
        logger.info("Recuperando todas las companias");
        return model.getMobilesCompanies();
    }

    @Override
    public PojoIntMobileCompany createMobileCompany(PojoIntMobileCompany company) throws BloSalesV2Exception {
        try {
            dbtc.disableAutocommit();
            logger.info("Creando compania %s", String.valueOf(company));
            final var companyCreated = model.createMobileCompany(company);
            dbtc.doCommit();
            logger.info("Compania creada");
            return companyCreated;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbtc.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtc.enableAutocommit();
        }
    }

    @Override
    public PojoIntMobileCompany getCompanyMobileById(long id) throws BloSalesV2Exception {
        logger.info("Recuperando compania por %s", id);
        return model.getCompanyMobileById(id);
    }

    @Override
    public PojoIntMobileCompany updateCompanyMobile(PojoIntMobileCompany companyData, long id) throws BloSalesV2Exception {
        try {
            dbtc.disableAutocommit();
            logger.info("Actualizando company %s [%s]", id, String.valueOf(companyData));
            final var companyUpdated = model.updateCompanyMobile(companyData, id);
            dbtc.doCommit();
            logger.info("compania actualizada");
            return companyUpdated;
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            dbtc.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            dbtc.enableAutocommit();
        }
    }
    
}
