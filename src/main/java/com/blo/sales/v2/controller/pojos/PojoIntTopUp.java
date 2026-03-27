package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntTopUp {
    
    private long idTopUp;
    
    private PojoIntLoggedInUser fkUser;
    
    private PojoIntMobileCompany fkMobileCompany;
    
    private BigDecimal amount;
    
    private boolean checked;
    
    private String phoneNumber;
    
    private String timestamp;

}
