package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SaleProductEntity {
    
    @Setter
    @Getter
    private long id_sale_product;

    @Setter
    @Getter
    private long fk_sale;
    
    @Setter
    @Getter
    private long fk_product;

    @Setter
    @Getter
    private BigDecimal qunatity_sale;
    
    @Setter
    @Getter
    private BigDecimal total_on_sale;
    
    @Setter
    @Getter
    private BigDecimal product_total_on_sale;
    
    @Setter
    @Getter
    private String timestamp;
    
    private boolean live;

    public boolean is_live() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
