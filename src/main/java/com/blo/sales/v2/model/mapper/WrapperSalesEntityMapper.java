package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntSale;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntSales;
import com.blo.sales.v2.model.entities.WrapperSalesEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperSalesEntityMapper implements IToOuter<WrapperSalesEntity, WrapperPojoIntSales> {
    
    @Inject
    private SaleEntityMapper mapper;
    
    @Override
    public WrapperPojoIntSales toOuter(WrapperSalesEntity inner) {
        if (inner == null) {
            return null;
        }
        final var out = new WrapperPojoIntSales();
        final var lst = new ArrayList<PojoIntSale>();
        if (inner.getSales() != null && !inner.getSales().isEmpty()) {
            inner.getSales().forEach(s -> lst.add(mapper.toOuter(s)));
        }
        out.setSales(lst);
        return out;
    }
    
}
