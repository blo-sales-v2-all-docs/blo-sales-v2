package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoCashboxesDetails {
    
    private List<PojoCashboxDetail> cashboxesInfo;

    public List<PojoCashboxDetail> getCashboxesInfo() {
        return cashboxesInfo;
    }

    public void setCashboxesInfo(List<PojoCashboxDetail> cashboxesInfo) {
        this.cashboxesInfo = cashboxesInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoCashboxesDetails{");
        sb.append("cashboxesInfo=").append(cashboxesInfo);
        sb.append('}');
        return sb.toString();
    }

}
