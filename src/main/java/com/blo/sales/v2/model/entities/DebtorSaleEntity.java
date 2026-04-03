package com.blo.sales.v2.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class DebtorSaleEntity {
    
    private long id_debtor_sale;
    
    private long fk_sale;
    
    private long fk_debtor;
    
    private String timestamp;
    
}
