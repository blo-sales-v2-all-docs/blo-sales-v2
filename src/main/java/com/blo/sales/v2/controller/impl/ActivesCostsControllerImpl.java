package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IActivesCostsController;
import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntActivesCosts;
import com.blo.sales.v2.model.IActivesCostsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ActivesCostsControllerImpl implements IActivesCostsController {
    
    private static final GUILogger log = GUILogger.getLogger(ActivesCostsControllerImpl.class.getName());
    
    @Inject
    private IActivesCostsModel model;
    
    @Inject
    private IDBTransactionManagerController dbtm;
    
    @Override
    public WrapperPojoIntActivesCosts addActiveCost(WrapperPojoIntActivesCosts activeCost) throws BloSalesV2Exception {
        log.info("guardando activos y costos %s", activeCost.getActivesCosts().size());
        dbtm.disableAutocommit();
        return model.addActiveCost(activeCost);
    }
    
}
