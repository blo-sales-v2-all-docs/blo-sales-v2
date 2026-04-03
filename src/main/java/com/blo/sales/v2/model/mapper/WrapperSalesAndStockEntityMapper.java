package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntSaleAndProduct;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSalesAndStock;
import com.blo.sales.v2.model.entities.WrapperSalesAndStockEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperSalesAndStockEntityMapper implements IToOuter<WrapperSalesAndStockEntity, WrapperPojoIntSalesAndStock> {
    
    @Inject
    private SaleAndProductEntityMapper mapper;
    
    @Override
    public WrapperPojoIntSalesAndStock toOuter(WrapperSalesAndStockEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntSalesAndStock();
        final var salesDetail = new ArrayList<PojoIntSaleAndProduct>();
        if (inner.getSalesDetail() != null && !inner.getSalesDetail().isEmpty()) {
            inner.getSalesDetail().forEach(i -> salesDetail.add(mapper.toOuter(i)));
        }
        outer.setSalesDetail(salesDetail);
        return outer;
    }
    
}
