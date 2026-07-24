package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class CreditEntity {
    
    private long id_credit;
    
    private long fk_user;
    
    private String lender_name;
    
    private BigDecimal amount;
    
    private BigDecimal original_amount;
    
    private boolean payed;
    
    private String timestamp;
    
    private String payments;
    
    private boolean available;
    
    private String update_date;
    
}
