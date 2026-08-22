package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoDebtorInfoDetail {
    
    private long idDebtor;
    
    private BigDecimal debt;
    
    private String payments;
    
    private String name;
    
    private List<PojoProduct> products;
    
}
