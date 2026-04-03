package com.blo.sales.v2.view.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoCashboxSaleDetail {

    private PojoCashbox cashbox;
    
    private PojoSale sale;
    
    private PojoProduct product;
    
    private PojoLoggedInUser user;
    
    private PojoSaleProduct saleProduct;
    
    private PojoPaymentTypeInfo paymentTypeInfo;

}
