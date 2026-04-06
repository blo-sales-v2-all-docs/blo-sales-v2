package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.controller.pojos.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter 
public @ToString class PojoSaleDeletedDetail {
    
    private long idSaleDeleted;
    
    private long fkSaleProduct;
    
    private long fkUser;
    
    private String reason;
    
    private String timestamp;
    
    private String product;
    
    private String username;

}
