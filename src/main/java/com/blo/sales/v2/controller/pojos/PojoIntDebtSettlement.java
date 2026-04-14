package com.blo.sales.v2.controller.pojos;

import java.sql.Timestamp;
import lombok.Data;

public @Data class PojoIntDebtSettlement {
    
    private long idDebtSettlement;
    
    private long fkSale;
    
    private String debtor;
    
    private String productsDetails;
    
    private String payments;
    
    private Timestamp timestamp;
}
