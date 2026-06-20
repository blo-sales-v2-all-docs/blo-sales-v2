package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntFinancialMovement;
import com.blo.sales.v2.controller.pojos.enums.ReasonsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypesIntEnum;
import com.blo.sales.v2.model.entities.FinancialMovementEntity;
import com.blo.sales.v2.model.entities.enums.ReasonsEntityEnum;
import com.blo.sales.v2.model.entities.enums.TypesEntityEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class FinancialMovementEntityMapper implements IToInner<FinancialMovementEntity, PojoIntFinancialMovement>, IToOuter<FinancialMovementEntity, PojoIntFinancialMovement> {

    @Override
    public FinancialMovementEntity toInner(PojoIntFinancialMovement outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new FinancialMovementEntity();
        inner.setAmount(outer.getAmount());
        inner.setAuthorization(outer.getAuthorization());
        inner.setFk_account(outer.getFkAccount());
        inner.setFk_user(outer.getFkUser());
        inner.setId_financial_movement(outer.getIdFinancialMovement());
        inner.setReason(ReasonsEntityEnum.valueOf(outer.getReason().name()));
        inner.setTimestamp(outer.getTimestamp());
        inner.setType(TypesEntityEnum.valueOf(outer.getType().name()));
        return inner;
    }

    @Override
    public PojoIntFinancialMovement toOuter(FinancialMovementEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntFinancialMovement();
        outer.setAmount(inner.getAmount());
        outer.setAuthorization(inner.getAuthorization());
        outer.setFkAccount(inner.getFk_account());
        outer.setFkUser(inner.getFk_user());
        outer.setIdFinancialMovement(inner.getId_financial_movement());
        outer.setReason(ReasonsIntEnum.valueOf(inner.getReason().name()));
        outer.setTimestamp(inner.getTimestamp());
        outer.setType(TypesIntEnum.valueOf(inner.getType().name()));
        return outer;
    }
}