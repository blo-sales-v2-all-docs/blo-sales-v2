package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PriceHistoryEntity {
    
    private long id_price_history;
    
    private BigDecimal price;
    
    private BigDecimal cost_of_sale;
}
