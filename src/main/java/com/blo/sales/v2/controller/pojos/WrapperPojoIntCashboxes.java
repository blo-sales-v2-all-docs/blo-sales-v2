package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntCashboxes {
    
    private List<PojoIntCashbox> cashboxes;

    public List<PojoIntCashbox> getCashboxes() {
        return cashboxes;
    }

    public void setCashboxes(List<PojoIntCashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntCashboxes{");
        sb.append("cashboxes=").append(cashboxes);
        sb.append('}');
        return sb.toString();
    }

    
}
