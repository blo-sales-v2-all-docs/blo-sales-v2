package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.ReasonsEntityEnum;
import com.blo.sales.v2.model.entities.enums.TypesEntityEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class MovementEntity {
    
    private long id_movement;
    
    private long fk_product;
    
    private long fk_user;
    
    private TypesEntityEnum type;
    
    private BigDecimal quantity;
    
    private ReasonsEntityEnum reason;
    
    private String timestamp;
}
