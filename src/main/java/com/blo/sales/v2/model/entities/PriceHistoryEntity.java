package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;

public class PriceHistoryEntity {
    
    private long id_price_history;
    
    private BigDecimal price;
    
    private BigDecimal cost_of_sale;

    public long getId_price_history() {
        return id_price_history;
    }

    public void setId_price_history(long id_price_history) {
        this.id_price_history = id_price_history;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost_of_sale() {
        return cost_of_sale;
    }

    public void setCost_of_sale(BigDecimal cost_of_sale) {
        this.cost_of_sale = cost_of_sale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriceHistoryEntity{");
        sb.append("id_price_history=").append(id_price_history);
        sb.append(", price=").append(price);
        sb.append(", cost_of_sale=").append(cost_of_sale);
        sb.append('}');
        return sb.toString();
    }
}
