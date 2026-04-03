package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSaleDetail;
import com.blo.sales.v2.model.entities.CashboxSaleDetailEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CashboxSaleDetailEntityMapper implements IToOuter<CashboxSaleDetailEntity, PojoIntCashboxSaleDetail>{
    
   @Inject
    private CashboxEntityMapper cashboxMapper;

    @Inject
    private SaleEntityMapper saleMapper;

    @Inject
    private ProductEntityMapper productMapper;

    @Inject
    private UserLoggedEntityMapper userMapper;

    @Inject
    private SaleProductEntityMapper saleProductMapper;
    
    @Inject
    private PaymentTypeInfoEntityMapper paymenTypeInfoMapper;
    
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
        outer.setPaymentTypeInfo(paymenTypeInfoMapper.toOuter(inner.getPayment_info_tmp()));
        return outer;
    }
    
}
