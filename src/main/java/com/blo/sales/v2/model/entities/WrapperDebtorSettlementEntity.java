package com.blo.sales.v2.model.entities;

import java.util.List;
import lombok.Data;

@Data
public class WrapperDebtorSettlementEntity {
    
    private List<DebtorSettlementEntity> debtor_settlements;
    
}
