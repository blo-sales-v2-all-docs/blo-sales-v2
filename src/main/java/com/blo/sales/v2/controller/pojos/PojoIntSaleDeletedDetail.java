package com.blo.sales.v2.controller.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntSaleDeletedDetail {
    
    private long idSaleDeleted;
    
    private long fkSaleProduct;
    
    private long fkUser;
    
    private String reason;
    
    private String timestamp;
}
