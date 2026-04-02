package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesSalesDetails;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoCashboxSaleDetail;
import com.blo.sales.v2.view.pojos.WrapperPojoCashboxesSalesDetails;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoCashboxesSalesDetailMapper implements IToOuter<WrapperPojoIntCashboxesSalesDetails, WrapperPojoCashboxesSalesDetails> {
    
    @Inject
    private PojoCashboxSaleDetailMapper mapper;

    @Override
    public WrapperPojoCashboxesSalesDetails toOuter(WrapperPojoIntCashboxesSalesDetails inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoCashboxesSalesDetails();
        final var lst = new ArrayList<PojoCashboxSaleDetail>();
        if (inner.getCashboxes() != null && !inner.getCashboxes().isEmpty()) {
            inner.getCashboxes().forEach(c -> lst.add(mapper.toOuter(c)));
        }
        outer.setCashboxes(lst);
        return outer;
    }
    
}
