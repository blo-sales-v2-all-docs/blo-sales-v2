package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntDebtors {
    
    private List<PojoIntDebtor> debtors;

    public List<PojoIntDebtor> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<PojoIntDebtor> debtors) {
        this.debtors = debtors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntDebtors{");
        sb.append("debtors=").append(debtors);
        sb.append('}');
        return sb.toString();
    }
    
}
