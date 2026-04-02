package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoCategories {
    
    private List<PojoCategory> categories;

    public List<PojoCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PojoCategory> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoCategories{");
        sb.append("categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }
    
}
