package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntCashboxesSalesDetails {
    
    private List<PojoIntCashboxSaleDetail> cashboxes;

    public List<PojoIntCashboxSaleDetail> getCashboxes() {
        return cashboxes;
    }

    public void setCashboxes(List<PojoIntCashboxSaleDetail> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntCashboxesSalesDetails{");
        sb.append("cashboxes=").append(cashboxes);
        sb.append('}');
        return sb.toString();
    }

}
