package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperCategoriesEntity {
    
    private List<CategoryEntity> categories;

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperCategoriesEntity{");
        sb.append("categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }
}
