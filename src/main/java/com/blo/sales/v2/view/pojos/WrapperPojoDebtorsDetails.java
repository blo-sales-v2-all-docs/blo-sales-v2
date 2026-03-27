package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoDebtorsDetails {
    
    private List<PojoDebtorDetail> debtors;

    public List<PojoDebtorDetail> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<PojoDebtorDetail> debtors) {
        this.debtors = debtors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoDebtorsDetails{");
        sb.append("debtors=").append(debtors);
        sb.append('}');
        return sb.toString();
    }
    
}
