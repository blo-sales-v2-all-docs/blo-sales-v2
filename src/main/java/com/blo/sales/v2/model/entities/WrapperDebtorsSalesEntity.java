package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperDebtorsSalesEntity {
    
    private List<DebtorSaleEntity> debtorsSales;

    public List<DebtorSaleEntity> getDebtorsSales() {
        return debtorsSales;
    }

    public void setDebtorsSales(List<DebtorSaleEntity> debtorsSales) {
        this.debtorsSales = debtorsSales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperDebtorsSalesEntity{");
        sb.append("debtorsSales=").append(debtorsSales);
        sb.append('}');
        return sb.toString();
    }
    
}
