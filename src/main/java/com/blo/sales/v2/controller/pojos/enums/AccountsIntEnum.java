package com.blo.sales.v2.controller.pojos.enums;

import lombok.Getter;

public enum AccountsIntEnum {
    
    DIGITAL_WALLET(1), WALLET(2);
    
    @Getter
    private final int id;
    
    private AccountsIntEnum(int id) {
        this.id = id;
    }
    
}
