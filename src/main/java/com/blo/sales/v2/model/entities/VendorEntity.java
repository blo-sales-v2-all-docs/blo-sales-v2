package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.VisitsEntityEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class VendorEntity {
    
    private long id_vendor;
    
    private long fk_user;
    
    private String name;
    
    private String brand;
    
    private String visit_days;
    
    private boolean pre_sale;
    
    private String timestamp;
    
    private String contact;
    
    private boolean per_week;
    
    private VisitsEntityEnum visits;
    
}
