package com.blo.sales.v2.controller.pojos;

import lombok.Data;

public @Data class PojoIntVendor {
    
    private long idVendor;
    
    private long fkUser;
    
    private String name;
    
    private String brand;
    
    private String visitDays;
    
    private boolean preSale;
    
    private String timestamp;
    
    private String contact;
    
    private boolean perWeek;
    
}
