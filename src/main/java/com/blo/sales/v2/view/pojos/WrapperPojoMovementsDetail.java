package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoMovementsDetail {
    
    private List<PojoMovementDetail> history;

    public List<PojoMovementDetail> getHistory() {
        return history;
    }

    public void setHistory(List<PojoMovementDetail> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoMovementsDetail{");
        sb.append("history=").append(history);
        sb.append('}');
        return sb.toString();
    }

}
