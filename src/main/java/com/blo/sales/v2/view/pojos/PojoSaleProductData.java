package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoSaleProductData {
    
    private long idProduct;
    
    private BigDecimal quantityOnSale;
    
    private BigDecimal price;
    
    private BigDecimal productBuyTotal;
    
    private String timestamp;
    
}
