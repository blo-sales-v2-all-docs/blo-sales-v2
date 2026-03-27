package com.blo.sales.v2.view.pojos.enums;

public enum TopUpSearchStatusEnum {
    
    ALL(false, "Todo"), CHECKED(true, "Contado"), NO_CHECKED(false, "No contado");
    
    private final boolean value;
    
    private final String target;
    
    private TopUpSearchStatusEnum(boolean value, String target) {
        this.value = value;
        this.target = target;
    }
    
    public boolean isValue() {
        return this.value;
    }

    public String getTarget() {
        return target;
    }
}
