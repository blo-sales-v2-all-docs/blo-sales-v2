package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntMovement;
import com.blo.sales.v2.model.entities.MovementEntity;
import com.blo.sales.v2.model.entities.enums.ReasonsEntityEnum;
import com.blo.sales.v2.model.entities.enums.TypesEntityEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class MovementEntityMapper implements IToInner<MovementEntity, PojoIntMovement>, IToOuter<MovementEntity, PojoIntMovement> {
    
    @Override
    public MovementEntity toInner(PojoIntMovement outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new MovementEntity();
        inner.setFk_product(outer.getFkProduct());
        inner.setFk_user(outer.getFkUser());
        inner.setQuantity(outer.getQuantity());
        inner.setReason(ReasonsEntityEnum.valueOf(outer.getReason().name()));
        inner.setTimestamp(outer.getTimestamp());
        inner.setType(TypesEntityEnum.valueOf(outer.getType().name()));
        return inner;
    }

    @Override
    public PojoIntMovement toOuter(MovementEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntMovement();
        outer.setFkProduct(inner.getFk_product());
        outer.setFkUser(inner.getFk_user());
        outer.setIdMovement(inner.getId_movement());
        outer.setQuantity(inner.getQuantity());
        outer.setReason(ReasonsEntityEnum.valueOf(inner.getReason().name()));
        outer.setTimestamp(inner.getTimestamp());
        outer.setType(TypesEntityEnum.valueOf(inner.getType().name()));
        return outer;
    }
    
}
