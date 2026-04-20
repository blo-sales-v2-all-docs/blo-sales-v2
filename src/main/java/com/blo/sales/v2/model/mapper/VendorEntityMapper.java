package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntVendor;
import com.blo.sales.v2.model.entities.VendorEntity;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class VendorEntityMapper implements IToInner<VendorEntity, PojoIntVendor>, IToOuter<VendorEntity, PojoIntVendor> {

    @Override
    public VendorEntity toInner(PojoIntVendor outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new VendorEntity();
        inner.setName(outer.getName());
        inner.setBrand(outer.getBrand());
        inner.setContact(outer.getContact());
        inner.setFk_user(outer.getFkUser());
        inner.setId_vendor(outer.getIdVendor());
        inner.setPre_sale(outer.isPreSale());
        inner.setTimestamp(outer.getTimestamp());
        inner.setVisit_days(outer.getVisitDays());
        return inner;
    }

    @Override
    public PojoIntVendor toOuter(VendorEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntVendor();
        outer.setBrand(inner.getBrand());
        outer.setName(inner.getName());
        outer.setContact(inner.getContact());
        outer.setFkUser(inner.getFk_user());
        outer.setIdVendor(inner.getId_vendor());
        outer.setPreSale(inner.isPre_sale());
        outer.setTimestamp(inner.getTimestamp());
        outer.setVisitDays(inner.getVisit_days());
        return outer;
    }
    
}
