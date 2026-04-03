package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtors;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoDebtor;
import com.blo.sales.v2.view.pojos.WrapperPojoDebtors;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperDebtorsMapper implements IToOuter<WrapperPojoIntDebtors, WrapperPojoDebtors> {
    
    @Inject
    private DebtorMapper mapper;
    
    @Override
    public WrapperPojoDebtors toOuter(WrapperPojoIntDebtors inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoDebtors();
        final var items = new ArrayList<PojoDebtor>();
        
        if (inner.getDebtors() != null && !inner.getDebtors().isEmpty()) {
            inner.getDebtors().forEach(i -> items.add(mapper.toOuter(i)));
        }
        
        outer.setDebtors(items);
        return outer;
    }
    
}
