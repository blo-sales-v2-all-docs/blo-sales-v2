package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PojoProduct {
    
    private long idProduct;
    
    private String product;
    
    private BigDecimal quantity;
    
    private BigDecimal costOfSale;
    
    private BigDecimal price;
    
    private boolean kg;
    
    private String barCode;
    
    private long fkCategory;
    
    @Override
    public String toString() {
        return String.format("%s (%s)%s %s", idProduct, quantity, product, price);
    }
    
}
