package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntMovementsDetail {
    
    private List<PojoIntMovementDetail> history;

    public List<PojoIntMovementDetail> getHistory() {
        return history;
    }

    public void setHistory(List<PojoIntMovementDetail> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntMovementsDetail{");
        sb.append("history=").append(history);
        sb.append('}');
        return sb.toString();
    }

    
}
