package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSaleDetail;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesSalesDetails;
import com.blo.sales.v2.model.entities.WrapperCashboxesSalesDetailsEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperCashboxesSalesDetailEntityMapper implements IToOuter<WrapperCashboxesSalesDetailsEntity, WrapperPojoIntCashboxesSalesDetails> {
    
    @Inject
    private CashboxSaleDetailEntityMapper mapper;

    @Override
    public WrapperPojoIntCashboxesSalesDetails toOuter(WrapperCashboxesSalesDetailsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntCashboxesSalesDetails();
        final var lst = new ArrayList<PojoIntCashboxSaleDetail>();
        if (inner.getCashboxes() != null && !inner.getCashboxes().isEmpty()) {
            inner.getCashboxes().forEach(c -> lst.add(mapper.toOuter(c)));
        }
        outer.setCashboxes(lst);
        return outer;
    }
    
}
