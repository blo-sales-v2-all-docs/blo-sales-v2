package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.CashboxStatusIntEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntCashbox {
    
    private long idCashbox;
    
    private long fkUser;
    
    private String timestamp;
    
    private BigDecimal amount;
    
    private CashboxStatusIntEnum status;
    
    private String userFrom;

}
