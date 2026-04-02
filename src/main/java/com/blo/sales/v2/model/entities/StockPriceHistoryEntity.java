package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;

public class StockPriceHistoryEntity {
    
    private long id_stock_price_history;
    
    private String product;
    
    private BigDecimal price;
    
    private BigDecimal costOfSale;
    
    private String timestamp;

    public long getId_stock_price_history() {
        return id_stock_price_history;
    }

    public void setId_stock_price_history(long id_stock_price_history) {
        this.id_stock_price_history = id_stock_price_history;
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
        sb.append("StockPriceHistoryEntity{");
        sb.append("id_stock_price_history=").append(id_stock_price_history);
        sb.append(", product=").append(product);
        sb.append(", price=").append(price);
        sb.append(", costOfSale=").append(costOfSale);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
