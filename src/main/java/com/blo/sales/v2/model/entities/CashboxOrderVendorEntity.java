package com.blo.sales.v2.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class CashboxOrderVendorEntity {
    
    private long idCashboxOrderVendor;
    
    private long fkOrderVendor;
    
    private long fkCashbox;
    
    private String timestamp;
    
}
