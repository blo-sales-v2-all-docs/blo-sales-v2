package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesDetails;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoCashboxDetail;
import com.blo.sales.v2.view.pojos.WrapperPojoCashboxesDetails;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoCashboxesDetailsMapper implements IToOuter<WrapperPojoIntCashboxesDetails, WrapperPojoCashboxesDetails> {
    
    @Inject
    private PojoCashboxDetailMapper mapper;

    @Override
    public WrapperPojoCashboxesDetails toOuter(WrapperPojoIntCashboxesDetails inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoCashboxesDetails();
        final var lst = new ArrayList<PojoCashboxDetail>();
        if (inner.getCashboxesInfo() != null && !inner.getCashboxesInfo().isEmpty()) {
            inner.getCashboxesInfo().forEach(c -> lst.add(mapper.toOuter(c)));
        }
        outer.setCashboxesInfo(lst);
        return outer;
    }
    
}
