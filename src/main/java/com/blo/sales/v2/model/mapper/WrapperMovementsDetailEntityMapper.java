package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntMovementDetail;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMovementsDetail;
import com.blo.sales.v2.model.entities.WrapperMovementsDetailEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperMovementsDetailEntityMapper implements IToOuter<WrapperMovementsDetailEntity, WrapperPojoIntMovementsDetail> {
    
    @Inject
    private MovementDetailEntityMapper mapper;
    
    @Override
    public WrapperPojoIntMovementsDetail toOuter(WrapperMovementsDetailEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntMovementsDetail();
        final var lst = new ArrayList<PojoIntMovementDetail>();
        if (inner.getHistory() != null && !inner.getHistory().isEmpty()) {
            inner.getHistory().forEach(h -> lst.add(mapper.toOuter(h)));
        }
        outer.setHistory(lst);
        return outer;
    }
    
}
