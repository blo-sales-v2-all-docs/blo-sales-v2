package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.enums.ReasonsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypesIntEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoFinancialMovement;
import com.blo.sales.v2.view.pojos.enums.ReasonsEnum;
import com.blo.sales.v2.view.pojos.enums.TypesEnum;
import jakarta.inject.Singleton;

@Singleton
public class PojoFinancialMovementMapper implements IToInner<PojoIntFinancialMovement, PojoFinancialMovement>, IToOuter<PojoIntFinancialMovement, PojoFinancialMovement> {

    @Override
    public PojoIntFinancialMovement toInner(PojoFinancialMovement outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntFinancialMovement();
        inner.setAmount(outer.getAmount());
        inner.setFkAccount(outer.getFkAccount());
        inner.setFkUser(outer.getFkUser());
        inner.setIdFinancialMovement(outer.getIdFinancialMovement());
        inner.setReason(ReasonsIntEnum.valueOf(outer.getReason().name()));
        inner.setTimestamp(outer.getTimestamp());
        inner.setType(TypesIntEnum.valueOf(outer.getType().name()));
        inner.setAuthorization(outer.getAuthorization());
        return inner;
    }

    @Override
    public PojoFinancialMovement toOuter(PojoIntFinancialMovement inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoFinancialMovement();
        outer.setAmount(inner.getAmount());
        outer.setFkAccount(inner.getFkAccount());
        outer.setFkUser(inner.getFkUser());
        outer.setIdFinancialMovement(inner.getIdFinancialMovement());
        outer.setReason(ReasonsEnum.valueOf(inner.getReason().name()));
        outer.setTimestamp(inner.getTimestamp());
        outer.setType(TypesEnum.valueOf(inner.getType().name()));
        outer.setAuthorization(inner.getAuthorization());
        return outer;
    }
    
}
