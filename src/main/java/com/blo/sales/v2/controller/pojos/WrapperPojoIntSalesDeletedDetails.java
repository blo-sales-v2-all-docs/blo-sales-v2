package com.blo.sales.v2.controller.pojos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class WrapperPojoIntSalesDeletedDetails {
    
    List<PojoIntSaleDeletedDetail> salesDeleted;
    
}
