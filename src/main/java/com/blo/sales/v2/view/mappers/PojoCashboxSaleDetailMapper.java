package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSaleDetail;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoCashboxSaleDetail;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class PojoCashboxSaleDetailMapper implements IToOuter<PojoIntCashboxSaleDetail, PojoCashboxSaleDetail> {
    
    @Inject
    private PojoCashboxMapper cashboxMapper;
    
    @Inject
    private PojoSaleMapper saleMapper;
    
    @Inject
    private ProductMapper productMapper;
    
    @Inject
    private LoggedInUserMapper loggedInUserMapper;
    
    @Inject
    private PojoSaleProductMapper saleProduct;
    
    @Inject
    private PojoPaymentTypeInfoMapper paymentInfoMapper;

    @Override
    public PojoCashboxSaleDetail toOuter(PojoIntCashboxSaleDetail inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoCashboxSaleDetail();
        outer.setCashbox(cashboxMapper.toOuter(inner.getCashbox()));
        outer.setSale(saleMapper.toOuter(inner.getSale()));
        outer.setProduct(productMapper.toOuter(inner.getProduct()));
        outer.setUser(loggedInUserMapper.toOuter(inner.getUser()));
        outer.setSaleProduct(saleProduct.toOuter(inner.getSaleProduct()));
        outer.setPaymentTypeInfo(paymentInfoMapper.toOuter(inner.getPaymentTypeInfo()));
        return outer;
        
    }
    
}
