package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.ActivesCostsEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PojoActiveCost {
    
    public static final String SEPARATOR = ":";
    
    public static final int INDEX_AMOUNT = 1;
    
    private long idActiveCosts;
    
    private String concept;
    
    private BigDecimal amount;
    
    private ActivesCostsEnum type;
    
    private boolean complete;

    @Override
    public String toString() {
        return "concepo: " + concept + ", monto: " + amount + ", es: " + type;
    }
    
}
