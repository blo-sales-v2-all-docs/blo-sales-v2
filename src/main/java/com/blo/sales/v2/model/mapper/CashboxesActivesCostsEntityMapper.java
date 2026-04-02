package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxesActivesCosts;
import com.blo.sales.v2.model.entities.CashboxesActivesCostsEntity;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class CashboxesActivesCostsEntityMapper implements 
        IToInner<CashboxesActivesCostsEntity, PojoIntCashboxesActivesCosts>,
        IToOuter<CashboxesActivesCostsEntity, PojoIntCashboxesActivesCosts> {
    
    @Override
    public CashboxesActivesCostsEntity toInner(PojoIntCashboxesActivesCosts outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new CashboxesActivesCostsEntity();
        inner.setFk_actives_costs(outer.getFkActivesCosts());
        inner.setFk_cashbox(outer.getFkCashbox());
        inner.setTimestamp(outer.getTimestamp());
        inner.setId_cashboxes_actives_costs(outer.getIdCashboxesActivesCosts());
        return inner;
    }

    @Override
    public PojoIntCashboxesActivesCosts toOuter(CashboxesActivesCostsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntCashboxesActivesCosts();
        outer.setFkActivesCosts(inner.getFk_actives_costs());
        outer.setFkCashbox(inner.getFk_cashbox());
        outer.setIdCashboxesActivesCosts(inner.getId_cashboxes_actives_costs());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
