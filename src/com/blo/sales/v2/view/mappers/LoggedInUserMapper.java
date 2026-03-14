package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntLoggedInUser;
import com.blo.sales.v2.controller.pojos.enums.RolesIntEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoLoggedInUser;
import com.blo.sales.v2.view.pojos.enums.RolesEnum;

public class LoggedInUserMapper implements IToOuter<PojoIntLoggedInUser, PojoLoggedInUser>, IToInner<PojoIntLoggedInUser, PojoLoggedInUser> {
    
    private static LoggedInUserMapper instance;
    
    private LoggedInUserMapper() { }
    
    public static LoggedInUserMapper getInstance() {
        if (instance == null) {
            instance = new LoggedInUserMapper();
        }
        return instance;
    }

    @Override
    public PojoLoggedInUser toOuter(PojoIntLoggedInUser inner) {
        if (inner == null) {
            return null;
        }
        final var out = new PojoLoggedInUser();
        out.setIdUser(inner.getIdUser());
        out.setRole(RolesEnum.valueOf(inner.getRole().name()));
        out.setUsername(inner.getUsername());
        return out;
    }

    @Override
    public PojoIntLoggedInUser toInner(PojoLoggedInUser outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntLoggedInUser();
        inner.setIdUser(outer.getIdUser());
        inner.setRole(RolesIntEnum.valueOf(outer.getRole().name()));
        inner.setUsername(outer.getUsername());
        return inner;
    }
    
}
