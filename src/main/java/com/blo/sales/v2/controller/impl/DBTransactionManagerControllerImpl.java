package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.model.IDBTransactionManagerModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

public @Singleton class DBTransactionManagerControllerImpl implements IDBTransactionManagerController {
    
    @Inject
    private IDBTransactionManagerModel model;

    @Override
    public void disableAutocommit() throws BloSalesV2Exception {
        model.disableAutocommit();
    }

    @Override
    public void doCommit() throws BloSalesV2Exception {
        model.doCommit();
    }

    @Override
    public void enableAutocommit() throws BloSalesV2Exception {
        model.enableAutocommit();
    }
    
}
