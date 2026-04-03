package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntUser;
import com.blo.sales.v2.controller.pojos.enums.RolesIntEnum;
import com.blo.sales.v2.model.entities.UserEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class UserEntityMapper implements IToOuter<UserEntity, PojoIntUser> {
    
    @Override
    public PojoIntUser toOuter(UserEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntUser();
        outer.setUserName(inner.getUsername());
        outer.setIdUser(inner.getId_user());
        outer.setRol(RolesIntEnum.valueOf(inner.getRole().name()));
        return outer;
    }
    
}
