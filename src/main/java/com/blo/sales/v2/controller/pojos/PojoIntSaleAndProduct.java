package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntSaleAndProduct {
    
    private long idSale;
    
    private long idProduct;
    
    private String product;
    
    private BigDecimal quantityOnSale;
    
    private BigDecimal price;
    
    private BigDecimal costOfSale;
    
    private BigDecimal totalOnSale;
    
    private BigDecimal productTotalOnSale;
    
    private String timestamp;
    
    private PaymentTypeIntEnum paymentType;
    
    private boolean kg;
}
