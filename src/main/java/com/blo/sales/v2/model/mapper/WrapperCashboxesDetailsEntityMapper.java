package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxDetail;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesDetails;
import com.blo.sales.v2.model.entities.WrapperCashboxesDetailsEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperCashboxesDetailsEntityMapper implements IToOuter<WrapperCashboxesDetailsEntity, WrapperPojoIntCashboxesDetails> {
    
    @Inject
    private CashboxDetailEntityMapper mapper;

    @Override
    public WrapperPojoIntCashboxesDetails toOuter(WrapperCashboxesDetailsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntCashboxesDetails();
        final var lst = new ArrayList<PojoIntCashboxDetail>();
        if (inner.getCashboxesInfo() != null && !inner.getCashboxesInfo().isEmpty()) {
            inner.getCashboxesInfo().forEach(c -> lst.add(mapper.toOuter(c)));
        }
        outer.setCashboxesInfo(lst);
        return outer;
    }
    
}
