package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DebtorDetailEntity {
    
    private long id_debtor;
    
    private String name;
    
    private BigDecimal debt;
    
    private String payments;
    
    private String product;
    
    private BigDecimal quantity_sale;
    
    private BigDecimal total_on_sale;
    
    private String timestamp;
    
}
