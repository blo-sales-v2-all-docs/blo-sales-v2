package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.ActivesCostsEntityEnum;
import com.blo.sales.v2.model.entities.enums.CashboxEntityEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class CashboxDetailEntity {
    
    private long id_cashbox;
    
    private CashboxEntityEnum status;
    
    private BigDecimal amount;
    
    private String concept;
    
    private ActivesCostsEntityEnum type;
    
    private String timestamp;
    
    private BigDecimal concept_amount;

}
