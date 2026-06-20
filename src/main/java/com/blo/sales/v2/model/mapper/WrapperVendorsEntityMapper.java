package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntVendor;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntVendors;
import com.blo.sales.v2.model.entities.WrapperVendorsEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperVendorsEntityMapper implements IToOuter<WrapperVendorsEntity, WrapperPojoIntVendors> {

    @Inject
    private VendorEntityMapper mapper;
    
    @Override
    public WrapperPojoIntVendors toOuter(WrapperVendorsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntVendors();
        final var lst = new ArrayList<PojoIntVendor>();
        if (inner.getVendors() != null && !inner.getVendors().isEmpty()) {
            inner.getVendors().forEach(v -> lst.add(mapper.toOuter(v)));
        }
        outer.setVendors(lst);
        return outer;
    }
    
}
