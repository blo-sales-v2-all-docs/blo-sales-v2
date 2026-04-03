package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.PaymentTypeEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoSaleAndProduct {
    
    private long idSale;
    
    private long idProduct;
    
    private String product;
    
    private BigDecimal quantityOnSale;
    
    private BigDecimal price;
    
    private BigDecimal costOfSale;
    
    private BigDecimal totalOnSale;
    
    private BigDecimal productTotalOnSale;
    
    private String timestamp;
    
    private boolean kg;
    
    private PaymentTypeEnum paymentType;
}
