package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntDebtorsSales {
    
    private List<PojoIntDebtorSale> debtorsSales;

    public List<PojoIntDebtorSale> getDebtorsSales() {
        return debtorsSales;
    }

    public void setDebtorsSales(List<PojoIntDebtorSale> debtorsSales) {
        this.debtorsSales = debtorsSales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntDebtorsSales{");
        sb.append("debtorsSales=").append(debtorsSales);
        sb.append('}');
        return sb.toString();
    }
    
}
