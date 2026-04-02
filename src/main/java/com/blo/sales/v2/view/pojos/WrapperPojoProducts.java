package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoProducts {
    
    private List<PojoProduct> products;

    public List<PojoProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PojoProduct> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoProducts{");
        sb.append("products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}
