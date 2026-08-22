package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class DebtorInfoDetailEntity {
    
    private long id_debtor;
    
    private String name;
    
    private BigDecimal debt;
    
    private String payments;
    
    private String timestamp;
    
    private String product;
    
    private BigDecimal price;
    
    private BigDecimal quantity_sale;
    
    private BigDecimal product_total_on_sale;
    
}
