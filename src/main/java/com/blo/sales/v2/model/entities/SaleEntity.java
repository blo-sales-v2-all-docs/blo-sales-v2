package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.SaleStatusEntityEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SaleEntity {
    
    private long id_sale;
    
    private BigDecimal total;
    
    private SaleStatusEntityEnum sale_status;
    
    private String timestamp;
}
