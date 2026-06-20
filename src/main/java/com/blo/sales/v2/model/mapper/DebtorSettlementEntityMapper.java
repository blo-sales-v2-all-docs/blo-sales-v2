package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntDebtSettlement;
import com.blo.sales.v2.model.entities.DebtorSettlementEntity;
import com.blo.sales.v2.model.entities.SaleEntity;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class DebtorSettlementEntityMapper implements IToInner<DebtorSettlementEntity, PojoIntDebtSettlement>, IToOuter<DebtorSettlementEntity, PojoIntDebtSettlement> {

    @Override
    public DebtorSettlementEntity toInner(PojoIntDebtSettlement outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new DebtorSettlementEntity();
        inner.setDebtor(outer.getDebtor());
        final var sale = new SaleEntity();
        sale.setId_sale(outer.getFkSale());
        inner.setFk_sale(sale);
        inner.setPayments(outer.getPayments());
        inner.setProducts_details(outer.getProductsDetails());
        inner.setTimestamp(outer.getTimestamp());
        return inner;
    }

    @Override
    public PojoIntDebtSettlement toOuter(DebtorSettlementEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntDebtSettlement();
        if (inner.getFk_sale() == null) {
            return null;
        }
        outer.setDebtor(inner.getDebtor());
        outer.setFkSale(inner.getFk_sale().getId_sale());
        outer.setIdDebtSettlement(inner.getId_debt_settlement());
        outer.setPayments(inner.getPayments());
        outer.setProductsDetails(inner.getProducts_details());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
