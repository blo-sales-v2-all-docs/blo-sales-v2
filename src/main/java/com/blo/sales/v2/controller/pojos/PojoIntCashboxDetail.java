package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.ActiveCostIntEnum;
import com.blo.sales.v2.controller.pojos.enums.CashboxStatusIntEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntCashboxDetail {
    
    private long idCashbox;
    
    private CashboxStatusIntEnum status;
    
    private BigDecimal amount;
    
    private String concept;
    
    private ActiveCostIntEnum type;
    
    private String timestamp;

    private BigDecimal conceptAmount;
}
