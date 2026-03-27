package com.blo.sales.v2.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CashboxesActivesCostsEntity {
    
    private long id_cashboxes_actives_costs;
    
    private long fk_cashbox;
    
    private long fk_actives_costs;
    
    private String timestamp;
    
}
