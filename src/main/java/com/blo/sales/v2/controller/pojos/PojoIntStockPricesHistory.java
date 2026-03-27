package com.blo.sales.v2.controller.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntStockPricesHistory {
    
    private long idStockPricesHistory;
    
    private long fkProduct;
    
    private long fkPriceHistory;
    
    private String timesTamp;
}
