package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntDebtorsDetails;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoDebtorDetail;
import com.blo.sales.v2.view.pojos.WrapperPojoDebtorsDetails;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoDebtorsDetailsMapper implements IToOuter<WrapperPojoIntDebtorsDetails, WrapperPojoDebtorsDetails> {
    
    @Inject
    private PojoDebtorDetailMapper mapper;

    @Override
    public WrapperPojoDebtorsDetails toOuter(WrapperPojoIntDebtorsDetails inner) {
        if (inner == null) {
            return null;
        }
        final var out = new WrapperPojoDebtorsDetails();
        final var items = new ArrayList<PojoDebtorDetail>();
        
        if (inner.getDebtors() != null && !inner.getDebtors().isEmpty()) {
            inner.getDebtors().forEach(d -> items.add(mapper.toOuter(d)));
        }
        out.setDebtors(items);
        return out;
        
    }
    
}
