package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoMobileCompany;
import jakarta.inject.Singleton;

@Singleton
public class PojoMobileCompanyMapper implements IToInner<PojoIntMobileCompany, PojoMobileCompany>, IToOuter<PojoIntMobileCompany, PojoMobileCompany> {
    
    @Override
    public PojoIntMobileCompany toInner(PojoMobileCompany outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntMobileCompany();
        inner.setIdMobileCompany(outer.getIdMobileCompany());
        inner.setMobileCompany(outer.getMobileCompany());
        return inner;
    }

    @Override
    public PojoMobileCompany toOuter(PojoIntMobileCompany inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoMobileCompany();
        outer.setIdMobileCompany(inner.getIdMobileCompany());
        outer.setMobileCompany(inner.getMobileCompany());
        return outer;
    }
    
}
