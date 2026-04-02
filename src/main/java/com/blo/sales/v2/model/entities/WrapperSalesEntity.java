package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperSalesEntity {
    
    private List<SaleEntity> sales;

    public List<SaleEntity> getSales() {
        return sales;
    }

    public void setSales(List<SaleEntity> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperSalesEntity{");
        sb.append("sales=").append(sales);
        sb.append('}');
        return sb.toString();
    }
    
}
