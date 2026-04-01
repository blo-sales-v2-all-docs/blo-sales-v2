package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntStockPriceHistory;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoStockPriceHistory;
import jakarta.inject.Singleton;

@Singleton
public class PojoStockPriceHistoryMapper implements IToOuter<PojoIntStockPriceHistory, PojoStockPriceHistory> {
    
    @Override
    public PojoStockPriceHistory toOuter(PojoIntStockPriceHistory inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoStockPriceHistory();
        outer.setCostOfSale(inner.getCostOfSale());
        outer.setId_stock_price_history(inner.getIdStockPriceHistory());
        outer.setPrice(inner.getPrice());
        outer.setProduct(inner.getProduct());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
