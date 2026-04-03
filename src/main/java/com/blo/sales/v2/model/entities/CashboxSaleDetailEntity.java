package com.blo.sales.v2.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class CashboxSaleDetailEntity {
    
    private CashboxEntity cashbox;
    
    private SaleEntity sale;
    
    private ProductEntity product;
    
    private UserEntity user;
    
    private SaleProductEntity sale_product;
    
    private PaymentTypeInfoEntity payment_info_tmp;
    
}
