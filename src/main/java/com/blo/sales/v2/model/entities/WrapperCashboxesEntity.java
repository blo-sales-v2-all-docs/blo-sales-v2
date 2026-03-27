package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperCashboxesEntity {
    
    private List<CashboxEntity> cashboxes;

    public List<CashboxEntity> getCashboxes() {
        return cashboxes;
    }

    public void setCashboxes(List<CashboxEntity> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperCashboxesEntity{");
        sb.append("cashboxes=").append(cashboxes);
        sb.append('}');
        return sb.toString();
    }
}
