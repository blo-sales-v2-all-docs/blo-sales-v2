package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.RolesIntEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntLoggedInUser {
    
    private long idUser;
    
    private String username;
    
    private RolesIntEnum role;
}
