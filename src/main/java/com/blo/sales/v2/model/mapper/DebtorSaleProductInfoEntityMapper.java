package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorSaleProductInfo;
import com.blo.sales.v2.model.entities.DebtorSaleProductInfoEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class DebtorSaleProductInfoEntityMapper implements IToOuter<DebtorSaleProductInfoEntity, PojoIntDebtorSaleProductInfo> {

    @Override
    public PojoIntDebtorSaleProductInfo toOuter(DebtorSaleProductInfoEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntDebtorSaleProductInfo();
        outer.setAuthorization(inner.getAuthorization());
        outer.setIdDebtor(inner.getId_debtor());
        outer.setName(inner.getName());
        outer.setTimestamp(inner.getTimestamp());
        outer.setPayments(inner.getPayments());
        return outer;
    }
    
}
