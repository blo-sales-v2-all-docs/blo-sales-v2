package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntFinancialHistory;
import com.blo.sales.v2.model.entities.WrapperFinancialHistoryEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperFinancialMovementEntityMapper implements IToOuter<WrapperFinancialHistoryEntity, WrapperPojoIntFinancialHistory> {
    
    @Inject
    private FinancialMovementEntityMapper mapper;

    @Override
    public WrapperPojoIntFinancialHistory toOuter(WrapperFinancialHistoryEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntFinancialHistory();
        final var lst = new ArrayList<PojoIntFinancialMovement>();
        if (inner.getHistory() != null && !inner.getHistory().isEmpty()) {
            inner.getHistory().forEach(h -> lst.add(mapper.toOuter(h)));
        }
        outer.setHistorial(lst);
        return outer;
        
        
    }
    
}
