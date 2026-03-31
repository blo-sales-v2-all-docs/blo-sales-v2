package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.ICashboxesSalesController;
import com.blo.sales.v2.controller.pojos.PojoIntCashboxSale;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesSalesDetails;
import com.blo.sales.v2.model.ICashboxesSalesModel;
import com.blo.sales.v2.model.impl.CashboxesSalesModelImpl;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;

public class CashboxesSalesControllerImpl implements ICashboxesSalesController {
    
    private static final GUILogger logger = GUILogger.getLogger(CashboxesSalesControllerImpl.class.getName());
    
    private static final ICashboxesSalesModel cashboxSalesModel = CashboxesSalesModelImpl.getInstance();
    
    private static CashboxesSalesControllerImpl instance;
    
    private CashboxesSalesControllerImpl() { }
    
    public static CashboxesSalesControllerImpl getInstance() {
        if (instance == null) {
            instance = new CashboxesSalesControllerImpl();
        }
        return instance;
    }

    @Override
    public PojoIntCashboxSale addCashboxSale(long idCashbox, long idSale) throws BloSalesV2Exception {
        logger.info("Guardando relacion cashbox [%s] - sale [%s]", idCashbox, idSale);
        return cashboxSalesModel.addCashboxSale(idCashbox, idSale);
    }

    @Override
    public WrapperPojoIntCashboxesSalesDetails getCashboxSalesDetailById(long idCashbox) throws BloSalesV2Exception {
        logger.info("recuperando detalles de cashbox %s", idCashbox);
        return cashboxSalesModel.getCashboxSalesDetailById(idCashbox);
    }
    
}
