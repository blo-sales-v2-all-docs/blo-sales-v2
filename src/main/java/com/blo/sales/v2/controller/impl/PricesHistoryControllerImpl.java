package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IPricesHistoryController;
import com.blo.sales.v2.controller.pojos.PojoIntPriceHistory;
import com.blo.sales.v2.model.IPricesHistoryModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

public @Singleton class PricesHistoryControllerImpl implements IPricesHistoryController {
    
    private static final GUILogger logger = GUILogger.getLogger(PricesHistoryControllerImpl.class.getName());
    
    @Inject
    private IPricesHistoryModel model;

    @Override
    public PojoIntPriceHistory addPriceHistory(PojoIntPriceHistory priceHistory) throws BloSalesV2Exception {
        logger.info("Guardando informacion de precio %s", String.valueOf(priceHistory));
        return model.addPriceHistory(priceHistory);
    }
    
}
