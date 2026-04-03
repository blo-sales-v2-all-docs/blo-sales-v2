package com.blo.sales.v2.view.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PojoCategory {
    
    private long idCategory;
    
    private String description;
    
    private String category;
    
    @Override
    public String toString() {
        return String.format("%s %s", idCategory, category);
    }
    
}
