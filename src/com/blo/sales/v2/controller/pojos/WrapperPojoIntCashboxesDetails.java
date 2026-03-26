package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntCashboxesDetails {
    
    private List<PojoIntCashboxDetail> cashboxesInfo;

    public List<PojoIntCashboxDetail> getCashboxesInfo() {
        return cashboxesInfo;
    }

    public void setCashboxesInfo(List<PojoIntCashboxDetail> cashboxesInfo) {
        this.cashboxesInfo = cashboxesInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntCashboxesDetails{");
        sb.append("cashboxesInfo=").append(cashboxesInfo);
        sb.append('}');
        return sb.toString();
    }

}
