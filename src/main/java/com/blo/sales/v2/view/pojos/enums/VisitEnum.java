package com.blo.sales.v2.view.pojos.enums;

import lombok.Getter;

public enum VisitEnum {
    
    WEEKLY("Por semana"),
    EVERY_TWO_WEEKS("Cada 2 semanas"),
    EVERY_THREE_WEEKS("Cada 3 semanas"),
    MONTHLY("Mensualmente");
    
    @Getter
    private final String target;
    
    private VisitEnum(String target) {
        this.target = target;
    }

    
}
