package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PojoAccount {
    
    private long idAccount;
    
    private String account;
    
    private BigDecimal controlAmount;
    
    private String timestamp;
    
}
