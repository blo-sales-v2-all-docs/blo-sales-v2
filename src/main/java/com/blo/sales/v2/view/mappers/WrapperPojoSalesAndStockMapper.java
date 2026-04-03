package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntSalesAndStock;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoSaleAndProduct;
import com.blo.sales.v2.view.pojos.WrapperPojoSalesAndStock;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoSalesAndStockMapper implements IToOuter<WrapperPojoIntSalesAndStock, WrapperPojoSalesAndStock> {

    @Inject
    private PojoSaleAndProductMapper mapper;
    
    @Override
    public WrapperPojoSalesAndStock toOuter(WrapperPojoIntSalesAndStock inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoSalesAndStock();
        final var salesDetail = new ArrayList<PojoSaleAndProduct>();
        if (inner.getSalesDetail() != null && !inner.getSalesDetail().isEmpty()) {
            inner.getSalesDetail().forEach(s -> salesDetail.add(mapper.toOuter(s)));
        }
        outer.setSalesDetail(salesDetail);
        return outer;
    }
    
}
