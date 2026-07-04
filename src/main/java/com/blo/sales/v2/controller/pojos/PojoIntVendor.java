package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.VisitIntEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntVendor {
    
    private long idVendor;
    
    private long fkUser;
    
    private String name;
    
    private String brand;
    
    private String visitDays;
    
    private boolean preSale;
    
    private String timestamp;
    
    private String contact;
    
    private boolean perWeek;
    
    private VisitIntEnum visits;
    
}
