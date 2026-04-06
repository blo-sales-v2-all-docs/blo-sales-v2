package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntSalesDeletedDetails;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoSaleDeletedDetail;
import com.blo.sales.v2.view.pojos.WrapperPojoSalesDeletedDetails;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoSalesDeletedDetailsMapper implements IToOuter<WrapperPojoIntSalesDeletedDetails, WrapperPojoSalesDeletedDetails> {

    @Inject
    private PojoSaleDeletedDetailMapper mapper;
    
    @Override
    public WrapperPojoSalesDeletedDetails toOuter(WrapperPojoIntSalesDeletedDetails inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoSalesDeletedDetails();
        final var lst = new ArrayList<PojoSaleDeletedDetail>();
        if (inner.getSalesDeleted() != null && !inner.getSalesDeleted().isEmpty()) {
            inner.getSalesDeleted().forEach(s -> lst.add(mapper.toOuter(s)));
        }
        outer.setSalesDeleted(lst);
        return outer;
    }
    
}
