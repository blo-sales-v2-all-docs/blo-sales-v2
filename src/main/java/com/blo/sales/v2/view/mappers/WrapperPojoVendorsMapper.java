package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntVendors;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoVendor;
import com.blo.sales.v2.view.pojos.WrapperPojoVendors;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoVendorsMapper implements IToOuter<WrapperPojoIntVendors, WrapperPojoVendors> {
    
    @Inject
    private PojoVendorMapper mapper;

    @Override
    public WrapperPojoVendors toOuter(WrapperPojoIntVendors inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoVendors();
        final var lst = new ArrayList<PojoVendor>();
        if (inner.getVendors() != null && !inner.getVendors().isEmpty()) {
            inner.getVendors().forEach(v -> lst.add(mapper.toOuter(v)));
        }
        outer.setVendors(lst);
        return outer;
    }
    
}
