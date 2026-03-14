package com.blo.sales.v2.controller.pojos.enums;

public enum TopUpSearchStatusIntEnum {
    
     ALL(false), CHECKED(true), NO_CHECKED(false);
    
    private final boolean value;
    
    private TopUpSearchStatusIntEnum(boolean value) {
        this.value = value;
    }
    
    public boolean isValue() {
        return this.value;
    }
}
