package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.RolesEntityEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEntity {
    
    private long id_user;
    
    private String username;
    
    private String password;
    
    private RolesEntityEnum role;
}
