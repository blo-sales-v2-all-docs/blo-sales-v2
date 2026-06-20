package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IFinancialHistoryController;
import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntFinancialHistory;
import com.blo.sales.v2.model.IFinancialHistoryModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class FinancialHistoryControllerImpl implements IFinancialHistoryController {
    
    private static final GUILogger logger = GUILogger.getLogger(FinancialHistoryControllerImpl.class.getName());
    
    @Inject
    private IFinancialHistoryModel model;

    @Override
    public PojoIntFinancialMovement addMovement(PojoIntFinancialMovement movement) throws BloSalesV2Exception {
        logger.info("guardando movimiento en historial");
        return model.addMovement(movement);
    }

    @Override
    public WrapperPojoIntFinancialHistory retrieveFinancialHistoryByAccountId(long accountId) throws BloSalesV2Exception {
        logger.info("recuperando historial de movimientos de %s", accountId);
        return model.retrieveFinancialHistoryByAccountId(accountId);
    }
    
}
