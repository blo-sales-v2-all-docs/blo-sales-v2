package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.ReasonsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypesIntEnum;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PojoIntFinancialMovement {
    
    private long idFinancialMovement;
    
    private long fkAccount;
    
    private long fkUser;
    
    private BigDecimal amount;
    
    private ReasonsIntEnum reason;
    
    private TypesIntEnum type;
    
    private String timestamp;
    
}
