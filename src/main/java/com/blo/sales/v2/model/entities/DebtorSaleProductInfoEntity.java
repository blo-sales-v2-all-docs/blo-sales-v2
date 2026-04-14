package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.PaymentTypeEntityEnum;
import lombok.Data;

public @Data class DebtorSaleProductInfoEntity {
    
    private long id_debtor;
    
    private String name;
    
    private long id_sale;
    
    private String timestamp;
    
    private PaymentTypeEntityEnum payment_type;
    
    private String authorization;
    
    private String product;
    
    private String payments;
    
}
