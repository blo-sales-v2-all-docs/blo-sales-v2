package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntSaleProductData {
    
    private long idProduct;
    
    private BigDecimal quantityOnSale;
    
    private BigDecimal price;
    
    private BigDecimal productBuyTotal;
    
}
