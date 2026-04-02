package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntUser;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.view.pojos.PojoUser;
import jakarta.inject.Singleton;

@Singleton
public class UserMapper implements IToInner<PojoIntUser, PojoUser> {
    
    @Override
    public PojoIntUser toInner(PojoUser outer) {
        if (outer == null) {
            return null;
        }
        return new PojoIntUser(outer.getUsername(), outer.getPassword());
    }
    
}
