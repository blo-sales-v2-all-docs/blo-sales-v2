package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.ActivesCostsEntityEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ActiveCostEntity {
    
    private long id_actives_costs;
    
    private String concept;
    
    private BigDecimal amount;
    
    private ActivesCostsEntityEnum type;
    
    private boolean complete;

}
