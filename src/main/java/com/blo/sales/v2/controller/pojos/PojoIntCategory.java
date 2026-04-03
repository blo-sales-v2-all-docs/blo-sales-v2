package com.blo.sales.v2.controller.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntCategory {
    
    private long idCategory;
    
    private String category;
    
    private String description;
}
