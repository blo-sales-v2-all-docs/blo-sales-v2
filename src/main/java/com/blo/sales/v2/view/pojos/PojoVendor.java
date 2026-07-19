package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.VisitEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoVendor {
    
    private long idVendor;
    
    private long fkUser;
    
    private String name;
    
    private String brand;
    
    private String visitDays;
    
    private boolean preSale;
    
    private String timestamp;
    
    private String contact;
    
    private boolean perWeek;
    
    private VisitEnum visits;
    
    public String getBasicData() {
        final var out = "[%s]\t%s - %s";
        return String.format(out, idVendor, name, brand);
    }
}
