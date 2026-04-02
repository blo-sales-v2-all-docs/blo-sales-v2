package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperCashboxesDetailsEntity {
    
    private List<CashboxDetailEntity> cashboxesInfo;

    public List<CashboxDetailEntity> getCashboxesInfo() {
        return cashboxesInfo;
    }

    public void setCashbocesInfo(List<CashboxDetailEntity> cashboxesInfo) {
        this.cashboxesInfo = cashboxesInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperCashboxesDetailsEntity{");
        sb.append("cashboxesInfo=").append(cashboxesInfo);
        sb.append('}');
        return sb.toString();
    }
    
}
