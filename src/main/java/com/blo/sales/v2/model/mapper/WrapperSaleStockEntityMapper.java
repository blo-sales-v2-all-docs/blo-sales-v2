package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntSaleProduct;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSaleStock;
import com.blo.sales.v2.model.entities.WrapperSaleStockEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperSaleStockEntityMapper implements IToOuter<WrapperSaleStockEntity, WrapperPojoIntSaleStock> {
    
    @Inject
    private SaleProductEntityMapper mapper;
    
    @Override
    public WrapperPojoIntSaleStock toOuter(WrapperSaleStockEntity inner) {
        if (inner == null) {
            return null;
        }
        final var out = new WrapperPojoIntSaleStock();
        final var salesStock = new ArrayList<PojoIntSaleProduct>();
        
        if (inner.getSalesStock() != null && !inner.getSalesStock().isEmpty()) {
            inner.getSalesStock().forEach(s -> salesStock.add(mapper.toOuter(s)));
        }
        
        out.setSalesStocks(salesStock);
        return out;
        
    }
    
}
