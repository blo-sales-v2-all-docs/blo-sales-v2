package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.SalesStatusEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoSale {
    
    private long idSale;

    private BigDecimal total;

    private SalesStatusEnum saleStatus;

    private String timestamp;
}
