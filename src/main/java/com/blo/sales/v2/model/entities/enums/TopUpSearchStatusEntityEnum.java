package com.blo.sales.v2.model.entities.enums;

public enum TopUpSearchStatusEntityEnum {
    
    ALL(false), CHECKED(true), NO_CHECKED(false);
    
    private final boolean value;
    
    private TopUpSearchStatusEntityEnum(boolean value) {
        this.value = value;
    }
    
    public boolean isValue() {
        return this.value;
    }
}
