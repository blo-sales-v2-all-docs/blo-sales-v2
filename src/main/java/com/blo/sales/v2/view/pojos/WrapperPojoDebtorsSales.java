package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoDebtorsSales {
    
    private List<PojoDebtorSale> debtorsSales;

    public List<PojoDebtorSale> getDebtorsSales() {
        return debtorsSales;
    }

    public void setDebtorsSales(List<PojoDebtorSale> debtorsSales) {
        this.debtorsSales = debtorsSales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoDebtorsSales{");
        sb.append("debtorsSales=").append(debtorsSales);
        sb.append('}');
        return sb.toString();
    }
    
}
