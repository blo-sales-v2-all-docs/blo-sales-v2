package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntActiveCost;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntActivesCosts;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.view.pojos.WrapperPojoActivesCosts;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoActivesCostsMapper implements IToInner<WrapperPojoIntActivesCosts, WrapperPojoActivesCosts> {
    
    @Inject
    private PojoActiveCostMapper mapper;

    @Override
    public WrapperPojoIntActivesCosts toInner(WrapperPojoActivesCosts outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new WrapperPojoIntActivesCosts();
        final var activesCosts = new ArrayList<PojoIntActiveCost>();
        if (outer.getActivesCosts() != null && !outer.getActivesCosts().isEmpty()) {
            outer.getActivesCosts().forEach(c -> activesCosts.add(mapper.toInner(c)));
        }
        inner.setActivesCosts(activesCosts);
        return inner;
    }
    
}
