package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSalesDeletedDetails;
import com.blo.sales.v2.model.entities.WrapperSalesDeletedDetailsEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperSalesDeletedDetailsEntityMapper implements IToOuter<WrapperSalesDeletedDetailsEntity, WrapperPojoIntSalesDeletedDetails> {

    @Inject
    private SaleDeletedDetailEntityMapper mapper;
    
    @Override
    public WrapperPojoIntSalesDeletedDetails toOuter(WrapperSalesDeletedDetailsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntSalesDeletedDetails();
        final var lst = new ArrayList<PojoIntSaleDeletedDetail>();
        if (inner.getSales_details() != null && !inner.getSales_details().isEmpty()) {
            inner.getSales_details().forEach(s -> lst.add(mapper.toOuter(s)));
        }
        outer.setSalesDeleted(lst);
        return outer;
    }
    
    
}
