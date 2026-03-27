package com.blo.sales.v2.view.pojos.enums;

public enum ReasonsEnum {
    
    SALE("Vendido", 0), LOST("Perdido", 1), REPLENISHMENT("Reabastecimiento", 2), PRODUCT_NOT_MODIFIED("No modificado", 3), DEVOLUTION("Devolución", 4), PRODUCT_DELETED("Eliminado", 5);
    
    private final String reasonTarget;
    
    private final int index;
    
    private ReasonsEnum(String reasonTarget, int index) {
        this.reasonTarget = reasonTarget;
        this.index = index;
    }

    public String getReasonTarget() {
        return reasonTarget;
    }
    
    public int getIndex() {
        return index;
    }
    
}
