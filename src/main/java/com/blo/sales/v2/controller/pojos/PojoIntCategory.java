package com.blo.sales.v2.controller.pojos;

public class PojoIntCategory {
    
    private long idCategory;
    
    private String category;
    
    private String description;

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntCategory{");
        sb.append("idCategory=").append(idCategory);
        sb.append(", category=").append(category);
        sb.append(", description=").append(description);
        sb.append('}');
        return sb.toString();
    }
    
}
