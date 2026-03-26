package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;

public class PojoIntPriceHistory {
    
    private long idPriceHistory;
    
    private BigDecimal price;
    
    private BigDecimal costOfSale;

    public long getIdPriceHistory() {
        return idPriceHistory;
    }

    public void setIdPriceHistory(long idPriceHistory) {
        this.idPriceHistory = idPriceHistory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCostOfSale() {
        return costOfSale;
    }

    public void setCostOfSale(BigDecimal costOfSale) {
        this.costOfSale = costOfSale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntPriceHistory{");
        sb.append("idPriceHistory=").append(idPriceHistory);
        sb.append(", price=").append(price);
        sb.append(", costOfSale=").append(costOfSale);
        sb.append('}');
        return sb.toString();
    }

    
}
