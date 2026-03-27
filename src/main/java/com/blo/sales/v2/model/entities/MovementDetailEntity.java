package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.ReasonsEntityEnum;
import com.blo.sales.v2.model.entities.enums.TypesEntityEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MovementDetailEntity {
    
    private long id_movement;
    
    private TypesEntityEnum type;
    
    private ReasonsEntityEnum reason;
    
    private long id_product;
    
    private String product;
    
    private String timestamp;
    
    private String username;
    
    private BigDecimal quantity;

}
