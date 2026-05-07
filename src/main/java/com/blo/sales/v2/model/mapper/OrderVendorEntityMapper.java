package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.model.entities.OrderVendorEntity;
import com.blo.sales.v2.model.entities.enums.StatusOrderVendorEntityEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class OrderVendorEntityMapper implements 
        IToInner<OrderVendorEntity, PojoIntOrderVendor>, 
        IToOuter<OrderVendorEntity, PojoIntOrderVendor>{

    @Override
    public OrderVendorEntity toInner(PojoIntOrderVendor outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new OrderVendorEntity();
        inner.setAmount(outer.getAmount());
        inner.setFk_vendor(outer.getFkVendor());
        inner.setId_order_vendor(outer.getIdOrderVendor());
        inner.setInvoice(outer.getInvoice());
        inner.setStatus_order(StatusOrderVendorEntityEnum.valueOf(outer.getStatusOrder().name()));
        inner.setTimestamp(outer.getTimestamp());
        inner.setDeadline(outer.getDeadline());
        inner.setName(outer.getVendorName());
        inner.setBrand(outer.getBrand());
        return inner;
    }

    @Override
    public PojoIntOrderVendor toOuter(OrderVendorEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntOrderVendor();
        outer.setAmount(inner.getAmount());
        outer.setFkVendor(inner.getFk_vendor());
        outer.setIdOrderVendor(inner.getId_order_vendor());
        outer.setInvoice(inner.getInvoice());
        outer.setStatusOrder(StatusMovementProviderIntEnum.valueOf(inner.getStatus_order().name()));
        outer.setTimestamp(inner.getTimestamp());
        outer.setDeadline(inner.getDeadline());
        outer.setVendorName(inner.getName());
        outer.setBrand(inner.getBrand());
        return outer;
    }
    
}
