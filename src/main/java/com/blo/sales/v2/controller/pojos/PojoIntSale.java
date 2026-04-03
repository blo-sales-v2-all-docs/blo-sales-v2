package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.SalesStatusIntEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntSale {

    private long idSale;

    private BigDecimal total;

    private SalesStatusIntEnum saleStatus;
    
    private String timestamp;

}
