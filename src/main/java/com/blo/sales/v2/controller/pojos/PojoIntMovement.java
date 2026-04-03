package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.model.entities.enums.ReasonsEntityEnum;
import com.blo.sales.v2.model.entities.enums.TypesEntityEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntMovement {
    
    private long idMovement;
    
    private long fkProduct;
    
    private long fkUser;
    
    private TypesEntityEnum type;
    
    private BigDecimal quantity;
    
    private ReasonsEntityEnum reason;
    
    private String timestamp;
    
}
