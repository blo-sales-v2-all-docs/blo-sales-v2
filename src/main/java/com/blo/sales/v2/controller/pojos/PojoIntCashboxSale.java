package com.blo.sales.v2.controller.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntCashboxSale {
    
    private long idCashboxSale;
    
    private PojoIntCashbox fkCashbox;
    
    private PojoIntSale fkSale;

}
