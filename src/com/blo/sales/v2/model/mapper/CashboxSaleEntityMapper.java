package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSale;
import com.blo.sales.v2.model.entities.CashboxSaleEntity;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;

public class CashboxSaleEntityMapper implements IToOuter<CashboxSaleEntity, PojoIntCashboxSale> {
    
    private static CashboxSaleEntityMapper instance;
    
    private static final CashboxEntityMapper cashboxMapper = CashboxEntityMapper.getInstance();
    
    private static final SaleEntityMapper saleMapper = SaleEntityMapper.getInstance();
    
    private CashboxSaleEntityMapper() { }
    
    public static CashboxSaleEntityMapper getInstance() {
        if (instance == null) {
            instance = new CashboxSaleEntityMapper();
        }
        return instance;
    }

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
