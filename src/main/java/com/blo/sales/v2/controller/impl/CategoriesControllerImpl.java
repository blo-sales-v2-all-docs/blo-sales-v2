package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.pojos.PojoIntCategory;
import com.blo.sales.v2.model.ICategoriesModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.controller.ICategoriesController;
import com.blo.sales.v2.controller.IDBTransactionManagerController;
import com.blo.sales.v2.controller.pojos.WrapperIntPojoCategories;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;

import jakarta.inject.Singleton;

public @Singleton class CategoriesControllerImpl implements ICategoriesController {
    
    private static final GUILogger logger = GUILogger.getLogger(CategoriesControllerImpl.class.getName());
    
    @Inject
    private ICategoriesModel categoriesModel;
    
    @Inject
    private IDBTransactionManagerController transactionController;
    
    @Override
    public PojoIntCategory registerCategory(PojoIntCategory category) throws BloSalesV2Exception {
        try {
            logger.info("guardando categoria [%s]", String.valueOf(category));
            transactionController.disableAutocommit();
            final var savedCategory = categoriesModel.registerCategory(category);
            transactionController.doCommit();
            return savedCategory;
        } catch (BloSalesV2Exception ex) {
            transactionController.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            transactionController.enableAutocommit();
        }
    }

    @Override
    public WrapperIntPojoCategories getAllCategories() throws BloSalesV2Exception {
        logger.info("recuperando todas las categorias");
        return categoriesModel.getAllCategories();
    }

    @Override
    public PojoIntCategory updateCategory(long id, PojoIntCategory newData) throws BloSalesV2Exception {
        try {
            transactionController.disableAutocommit();
            logger.info("actualizando categoria %s por id = %s", String.valueOf(newData), id);
            final var updatedCategory = categoriesModel.updateCategory(id, newData);
            transactionController.doCommit();
            return updatedCategory;
        } catch (BloSalesV2Exception ex) {
            transactionController.doRollback();
            throw new BloSalesV2Exception(ex.getCode(), ex.getMessage());
        } finally {
            transactionController.enableAutocommit();
        }
    }

    @Override
    public PojoIntCategory getCategoryById(long id) throws BloSalesV2Exception {
        logger.info("recuperando categoria %s", id);
        return categoriesModel.getCategoryById(id);
    }
    
}
