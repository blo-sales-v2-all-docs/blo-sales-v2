package com.blo.sales.v2.controller.impl;

import com.blo.sales.v2.controller.IPricesHistoryController;
import com.blo.sales.v2.controller.IStockPricesHistoryController;
import com.blo.sales.v2.controller.pojos.PojoIntPriceHistory;
import com.blo.sales.v2.controller.pojos.PojoIntStockPricesHistory;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntStockPriceHistory;
import com.blo.sales.v2.model.IStockPricesHistoryModel;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

public @Singleton class StockPricesHistoryControllerImpl implements IStockPricesHistoryController {

    private static final GUILogger logger = GUILogger.getLogger(StockPricesHistoryControllerImpl.class.getName());
    
    @Inject
    private IStockPricesHistoryModel model;
    
    @Inject
    private IPricesHistoryController pricesController;

    @Override
    public PojoIntStockPricesHistory addPriceOnHistory(PojoIntPriceHistory priceItem, long idProduct) throws BloSalesV2Exception {
        logger.info("guardando item %s", String.valueOf(priceItem));
        final var saved = pricesController.addPriceHistory(priceItem);
        logger.info("precio guardado %s", String.valueOf(saved));
        final var item = new PojoIntStockPricesHistory();
        item.setFkProduct(idProduct);
        item.setFkPriceHistory(saved.getIdPriceHistory());
        item.setTimesTamp(BloSalesV2Utils.getTimestamp());
        final var relationSaved = model.addPriceOnHistory(item);
        logger.info("item guardod [relacion precio stock] %s", String.valueOf(relationSaved));
        return relationSaved;
    }

    @Override
    public WrapperPojoIntStockPriceHistory getPriceFromProduct(long idProduct) throws BloSalesV2Exception {
        logger.info("recuperando historial de precios %s", idProduct);
        return model.getPriceFromProduct(idProduct);
    }

}
