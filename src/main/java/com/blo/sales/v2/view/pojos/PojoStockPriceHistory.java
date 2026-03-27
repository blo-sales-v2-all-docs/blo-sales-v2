package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoStockPriceHistory {
    
    private long idStockPriceHistory;
    
    private String product;
    
    private BigDecimal price;
    
    private BigDecimal costOfSale;
    
    private String timestamp;

}
