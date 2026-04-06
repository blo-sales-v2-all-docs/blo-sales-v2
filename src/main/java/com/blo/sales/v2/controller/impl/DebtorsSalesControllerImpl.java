package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IDebtorsSalesController;
import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.model.IDebtorsSalesModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class DebtorsSalesControllerImpl implements IDebtorsSalesController {
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorsSalesControllerImpl.class.getName());
    
    @Inject
    private IDebtorsSalesModel model;
    
    @Inject
    private IDBTransactionManagerController idbtm;

    @Override
    public PojoIntDebtorSale addRelationship(PojoIntDebtorSale debtor) throws BloSalesV2Exception {
        logger.info("gurdando relacion %s", String.valueOf(debtor));
        idbtm.disableAutocommit();
        return model.addRelationship(debtor);
    }

    @Override
    public void deleteRelationhip(long fkDebtor) throws BloSalesV2Exception {
        logger.info("eliminando relacion deudor %s", fkDebtor);
        idbtm.disableAutocommit();
        model.deleteRelationhip(fkDebtor);
    }
    
}
