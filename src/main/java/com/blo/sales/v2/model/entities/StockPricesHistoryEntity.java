package com.blo.sales.v2.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class StockPricesHistoryEntity {
    
    private long id_stock_prices_history;
    
    private long fk_product;
    
    private long fk_price_history;
    
    private String timesTamp;

}
