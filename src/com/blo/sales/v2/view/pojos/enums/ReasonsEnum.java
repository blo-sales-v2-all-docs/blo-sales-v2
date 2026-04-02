package com.blo.sales.v2.view.pojos.enums;

import java.util.Arrays;
import java.util.List;

public enum ReasonsEnum {
    
    SALE("Vendido", 0), LOST("Perdido", 1), REPLENISHMENT("Reabastecimiento", 2), PRODUCT_NOT_MODIFIED("No modificado", 3), DEVOLUTION("Devolución", 4), PRODUCT_DELETED("Eliminado", 5);
    
    private final String reasonTarget;
    
    private final int index;
    
    private ReasonsEnum(String reasonTarget, int index) {
        this.reasonTarget = reasonTarget;
        this.index = index;
    }
    
    public static List<ReasonsEnum> getVisiblesReasons() {
        return Arrays.asList(ReasonsEnum.values()).subList(0, 3);
    }
    
    public static ReasonsEnum findReasonByReason(String reason) {
        return getVisiblesReasons().stream().
                filter(r -> r.getReasonTarget().equals(reason)).
                findFirst().
                orElse(ReasonsEnum.PRODUCT_NOT_MODIFIED);
    }

    public String getReasonTarget() {
        return reasonTarget;
    }
    
    public int getIndex() {
        return index;
    }
    
}
