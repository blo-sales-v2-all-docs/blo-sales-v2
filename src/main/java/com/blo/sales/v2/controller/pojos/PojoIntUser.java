package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.RolesIntEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PojoIntUser {
 
    private String userName;
    
    private String password;
    
    private RolesIntEnum rol;
    
    private long idUser;
}
