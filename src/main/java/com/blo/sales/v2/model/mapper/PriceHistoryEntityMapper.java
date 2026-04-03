package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntPriceHistory;
import com.blo.sales.v2.model.entities.PriceHistoryEntity;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class PriceHistoryEntityMapper implements IToInner<PriceHistoryEntity, PojoIntPriceHistory>, IToOuter<PriceHistoryEntity, PojoIntPriceHistory> {
    
    @Override
    public PriceHistoryEntity toInner(PojoIntPriceHistory outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PriceHistoryEntity();
        inner.setCost_of_sale(outer.getCostOfSale());
        inner.setId_price_history(outer.getIdPriceHistory());
        inner.setPrice(outer.getPrice());
        return inner;
    }

    @Override
    public PojoIntPriceHistory toOuter(PriceHistoryEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntPriceHistory();
        outer.setCostOfSale(inner.getCost_of_sale());
        outer.setIdPriceHistory(inner.getId_price_history());
        outer.setPrice(inner.getPrice());
        return outer;
    }
    
}
