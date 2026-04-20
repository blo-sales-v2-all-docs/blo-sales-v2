package com.blo.sales.v2.view.pojos.enums;

import lombok.Getter;

public enum AccountsEnum {
    
    DIGITAL_WALLET(1), WALLET(2);
    
    @Getter
    private final int id;
    
    private AccountsEnum(int id) {
        this.id = id;
    }
    
}
