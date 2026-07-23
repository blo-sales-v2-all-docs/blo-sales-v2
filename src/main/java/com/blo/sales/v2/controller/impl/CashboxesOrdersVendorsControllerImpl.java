package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.ICashboxesOrdersVendorsController;
import com.blo.sales.v2.controller.pojos.PojoIntCashboxOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.model.ICashboxesOrdersVendorsModel;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CashboxesOrdersVendorsControllerImpl implements ICashboxesOrdersVendorsController {
    
    private static final GUILogger logger = GUILogger.getLogger(CashboxesOrdersVendorsControllerImpl.class.getName());
    
    @Inject
    private IDBTransactionManagerModel transactionManager;
    
    @Inject
    private ICashboxesOrdersVendorsModel model;

    @Override
    public PojoIntCashboxOrderVendor addCashboxOrderVendor(PojoIntCashboxOrderVendor orderVendorInfo) throws BloSalesV2Exception {
        try {
            logger.info("guardando categoria [%s]", String.valueOf(orderVendorInfo));
            transactionManager.disableAutocommit();
            final var saved = model.addCashboxOrderVendor(orderVendorInfo);
            return saved;
        } catch (BloSalesV2Exception ex) {
            transactionManager.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        }
    }

    @Override
    public WrapperPojoIntOrdersVendors getOrdersVendorByIdCashbox(long idCashox) throws BloSalesV2Exception {
        logger.info("recuperando ordenes vendor por %s id cashbox", idCashox);
        return model.getOrdersVendorByIdCashbox(idCashox);
    }
    
}
