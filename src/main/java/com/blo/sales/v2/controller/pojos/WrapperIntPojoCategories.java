package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperIntPojoCategories {
    
    private List<PojoIntCategory> categories;

    public List<PojoIntCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PojoIntCategory> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperIntPojoCategories{");
        sb.append("categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }
    
}
