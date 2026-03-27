package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.model.entities.WrapperTopUpsEntity;
import com.blo.sales.v2.utils.IToOuter;
import java.util.ArrayList;

public class WrapperTopUpsEntityMapper implements IToOuter<WrapperTopUpsEntity, WrapperPojoIntTopUp> {
    
    private static final TopUpEntityMapper mapper = TopUpEntityMapper.getInstance();
    
    private static WrapperTopUpsEntityMapper instance;
    
    private WrapperTopUpsEntityMapper() { }
    
    public static WrapperTopUpsEntityMapper getInstance() {
        if (instance == null) {
            instance = new WrapperTopUpsEntityMapper();
        }
        return instance;
    }

    @Override
    public WrapperPojoIntTopUp toOuter(WrapperTopUpsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntTopUp();
        final var lst = new ArrayList<PojoIntTopUp>();
        
        if (inner.getTopUps() != null && !inner.getTopUps().isEmpty()) {
            inner.getTopUps().forEach(t -> lst.add(mapper.toOuter(t)));
        }
        outer.setTopUps(lst);
        return outer;
    }
    
}
