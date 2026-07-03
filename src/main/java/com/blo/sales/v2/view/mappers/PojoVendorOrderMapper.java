package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoOrderVendor;
import com.blo.sales.v2.view.pojos.enums.StatusOrderProviderEnum;
import jakarta.inject.Singleton;

@Singleton
public class PojoVendorOrderMapper implements IToInner<PojoIntOrderVendor, PojoOrderVendor>, IToOuter<PojoIntOrderVendor, PojoOrderVendor> {

    @Override
    public PojoIntOrderVendor toInner(PojoOrderVendor outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntOrderVendor();
        inner.setAmount(outer.getAmount());
        inner.setDeadline(outer.getDeadline());
        inner.setFkVendor(outer.getFkVendor());
        inner.setIdOrderVendor(outer.getIdOrderVendor());
        inner.setInvoice(outer.getInvoice());
        inner.setStatusOrder(StatusMovementProviderIntEnum.valueOf(outer.getStatusOrder().name()));
        inner.setTimestamp(outer.getTimestamp());
        inner.setVendorName(outer.getVendorName());
        inner.setBrand(outer.getBrand());
        inner.setProductsInfo(outer.getProductsInfo());
        return inner;
    }

    @Override
    public PojoOrderVendor toOuter(PojoIntOrderVendor inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoOrderVendor();
        outer.setAmount(inner.getAmount());
        outer.setDeadline(inner.getDeadline());
        outer.setFkVendor(inner.getFkVendor());
        outer.setIdOrderVendor(inner.getIdOrderVendor());
        outer.setInvoice(inner.getInvoice());
        outer.setStatusOrder(StatusOrderProviderEnum.valueOf(inner.getStatusOrder().name()));
        outer.setTimestamp(inner.getTimestamp());
        outer.setVendorName(inner.getVendorName());
        outer.setBrand(inner.getBrand());
        outer.setProductsInfo(inner.getProductsInfo());
        return outer;
    }
    
}
