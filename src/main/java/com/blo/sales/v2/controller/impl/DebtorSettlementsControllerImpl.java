package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.IDebtorSettlementsController;
import com.blo.sales.v2.controller.pojos.PojoIntDebtSettlement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtSettlement;
import com.blo.sales.v2.model.IDebtorSettlementsModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class DebtorSettlementsControllerImpl implements IDebtorSettlementsController {
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorSettlementsControllerImpl.class.getName());

    @Inject
    private IDBTransactionManagerController dbtm;
    
    @Inject
    private IDebtorSettlementsModel model;
    
    @Override
    public PojoIntDebtSettlement addSettlement(PojoIntDebtSettlement settlement) throws BloSalesV2Exception {
        logger.info("guardando informacion del pago");
        dbtm.disableAutocommit();
        final var debtorName = settlement.getFkSale() + BloSalesV2Utils.EMPTY_STRING.concat("-").concat(settlement.getDebtor());
        settlement.setDebtor(debtorName);
        return model.addSettlement(settlement);
    }

    @Override
    public WrapperPojoIntDebtSettlement getDebtorsPaymentsHistory() throws BloSalesV2Exception {
        logger.info("recuperando informacion de pagos");
        return model.getDebtorsPaymentsHistory();
    }
    
}
