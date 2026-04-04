package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.ISalesProductController;
import com.blo.sales.v2.controller.pojos.PojoIntSaleProduct;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSaleStock;
import com.blo.sales.v2.model.ISaleProductModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

public @Singleton class SalesProductControllerImpl implements ISalesProductController {
    
    private static final GUILogger logger = GUILogger.getLogger(SalesProductControllerImpl.class.getName());
    
    @Inject
    private ISaleProductModel model;
    
    @Override
    public PojoIntSaleProduct addSalesProduct(PojoIntSaleProduct salesProduct) throws BloSalesV2Exception {
        logger.info("guardando relacion venta producto");
        return model.addSaleProduct(salesProduct);
    }

    @Override
    public PojoIntSaleProduct getRelationship(long idSale, long idProduct) throws BloSalesV2Exception {
        logger.info("recuperando relacion");
        return model.getRelationship(idSale, idProduct);
    }

    @Override
    public PojoIntSaleProduct updateRelationship(PojoIntSaleProduct data) throws BloSalesV2Exception {
        logger.info("Actualizando relacion");
        return model.updateRelationship(data);
    }

    @Override
    public WrapperPojoIntSaleStock getSalesStockLiveByIdSale(long idSale) throws BloSalesV2Exception {
        logger.info("recuperando todas las ventas de %s", idSale);
        return model.getSalesStockLiveByIdSale(idSale);
    }
    
}
