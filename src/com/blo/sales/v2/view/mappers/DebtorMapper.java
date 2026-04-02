package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntDebtor;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoDebtor;
import jakarta.inject.Singleton;

@Singleton
public class DebtorMapper implements IToInner<PojoIntDebtor, PojoDebtor>, IToOuter<PojoIntDebtor, PojoDebtor> {

    @Override
    public PojoIntDebtor toInner(PojoDebtor outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntDebtor();
        inner.setIdDebtor(outer.getIdDebtor());
        inner.setName(outer.getName());
        inner.setPayments(outer.getPayments());
        inner.setDebt(outer.getDebt());
        inner.setIdSale(outer.getIdSale());
        return inner;
    }

    @Override
    public PojoDebtor toOuter(PojoIntDebtor inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoDebtor();
        outer.setIdDebtor(inner.getIdDebtor());
        outer.setName(inner.getName());
        outer.setPayments(inner.getPayments());
        outer.setDebt(inner.getDebt());
        outer.setIdSale(inner.getIdSale());
        return outer;
    }
    
}
