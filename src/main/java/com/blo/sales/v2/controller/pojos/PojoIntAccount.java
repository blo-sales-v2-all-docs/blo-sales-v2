package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PojoIntAccount {
    
    private long idAccount;
    
    private String account;
    
    private BigDecimal controlAmount;
    
    private String timestamp;
    
}
