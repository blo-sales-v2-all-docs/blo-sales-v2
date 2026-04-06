package com.blo.sales.v2.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class SaleDeletedDetailEntity {
    
    private long id_sale_deleted;
    
    private long fk_sale_product;
    
    private long fk_user;
    
    private String reason;
    
    private String timestamp;
    
    private String product;
    
    private String username;
}
