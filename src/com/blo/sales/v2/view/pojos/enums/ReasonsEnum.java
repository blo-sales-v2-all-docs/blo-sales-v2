package com.blo.sales.v2.view.pojos.enums;

public enum ReasonsEnum {
    
    SALE("Vendido"), LOST("Perdido"), REPLENISHMENT("Reabastecimiento"), PRODUCT_NOT_MODIFIED("No modificado"), DEVOLUTION("Devolución"), PRODUCT_DELETED("Eliminado");
    
    private final String reasonTarget;
    
    private ReasonsEnum(String reasonTarget) {
        this.reasonTarget = reasonTarget;
    }

    public String getReasonTarget() {
        return reasonTarget;
    }
    
}
