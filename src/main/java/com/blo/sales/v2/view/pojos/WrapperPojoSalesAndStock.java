package com.blo.sales.v2.view.pojos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class WrapperPojoSalesAndStock {
    
    private List<PojoSaleAndProduct> salesDetail;

}
