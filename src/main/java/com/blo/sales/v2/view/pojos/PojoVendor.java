package com.blo.sales.v2.view.pojos;

import lombok.Data;

public @Data class PojoVendor {
    
    private long idVendor;
    
    private long fkUser;
    
    private String name;
    
    private String brand;
    
    private String visitDays;
    
    private boolean preSale;
    
    private String timestamp;
    
    private String contact;
    
}
