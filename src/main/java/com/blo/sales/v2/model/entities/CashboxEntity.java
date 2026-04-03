package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.CashboxEntityEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class CashboxEntity {
    
    private long id_cashbox;
    
    private long fk_user;
    
    private String timestamp;
    
    private BigDecimal amount;
    
    private CashboxEntityEnum status;
    
    private String username;
}
