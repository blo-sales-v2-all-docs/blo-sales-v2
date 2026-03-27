package com.blo.sales.v2.controller.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntDebtorSale {
    
    private long idDebtorSale;
    
    private long fkSale;
    
    private long fkDebtor;
    
    private String timestamp;
}
