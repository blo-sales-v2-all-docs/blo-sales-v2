package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.model.entities.WrapperTopUpsEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperTopUpsEntityMapper implements IToOuter<WrapperTopUpsEntity, WrapperPojoIntTopUp> {
    
    @Inject
    private TopUpEntityMapper mapper;
    
    @Override
    public WrapperPojoIntTopUp toOuter(WrapperTopUpsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntTopUp();
        final var lst = new ArrayList<PojoIntTopUp>();
        
        if (inner.getTopUps() != null && !inner.getTopUps().isEmpty()) {
            inner.getTopUps().forEach(t -> lst.add(mapper.toOuter(t)));
        }
        outer.setTopUps(lst);
        return outer;
    }
    
}
