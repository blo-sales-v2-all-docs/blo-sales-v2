package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.ICashboxesActivesCostsController;
import com.blo.sales.v2.controller.pojos.PojoIntCashboxesActivesCosts;
import com.blo.sales.v2.model.ICashboxesActivesCostsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CashboxesActivesCostsControllerImpl implements ICashboxesActivesCostsController {
    
    private static final GUILogger logger = GUILogger.getLogger(CashboxesActivesCostsControllerImpl.class.getName());
    
    @Inject
    private ICashboxesActivesCostsModel model;

    @Override
    public PojoIntCashboxesActivesCosts addRelationship(PojoIntCashboxesActivesCosts data) throws BloSalesV2Exception {
        logger.info("agregando relacion");
        return model.addRelationship(data);
    }
    
}
