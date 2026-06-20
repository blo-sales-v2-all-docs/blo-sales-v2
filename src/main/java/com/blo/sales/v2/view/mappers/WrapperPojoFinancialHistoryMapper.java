package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntFinancialHistory;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoFinancialMovement;
import com.blo.sales.v2.view.pojos.WrapperPojoFinancialHistory;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoFinancialHistoryMapper implements IToOuter<WrapperPojoIntFinancialHistory, WrapperPojoFinancialHistory> {
    
    @Inject
    private PojoFinancialMovementMapper mapper;

    @Override
    public WrapperPojoFinancialHistory toOuter(WrapperPojoIntFinancialHistory inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoFinancialHistory();
        final var lst = new ArrayList<PojoFinancialMovement>();
        if (inner.getHistorial() != null && !inner.getHistorial().isEmpty()) {
            inner.getHistorial().forEach(h -> lst.add(mapper.toOuter(h)));
        }
        outer.setHistorial(lst);
        return outer;
    }
    
}
