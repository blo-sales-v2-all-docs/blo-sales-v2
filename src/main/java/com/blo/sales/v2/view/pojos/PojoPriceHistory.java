package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoPriceHistory {
    
    private long idPriceHistory;
    
    private BigDecimal price;
    
    private BigDecimal costOfSale;
}
