package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.ReasonsEnum;
import com.blo.sales.v2.view.pojos.enums.TypesEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoMovementDetail {
    
    private long idMovement;
    
    private TypesEnum type;
    
    private ReasonsEnum reason;
    
    private long idProduct;
    
    private String product;
    
    private String timestamp;
    
    private String username;
    
    private BigDecimal quantity;
}
