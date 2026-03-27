package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntSaleProduct {
    
    private long idSaleProduct;
    
    private long fkSale;
    
    private long fkProduct;
    
    private BigDecimal quantityOnSale;
    
    private BigDecimal totalOnSale;
    
    private BigDecimal productTotalOnSale;
    
    private String timestap;
    
    private boolean isLive;
    
}
