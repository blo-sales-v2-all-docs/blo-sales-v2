package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntVendor;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoVendor;
import jakarta.inject.Singleton;

@Singleton
public class PojoVendorMapper implements IToInner<PojoIntVendor, PojoVendor>, IToOuter<PojoIntVendor, PojoVendor> {

    @Override
    public PojoIntVendor toInner(PojoVendor outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntVendor();
        inner.setBrand(outer.getBrand());
        inner.setContact(outer.getContact());
        inner.setFkUser(outer.getFkUser());
        inner.setIdVendor(outer.getIdVendor());
        inner.setName(outer.getName());
        inner.setPreSale(outer.isPreSale());
        inner.setTimestamp(outer.getTimestamp());
        inner.setVisitDays(outer.getVisitDays());
        return inner;
    }

    @Override
    public PojoVendor toOuter(PojoIntVendor inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoVendor();
        outer.setBrand(inner.getBrand());
        outer.setContact(inner.getContact());
        outer.setFkUser(inner.getFkUser());
        outer.setIdVendor(inner.getIdVendor());
        outer.setName(inner.getName());
        outer.setPreSale(inner.isPreSale());
        outer.setTimestamp(inner.getTimestamp());
        outer.setVisitDays(inner.getVisitDays());
        return outer;
    }
    
}
