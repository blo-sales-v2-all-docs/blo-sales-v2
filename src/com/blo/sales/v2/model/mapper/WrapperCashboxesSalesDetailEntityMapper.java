package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSaleDetail;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesSalesDetails;
import com.blo.sales.v2.model.entities.WrapperCashboxesSalesDetailsEntity;
import com.blo.sales.v2.utils.IToOuter;
import java.util.ArrayList;

public class WrapperCashboxesSalesDetailEntityMapper implements IToOuter<WrapperCashboxesSalesDetailsEntity, WrapperPojoIntCashboxesSalesDetails> {
    
    private static final CashboxSaleDetailEntityMapper mapper = CashboxSaleDetailEntityMapper.getInstance();
    
    private static WrapperCashboxesSalesDetailEntityMapper instance;
    
    private WrapperCashboxesSalesDetailEntityMapper() { }
    
    public static WrapperCashboxesSalesDetailEntityMapper getInstanace() {
        if (instance == null) {
            instance = new WrapperCashboxesSalesDetailEntityMapper();
        }
        return instance;
    }

    @Override
    public WrapperPojoIntCashboxesSalesDetails toOuter(WrapperCashboxesSalesDetailsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntCashboxesSalesDetails();
        final var lst = new ArrayList<PojoIntCashboxSaleDetail>();
        if (inner.getCashboxes() != null && !inner.getCashboxes().isEmpty()) {
            inner.getCashboxes().forEach(c -> lst.add(mapper.toOuter(c)));
        }
        outer.setCashboxes(lst);
        return outer;
    }
    
}
