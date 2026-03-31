package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSaleDetail;
import com.blo.sales.v2.model.entities.CashboxSaleDetailEntity;
import com.blo.sales.v2.utils.IToOuter;

public class CashboxSaleDetailEntityMapper implements IToOuter<CashboxSaleDetailEntity, PojoIntCashboxSaleDetail>{
    
    private static final CashboxEntityMapper cashboxMapper = CashboxEntityMapper.getInstance();
    
    private static final SaleEntityMapper saleMapper = SaleEntityMapper.getInstance();
    
    private static final ProductEntityMapper productMapper = ProductEntityMapper.getInstance();
    
    private static final UserLoggedEntityMapper userMapper = UserLoggedEntityMapper.getInstance();
    
    private static final SaleProductEntityMapper saleProductMapper = SaleProductEntityMapper.getInstance();
    
    private static CashboxSaleDetailEntityMapper instance;
    
    private CashboxSaleDetailEntityMapper() { }
    
    public static CashboxSaleDetailEntityMapper getInstance() {
        if (instance == null) {
            instance = new CashboxSaleDetailEntityMapper();
        }
        return instance;
    }

    @Override
    public PojoIntCashboxSaleDetail toOuter(CashboxSaleDetailEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntCashboxSaleDetail();
        outer.setCashbox(cashboxMapper.toOuter(inner.getCashbox()));
        outer.setSale(saleMapper.toOuter(inner.getSale()));
        outer.setProduct(productMapper.toOuter(inner.getProduct()));
        outer.setUser(userMapper.toOuter(inner.getUser()));
        outer.setSaleProduct(saleProductMapper.toOuter(inner.getSale_product()));
        return outer;
    }
    
}
