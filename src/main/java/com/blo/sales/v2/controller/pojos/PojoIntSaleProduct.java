package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntSaleProduct {
    
    private long idSaleProduct;
    
    private long fkSale;
    
    private long fkProduct;
    
    private BigDecimal quantityOnSale;
    
    private BigDecimal totalOnSale;
    
    private BigDecimal productTotalOnSale;
    
    private String timestamp;
    
    private boolean isLive;
    
}
