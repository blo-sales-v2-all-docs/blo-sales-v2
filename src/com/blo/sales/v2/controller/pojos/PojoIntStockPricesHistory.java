package com.blo.sales.v2.controller.pojos;

public class PojoIntStockPricesHistory {
    
    private long idStockPricesHistory;
    
    private long fkProduct;
    
    private long fkPriceHistory;
    
    private String timesTamp;

    public long getIdStockPricesHistory() {
        return idStockPricesHistory;
    }

    public void setIdStockPricesHistory(long idStockPricesHistory) {
        this.idStockPricesHistory = idStockPricesHistory;
    }

    public long getFkProduct() {
        return fkProduct;
    }

    public void setFkProduct(long fkProduct) {
        this.fkProduct = fkProduct;
    }

    public long getFkPriceHistory() {
        return fkPriceHistory;
    }

    public void setFkPriceHistory(long fkPriceHistory) {
        this.fkPriceHistory = fkPriceHistory;
    }

    public String getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(String timesTamp) {
        this.timesTamp = timesTamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntStockPricesHistory{");
        sb.append("idStockPricesHistory=").append(idStockPricesHistory);
        sb.append(", fkProduct=").append(fkProduct);
        sb.append(", fkPriceHistory=").append(fkPriceHistory);
        sb.append(", timesTamp=").append(timesTamp);
        sb.append('}');
        return sb.toString();
    }
    
}
