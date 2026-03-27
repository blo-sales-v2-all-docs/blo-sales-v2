package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SaleAndProductEntity {
    
    private long id_sale;
    
    private long id_product;
    
    private String product;
    
    private BigDecimal quantity_on_sale;
    
    private BigDecimal price;
    
    private BigDecimal cost_of_sale;
    
    private BigDecimal total_on_sale;
    
    private BigDecimal product_total_on_sale;
    
    private String timestamp;
    
    private boolean kg;

}
