package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntOrdersVendors;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoOrderVendor;
import com.blo.sales.v2.view.pojos.WrapperPojoOrdersVendors;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoVendorsOrdersMapper implements IToOuter<WrapperPojoIntOrdersVendors, WrapperPojoOrdersVendors> {

    @Inject
    private PojoVendorOrderMapper mapper;
    
    @Override
    public WrapperPojoOrdersVendors toOuter(WrapperPojoIntOrdersVendors inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoOrdersVendors();
        final var orders = new ArrayList<PojoOrderVendor>();
        if (inner.getOrders() != null && !inner.getOrders().isEmpty()) {
            inner.getOrders().forEach(o -> orders.add(mapper.toOuter(o)));
        }
        outer.setOrders(orders);
        return outer;
    }
    
}
