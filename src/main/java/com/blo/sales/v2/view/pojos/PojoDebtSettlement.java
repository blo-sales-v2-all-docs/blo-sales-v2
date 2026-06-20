package com.blo.sales.v2.view.pojos;

import lombok.Data;

@Data
public class PojoDebtSettlement {
    
    private long idDebtSettlement;
    
    private long fkSale;
    
    private String debtor;
    
    private String productsDetails;
    
    private String payments;
    
    private String timestamp;
    
}
