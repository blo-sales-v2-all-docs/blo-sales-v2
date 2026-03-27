package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.RolesEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PojoLoggedInUser {
    
    private long idUser;
    
    private RolesEnum role;
    
    private String username;
}
