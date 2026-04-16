package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.ReasonsEntityEnum;
import com.blo.sales.v2.model.entities.enums.TypesEntityEnum;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class FinancialMovementEntity {
    
    private long id_financial_movement;
    
    private long fk_account;
    
    private long fk_user;
    
    private BigDecimal amount;
    
    private ReasonsEntityEnum reason;
    
    private TypesEntityEnum type;
    
    private String timestamp;
    
}
