package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.ActivesCostsEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoActiveCost {
    
    private long idActiveCosts;
    
    private String concept;
    
    private BigDecimal amount;
    
    private ActivesCostsEnum type;
    
    private boolean complete;
    
}
