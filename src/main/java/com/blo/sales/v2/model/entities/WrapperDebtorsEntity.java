package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperDebtorsEntity {
    
    private List<DebtorEntity> debtors;

    public List<DebtorEntity> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<DebtorEntity> debtors) {
        this.debtors = debtors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperDebtorsEntity{");
        sb.append("debtors=").append(debtors);
        sb.append('}');
        return sb.toString();
    }
    
}
