package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntSaleAndProduct {
    
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

}
