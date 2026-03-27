package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.ReasonsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypesIntEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoIntMovementDetail {
    
    private long idMovement;
    
    private TypesIntEnum type;
    
    private ReasonsIntEnum reason;
    
    private long idProduct;
    
    private String product;
    
    private String timestamp;
    
    private String username;
    
    private BigDecimal quantity;
}
