package com.blo.sales.v2.view.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoDebtorSale {
    
    private long idDebtorSale;
    
    private long fkSale;
    
    private long fkDebtor;
    
    private String timestamp;
    
}
