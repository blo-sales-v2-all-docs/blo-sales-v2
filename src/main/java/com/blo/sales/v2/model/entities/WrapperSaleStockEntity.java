package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperSaleStockEntity {
    
    private List<SaleProductEntity> salesStock;

    public List<SaleProductEntity> getSalesStock() {
        return salesStock;
    }

    public void setSalesStock(List<SaleProductEntity> salesStock) {
        this.salesStock = salesStock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperSaleStockEntity{");
        sb.append("salesStock=").append(salesStock);
        sb.append('}');
        return sb.toString();
    }
    
}
