package com.blo.sales.v2.controller.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntCashboxSaleDetail {

    private PojoIntCashbox cashbox;
    
    private PojoIntSale sale;
    
    private PojoIntProduct product;
    
    private PojoIntLoggedInUser user;
    
    private PojoIntSaleProduct saleProduct;
    
    private PojoIntPaymentTypeInfo paymentTypeInfo;
}
