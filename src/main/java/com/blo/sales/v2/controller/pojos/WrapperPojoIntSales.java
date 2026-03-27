package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntSales {
    
    private List<PojoIntSale> sales;

    public List<PojoIntSale> getSales() {
        return sales;
    }

    public void setSales(List<PojoIntSale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntSales{");
        sb.append("sales=").append(sales);
        sb.append('}');
        return sb.toString();
    }
    
}
