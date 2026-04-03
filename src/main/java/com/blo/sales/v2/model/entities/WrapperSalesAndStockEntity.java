package com.blo.sales.v2.model.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class WrapperSalesAndStockEntity {
    
    private List<SaleAndProductEntity> salesDetail;
    
}
