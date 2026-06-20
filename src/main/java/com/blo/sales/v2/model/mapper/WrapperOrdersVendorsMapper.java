package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntOrderVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.model.entities.WrapperOrdersVendorsEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperOrdersVendorsMapper implements IToOuter<WrapperOrdersVendorsEntity, WrapperPojoIntOrdersVendors> {
    
    @Inject
    private OrderVendorEntityMapper mapper;

    @Override
    public WrapperPojoIntOrdersVendors toOuter(WrapperOrdersVendorsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntOrdersVendors();
        final var items = new ArrayList<PojoIntOrderVendor>();
        if (inner.getOrders() != null && !inner.getOrders().isEmpty()) {
            inner.getOrders().forEach(o -> items.add(mapper.toOuter(o)));
        }
        outer.setOrders(items);
        return outer;
    }

    
}
