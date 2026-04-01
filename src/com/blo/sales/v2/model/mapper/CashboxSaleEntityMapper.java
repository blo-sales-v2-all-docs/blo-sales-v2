package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSale;
import com.blo.sales.v2.model.entities.CashboxSaleEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CashboxSaleEntityMapper implements IToOuter<CashboxSaleEntity, PojoIntCashboxSale> {
    
    @Inject
    private CashboxEntityMapper cashboxMapper;
    
    @Inject
    private SaleEntityMapper saleMapper;
    
    @Override
    public PojoIntCashboxSale toOuter(CashboxSaleEntity outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntCashboxSale();
        inner.setIdCashboxSale(outer.getId_cashbox_sale());
        inner.setFkCashbox(cashboxMapper.toOuter(outer.getFk_cashbox()));
        inner.setFkSale(saleMapper.toOuter(outer.getFk_sale()));
        return inner;
    }
    
    
    
}
