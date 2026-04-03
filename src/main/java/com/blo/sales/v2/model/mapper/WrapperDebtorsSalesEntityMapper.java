package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorSale;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtorsSales;
import com.blo.sales.v2.model.entities.WrapperDebtorsSalesEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperDebtorsSalesEntityMapper implements IToOuter<WrapperDebtorsSalesEntity, WrapperPojoIntDebtorsSales> {
    
    @Inject
    private DebtorSaleEntityMapper mapper;
    
    @Override
    public WrapperPojoIntDebtorsSales toOuter(WrapperDebtorsSalesEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntDebtorsSales();
        final var items = new ArrayList<PojoIntDebtorSale>();
        
        if (inner.getDebtorsSales() != null && !inner.getDebtorsSales().isEmpty()) {
            inner.getDebtorsSales().forEach(i -> items.add(mapper.toOuter(i)));
        }
        
        outer.setDebtorsSales(items);
        return outer;
    }
    
}
