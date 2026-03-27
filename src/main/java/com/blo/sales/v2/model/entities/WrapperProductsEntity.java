package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperProductsEntity {
    
    private List<ProductEntity> products;

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperProductsEntity{");
        sb.append("products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}
