package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class SaleProductEntity {
    
    private long id_sale_product;
    
    private long fk_sale;
    
    private long fk_product;

    private BigDecimal qunatity_sale;
    
    private BigDecimal total_on_sale;
    
    private BigDecimal product_total_on_sale;
    
    private String timestamp;
    
    private boolean is_live;
}
