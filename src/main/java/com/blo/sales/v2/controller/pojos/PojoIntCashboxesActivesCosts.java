package com.blo.sales.v2.controller.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntCashboxesActivesCosts {
    
    private long idCashboxesActivesCosts;
    
    private long fkCashbox;
    
    private long fkActivesCosts;
    
    private String timestamp;
}
