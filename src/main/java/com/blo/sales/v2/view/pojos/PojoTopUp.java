package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoTopUp {
    
    private long idTopUp;
    
    private PojoLoggedInUser fkUser;
    
    private PojoMobileCompany fkMobileCompany;
    
    private BigDecimal amount;
    
    private boolean checked;
    
    private String phoneNumber;
    
    private String timestamp;
}
