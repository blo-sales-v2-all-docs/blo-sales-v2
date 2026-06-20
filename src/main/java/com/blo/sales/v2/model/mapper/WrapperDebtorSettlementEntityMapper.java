package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntDebtSettlement;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtSettlement;
import com.blo.sales.v2.model.entities.WrapperDebtorSettlementEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperDebtorSettlementEntityMapper implements IToOuter<WrapperDebtorSettlementEntity, WrapperPojoIntDebtSettlement> {
    
    @Inject
    private DebtorSettlementEntityMapper mapper;

    @Override
    public WrapperPojoIntDebtSettlement toOuter(WrapperDebtorSettlementEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntDebtSettlement();
        final var lst = new ArrayList<PojoIntDebtSettlement>();
        if (inner.getDebtor_settlements() != null && !inner.getDebtor_settlements().isEmpty()) {
            inner.getDebtor_settlements().forEach(ds -> lst.add(mapper.toOuter(ds)));
        }
        outer.setDebtSettlements(lst);
        return outer;
    }
    
}
