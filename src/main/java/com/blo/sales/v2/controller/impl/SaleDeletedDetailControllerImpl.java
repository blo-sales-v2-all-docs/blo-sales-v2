package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.ISaleDeletedDetailController;
import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSalesDeletedDetails;
import com.blo.sales.v2.model.ISaleDeletedDetailModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SaleDeletedDetailControllerImpl implements ISaleDeletedDetailController {
    
    private static final GUILogger logger = GUILogger.getLogger(SaleDeletedDetailControllerImpl.class.getName());
    
    @Inject
    private ISaleDeletedDetailModel model;

    @Inject
    private IDBTransactionManagerController transactionManagerController;
    
    @Override
    public PojoIntSaleDeletedDetail addSaleDeletedDetail(PojoIntSaleDeletedDetail detail) throws BloSalesV2Exception {
        logger.info("Guardando rzon de baja %s", String.valueOf(detail));
        transactionManagerController.disableAutocommit();
        return model.addSaleDeletedDetail(detail);
    }

    @Override
    public WrapperPojoIntSalesDeletedDetails getSalesDeleted() throws BloSalesV2Exception {
        logger.info("recuperando ventas canceladas");
        return model.getSalesDeleted();
    }
    
}
