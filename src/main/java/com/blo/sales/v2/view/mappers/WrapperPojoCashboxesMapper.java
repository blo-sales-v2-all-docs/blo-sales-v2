package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxes;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoCashbox;
import com.blo.sales.v2.view.pojos.WrapperPojoCashboxes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoCashboxesMapper implements IToOuter<WrapperPojoIntCashboxes, WrapperPojoCashboxes> {
    
    @Inject
    private PojoCashboxMapper mapper;

    @Override
    public WrapperPojoCashboxes toOuter(WrapperPojoIntCashboxes inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoCashboxes();
        final var lst = new ArrayList<PojoCashbox>();
        if (inner.getCashboxes() != null && !inner.getCashboxes().isEmpty()) {
            inner.getCashboxes().forEach(p -> lst.add(mapper.toOuter(p)));
        }
        outer.setCashboxes(lst);
        return outer;
    }
    
}
