package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductEntity {
    
    private long id_product;
    
    private String product;
    
    private BigDecimal quantity;
    
    private BigDecimal cost_of_sale;
    
    private BigDecimal price;
    
    private String timestamp;
    
    private boolean kg;
    
    private String bar_code;
    
    private long fk_category;
    
}
