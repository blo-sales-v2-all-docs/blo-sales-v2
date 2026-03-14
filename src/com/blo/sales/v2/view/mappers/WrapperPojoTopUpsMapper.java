package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.model.mapper.*;
import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.model.entities.WrapperTopUpsEntity;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoTopUp;
import com.blo.sales.v2.view.pojos.WrapperPojoTopUp;
import java.util.ArrayList;

public class WrapperPojoTopUpsMapper implements IToOuter<WrapperPojoIntTopUp, WrapperPojoTopUp> {
    
    private static final PojoTopUpMapper mapper = PojoTopUpMapper.getInstance();
    
    private static WrapperPojoTopUpsMapper instance;
    
    private WrapperPojoTopUpsMapper() { }
    
    public static WrapperPojoTopUpsMapper getInstance() {
        if (instance == null) {
            instance = new WrapperPojoTopUpsMapper();
        }
        return instance;
    }

    @Override
    public WrapperPojoTopUp toOuter(WrapperPojoIntTopUp inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoTopUp();
        final var lst = new ArrayList<PojoTopUp>();
        
        if (inner.getTopUps() != null && !inner.getTopUps().isEmpty()) {
            inner.getTopUps().forEach(t -> lst.add(mapper.toOuter(t)));
        }
        outer.setTopUps(lst);
        return outer;
    }
    
}
