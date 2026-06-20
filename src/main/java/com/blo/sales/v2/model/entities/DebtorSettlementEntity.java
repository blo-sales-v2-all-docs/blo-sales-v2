package com.blo.sales.v2.model.entities;

import lombok.Data;

@Data
public class DebtorSettlementEntity {
    
    private long id_debt_settlement;
    
    private SaleEntity fk_sale;
    
    private String debtor;
    
    private String products_details;
    
    private String payments;
    
    private String timestamp;
    
}
