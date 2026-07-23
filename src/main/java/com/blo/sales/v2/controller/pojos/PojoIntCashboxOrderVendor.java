package com.blo.sales.v2.controller.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntCashboxOrderVendor {
    
    private long idCashboxOrderVendor;
    
    private long fkOrderVendor;
    
    private long fkCashbox;
    
    private String timestamp;
}
