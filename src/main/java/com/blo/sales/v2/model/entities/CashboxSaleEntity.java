package com.blo.sales.v2.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class CashboxSaleEntity {
    
    private long id_cashbox_sale;
    
    private CashboxEntity fk_cashbox;
    
    private SaleEntity fk_sale;

}
