package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntDebtSettlement;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoDebtSettlement;
import jakarta.inject.Singleton;

@Singleton
public class PojoDebtSettlementMapper implements IToOuter<PojoIntDebtSettlement, PojoDebtSettlement> {

    @Override
    public PojoDebtSettlement toOuter(PojoIntDebtSettlement inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoDebtSettlement();
        outer.setDebtor(inner.getDebtor());
        outer.setFkSale(inner.getFkSale());
        outer.setIdDebtSettlement(inner.getIdDebtSettlement());
        outer.setPayments(inner.getPayments());
        outer.setProductsDetails(inner.getProductsDetails());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
