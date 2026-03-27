package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DebtorEntity {
    
    private long id_debtor;
    
    private String name;
    
    private BigDecimal debt;
    
    private String payments;

}
