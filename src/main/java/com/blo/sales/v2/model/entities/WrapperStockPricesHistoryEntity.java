package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperStockPricesHistoryEntity {
    
    private List<StockPriceHistoryEntity> history;

    public List<StockPriceHistoryEntity> getHistory() {
        return history;
    }

    public void setHistory(List<StockPriceHistoryEntity> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperStockPricesHistoryEntity{");
        sb.append("history=").append(history);
        sb.append('}');
        return sb.toString();
    }
    
}
