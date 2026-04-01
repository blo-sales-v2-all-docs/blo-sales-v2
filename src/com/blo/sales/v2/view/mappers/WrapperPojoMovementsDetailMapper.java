package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntMovementsDetail;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoMovementDetail;
import com.blo.sales.v2.view.pojos.WrapperPojoMovementsDetail;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoMovementsDetailMapper implements IToOuter<WrapperPojoIntMovementsDetail, WrapperPojoMovementsDetail> {
    
    @Inject
    private PojoMovementDetailMapper mapper;

    @Override
    public WrapperPojoMovementsDetail toOuter(WrapperPojoIntMovementsDetail inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoMovementsDetail();
        final var lst = new ArrayList<PojoMovementDetail>();
        if (inner.getHistory() != null && !inner.getHistory().isEmpty()) {
            inner.getHistory().forEach(h -> lst.add(mapper.toOuter(h)));
        }
        outer.setHistory(lst);
        return outer;
    }
    
}
