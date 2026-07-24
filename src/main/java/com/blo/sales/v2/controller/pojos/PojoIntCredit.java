package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntCredit {
    
    private long idCredit;
    
    private long fkUser;
    
    private String lenderName;
    
    private BigDecimal amount;
    
    private BigDecimal originalAmount;
    
    private boolean payed;
    
    private String payments;
    
    private String timestamp;
    
    private boolean available;
    
    private String updateDate;
    
}
