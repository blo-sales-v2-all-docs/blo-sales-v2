package com.blo.sales.v2.model.entities;

import lombok.Data;

public @Data class VendorEntity {
    
    private long id_vendor;
    
    private long fk_user;
    
    private String name;
    
    private String brand;
    
    private String visit_days;
    
    private boolean pre_sale;
    
    private String timestamp;
    
    private String contact;
    
}
