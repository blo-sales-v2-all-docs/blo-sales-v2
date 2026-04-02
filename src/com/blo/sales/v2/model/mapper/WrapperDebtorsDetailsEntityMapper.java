package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorDetail;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtorsDetails;
import com.blo.sales.v2.model.entities.WrapperDebtorsDetailsEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperDebtorsDetailsEntityMapper implements IToOuter<WrapperDebtorsDetailsEntity, WrapperPojoIntDebtorsDetails> {
    
    @Inject
    private DebtorDetailEntityMapper mapper;
    
    @Override
    public WrapperPojoIntDebtorsDetails toOuter(WrapperDebtorsDetailsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var out = new WrapperPojoIntDebtorsDetails();
        final var items = new ArrayList<PojoIntDebtorDetail>();
        
        if (inner.getDebtors() != null && !inner.getDebtors().isEmpty()) {
            inner.getDebtors().forEach(d -> items.add(mapper.toOuter(d)));
        }
        out.setDebtors(items);
        return out;
        
    }
    
}
