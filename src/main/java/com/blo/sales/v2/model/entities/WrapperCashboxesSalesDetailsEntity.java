package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperCashboxesSalesDetailsEntity {
    
    private List<CashboxSaleDetailEntity> cashboxes;

    public List<CashboxSaleDetailEntity> getCashboxes() {
        return cashboxes;
    }

    public void setCashboxes(List<CashboxSaleDetailEntity> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperCashboxesSalesDetailsEntity{");
        sb.append("cashboxes=").append(cashboxes);
        sb.append('}');
        return sb.toString();
    }
}
