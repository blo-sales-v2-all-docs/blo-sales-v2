package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtSettlement;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoDebtSettlement;
import com.blo.sales.v2.view.pojos.WrapperPojoDebtSettlement;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoDebtorSettlementsMapper implements IToOuter<WrapperPojoIntDebtSettlement, WrapperPojoDebtSettlement> {
    
    @Inject
    private PojoDebtSettlementMapper mapper;

    @Override
    public WrapperPojoDebtSettlement toOuter(WrapperPojoIntDebtSettlement inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoDebtSettlement();
        final var lst = new ArrayList<PojoDebtSettlement>();
        if (inner.getDebtSettlements() != null && !inner.getDebtSettlements().isEmpty()) {
            inner.getDebtSettlements().forEach(ds -> lst.add(mapper.toOuter(ds)));
        }
        outer.setDebtSettlements(lst);
        return outer;
    }
    
}
