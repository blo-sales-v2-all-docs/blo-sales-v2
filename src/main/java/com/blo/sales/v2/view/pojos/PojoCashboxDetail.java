package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.ActivesCostsEnum;
import com.blo.sales.v2.view.pojos.enums.CashboxStatusEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoCashboxDetail {
    
    private long idCashbox;
    
    private CashboxStatusEnum status;
    
    private BigDecimal amount;
    
    private String concept;
    
    private ActivesCostsEnum type;
    
    private String timestamp;
    
    private BigDecimal conceptAmount;
}
