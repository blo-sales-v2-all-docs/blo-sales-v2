package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntProducts {
    
    private List<PojoIntProduct> products;

    public List<PojoIntProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PojoIntProduct> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntProducts{");
        sb.append("products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}
