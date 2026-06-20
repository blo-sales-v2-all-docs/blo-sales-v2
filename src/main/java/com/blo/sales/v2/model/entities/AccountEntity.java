package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountEntity {
    
    private long id_account;
    
    private String account;
    
    private BigDecimal control_amount;
    
    private String timestamp;
    
}
