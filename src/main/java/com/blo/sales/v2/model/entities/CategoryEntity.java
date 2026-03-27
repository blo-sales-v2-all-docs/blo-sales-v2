package com.blo.sales.v2.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CategoryEntity {
    
    private long id_category;
    
    private String category;
    
    private String description;
    
}
