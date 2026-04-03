package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.CashboxStatusEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoCashbox {
    
    private long idCashbox;
    
    private long fkUser;
    
    private String timestamp;
    
    private BigDecimal amount;
    
    private CashboxStatusEnum status;
    
    private String userFrom;
}
