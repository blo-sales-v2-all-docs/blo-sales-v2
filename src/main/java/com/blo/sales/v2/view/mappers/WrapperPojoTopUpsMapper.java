package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoTopUp;
import com.blo.sales.v2.view.pojos.WrapperPojoTopUp;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoTopUpsMapper implements IToOuter<WrapperPojoIntTopUp, WrapperPojoTopUp> {
    
    @Inject
    private PojoTopUpMapper mapper;

    @Override
    public WrapperPojoTopUp toOuter(WrapperPojoIntTopUp inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoTopUp();
        final var lst = new ArrayList<PojoTopUp>();
        
        if (inner.getTopUps() != null && !inner.getTopUps().isEmpty()) {
            inner.getTopUps().forEach(t -> lst.add(mapper.toOuter(t)));
        }
        outer.setTopUps(lst);
        return outer;
    }
    
}
