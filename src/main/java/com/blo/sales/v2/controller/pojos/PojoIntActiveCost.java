package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.ActiveCostIntEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntActiveCost {
    
    private long idActiveCosts;
    
    private String concept;
    
    private BigDecimal amount;
    
    private ActiveCostIntEnum type;
    
    private boolean complete;
}
