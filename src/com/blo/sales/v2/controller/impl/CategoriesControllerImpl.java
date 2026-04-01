package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.pojos.PojoIntCategory;
import com.blo.sales.v2.model.ICategoriesModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.controller.ICategoriesController;
import com.blo.sales.v2.controller.pojos.WrapperIntPojoCategories;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;

import jakarta.inject.Singleton;

@Singleton
public class CategoriesControllerImpl implements ICategoriesController {
    
    private static final GUILogger logger = GUILogger.getLogger(CategoriesControllerImpl.class.getName());
    
    @Inject
    private ICategoriesModel categoriesModel;
    
    @Override
    public PojoIntCategory registerCategory(PojoIntCategory category) throws BloSalesV2Exception {
        logger.info("guardando categoria [%s]", String.valueOf(category));
        return categoriesModel.registerCategory(category);
    }

    @Override
    public WrapperIntPojoCategories getAllCategories() throws BloSalesV2Exception {
        logger.info("recuperando todas las categorias");
        return categoriesModel.getAllCategories();
    }

    @Override
    public PojoIntCategory updateCategory(long id, PojoIntCategory newData) throws BloSalesV2Exception {
        logger.info("actualizando categoria %s por id = %s", String.valueOf(newData), id);
        return categoriesModel.updateCategory(id, newData);
    }

    @Override
    public PojoIntCategory getCategoryById(long id) throws BloSalesV2Exception {
        logger.info("recuperando categoria %s", id);
        return categoriesModel.getCategoryById(id);
    }
    
}
