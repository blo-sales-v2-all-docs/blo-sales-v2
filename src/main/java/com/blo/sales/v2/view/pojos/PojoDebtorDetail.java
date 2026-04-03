package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoDebtorDetail {
    
    private long idDebtor;
    
    private String name;
    
    private BigDecimal debt;
    
    private String payments;
    
    private String product;
    
    private BigDecimal quantitySale;
    
    private BigDecimal totalOnSale;
    
    private String timestamp;
}
