package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class TopUpEntity {
    
    private long id_top_up;
    
    private UserEntity fk_user;
    
    private MobileCompanyEntity fk_mobile_company;
    
    private BigDecimal amount;
    
    private boolean checked;
    
    private String phone_number;
    
    private String timestamp;

}
