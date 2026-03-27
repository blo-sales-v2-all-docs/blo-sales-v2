package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntDebtorsDetails {
    
    private List<PojoIntDebtorDetail> debtors;

    public List<PojoIntDebtorDetail> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<PojoIntDebtorDetail> debtors) {
        this.debtors = debtors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntDebtorsDetails{");
        sb.append("debtors=").append(debtors);
        sb.append('}');
        return sb.toString();
    }
    
}
