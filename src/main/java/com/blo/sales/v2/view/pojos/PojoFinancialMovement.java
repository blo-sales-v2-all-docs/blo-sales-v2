package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.ReasonsEnum;
import com.blo.sales.v2.view.pojos.enums.TypesEnum;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PojoFinancialMovement {
    
    private long idFinancialMovement;
    
    private long fkAccount;
    
    private long fkUser;
    
    private BigDecimal amount;
    
    private ReasonsEnum reason;
    
    private TypesEnum type;
    
    private String authorization;
    
    private String timestamp;
    
}
