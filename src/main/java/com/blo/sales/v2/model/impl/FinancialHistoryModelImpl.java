package com.blo.sales.v2.model.impl;

import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntFinancialHistory;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.model.IFinancialHistoryModel;
import com.blo.sales.v2.model.mapper.FinancialMovementEntityMapper;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class FinancialHistoryModelImpl implements IFinancialHistoryModel {
    
    private static final GUILogger logger = GUILogger.getLogger(FinancialHistoryModelImpl.class.getName());
    
    @Inject
    private IDBTransactionManagerModel transactionManagerModel;
    
    @Inject
    private FinancialMovementEntityMapper financialMovementMapper;

    @Override
    public PojoIntFinancialMovement addMovement(PojoIntFinancialMovement movement) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WrapperPojoIntFinancialHistory retrieveFinancialHistoryByAccountId(long accountId) throws BloSalesV2Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
