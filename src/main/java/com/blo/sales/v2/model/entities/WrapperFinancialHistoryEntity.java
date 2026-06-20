package com.blo.sales.v2.model.entities;

import java.util.List;
import lombok.Data;

@Data
public class WrapperFinancialHistoryEntity {
    
    private List<FinancialMovementEntity> history;
    
}
