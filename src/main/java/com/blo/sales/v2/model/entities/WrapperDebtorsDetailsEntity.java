package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperDebtorsDetailsEntity {
    
    private List<DebtorDetailEntity> debtors;

    public List<DebtorDetailEntity> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<DebtorDetailEntity> debtors) {
        this.debtors = debtors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperDebtorsDetailsEntity{");
        sb.append("debtors=").append(debtors);
        sb.append('}');
        return sb.toString();
    }
    
}
