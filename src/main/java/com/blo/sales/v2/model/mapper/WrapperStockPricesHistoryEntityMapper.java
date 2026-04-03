package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntStockPriceHistory;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntStockPriceHistory;
import com.blo.sales.v2.model.entities.WrapperStockPricesHistoryEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperStockPricesHistoryEntityMapper implements IToOuter<WrapperStockPricesHistoryEntity, WrapperPojoIntStockPriceHistory> {
    
    @Inject
    private StockPriceHistoryEntityMapper mapper;

    @Override
    public WrapperPojoIntStockPriceHistory toOuter(WrapperStockPricesHistoryEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntStockPriceHistory();
        final var items = new ArrayList<PojoIntStockPriceHistory>();
        if (inner.getHistory() != null && !inner.getHistory().isEmpty()) {
            inner.getHistory().forEach(i -> items.add(mapper.toOuter(i)));
        }
        outer.setHistory(items);
        return outer;
    }
    
}
