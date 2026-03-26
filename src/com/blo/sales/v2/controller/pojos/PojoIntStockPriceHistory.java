package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;

public class PojoIntStockPriceHistory {
    
    private long idStockPriceHistory;
    
    private String product;
    
    private BigDecimal price;
    
    private BigDecimal costOfSale;
    
    private String timestamp;

    public long getIdStockPriceHistory() {
        return idStockPriceHistory;
    }

    public void setId_stock_price_history(long idStockPriceHistory) {
        this.idStockPriceHistory = idStockPriceHistory;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntStockPriceHistory{");
        sb.append("idStockPriceHistory=").append(idStockPriceHistory);
        sb.append(", product=").append(product);
        sb.append(", price=").append(price);
        sb.append(", costOfSale=").append(costOfSale);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }

}
