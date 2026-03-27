package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntStockPriceHistory {
    
    private List<PojoIntStockPriceHistory> history;

    public List<PojoIntStockPriceHistory> getHistory() {
        return history;
    }

    public void setHistory(List<PojoIntStockPriceHistory> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntStockPriceHistory{");
        sb.append("history=").append(history);
        sb.append('}');
        return sb.toString();
    }
    
}
