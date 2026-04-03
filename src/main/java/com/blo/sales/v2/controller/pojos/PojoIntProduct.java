package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntProduct {
    
    private long idProduct;
    
    private String product;
    
    private BigDecimal quantity;
    
    private BigDecimal costOfSale;
    
    private BigDecimal price;
    
    private String timestamp;
    
    private boolean kg;
    
    private String barCode;
    
    private long fkCategory;    
}
