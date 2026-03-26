package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDebtorsSalesController;
import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.model.IDebtorsSalesModel;
import com.blo.sales.v2.model.impl.DebtorsSalesModelImpl;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;

public class DebtorsSalesControllerImpl implements IDebtorsSalesController {
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorsSalesControllerImpl.class.getName());
    
    private static DebtorsSalesControllerImpl instance;
    
    private static final IDebtorsSalesModel model = DebtorsSalesModelImpl.getInstance();
    
    private DebtorsSalesControllerImpl() { }
    
    public static DebtorsSalesControllerImpl getInstance() {
        if (instance == null) {
            instance = new DebtorsSalesControllerImpl();
        }
        return instance;
    }

    @Override
    public PojoIntDebtorSale addRelationship(PojoIntDebtorSale debtor) throws BloSalesV2Exception {
        logger.info("gurdando relacion %s", String.valueOf(debtor));
        return model.addRelationship(debtor);
    }

    @Override
    public void deleteRelationhip(long fkDebtor) throws BloSalesV2Exception {
        logger.info("eliminando relacion deudor %s", fkDebtor);
        model.deleteRelationhip(fkDebtor);
    }
    
}
