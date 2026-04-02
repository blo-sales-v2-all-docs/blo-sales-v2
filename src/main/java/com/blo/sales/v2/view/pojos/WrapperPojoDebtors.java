package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoDebtors {
    
    private List<PojoDebtor> debtors;

    public List<PojoDebtor> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<PojoDebtor> debtors) {
        this.debtors = debtors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoDebtors{");
        sb.append("debtors=").append(debtors);
        sb.append('}');
        return sb.toString();
    }
    
}
