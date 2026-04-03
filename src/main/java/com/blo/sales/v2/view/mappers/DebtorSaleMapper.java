package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoDebtorSale;
import jakarta.inject.Singleton;

@Singleton
public class DebtorSaleMapper implements IToInner<PojoIntDebtorSale, PojoDebtorSale>, IToOuter<PojoIntDebtorSale, PojoDebtorSale> {
    
    @Override
    public PojoIntDebtorSale toInner(PojoDebtorSale outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntDebtorSale();
        inner.setFkDebtor(outer.getFkDebtor());
        inner.setFkSale(outer.getFkSale());
        inner.setIdDebtorSale(outer.getIdDebtorSale());
        inner.setTimestamp(outer.getTimestamp());
        return inner;
    }

    @Override
    public PojoDebtorSale toOuter(PojoIntDebtorSale inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoDebtorSale();
        outer.setFkDebtor(inner.getFkDebtor());
        outer.setFkSale(inner.getFkSale());
        outer.setIdDebtorSale(inner.getIdDebtorSale());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
