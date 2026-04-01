package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoCashboxesSalesDetails {
    
    private List<PojoCashboxSaleDetail> cashboxes;

    public List<PojoCashboxSaleDetail> getCashboxes() {
        return cashboxes;
    }

    public void setCashboxes(List<PojoCashboxSaleDetail> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoCashboxesSalesDetails{");
        sb.append("cashboxes=").append(cashboxes);
        sb.append('}');
        return sb.toString();
    }

}
