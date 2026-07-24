package com.blo.sales.v2.view.pojos.enums;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public enum FilterCreditEnum {
    
    PENDINGS("Pendientes", 0), PAYED("Pagados", 1), CANCELLED("Cancelados", 2);
    
    @Getter
    private final String target;
    
    @Getter
    private final int index;
    
    private FilterCreditEnum(String target, int index) {
        this.target = target;
        this.index = index;
    }
    
    public static List<FilterCreditEnum> getVisiblesTypes() {
         return Arrays.asList(FilterCreditEnum.values()).subList(0, 2);
    }
    
    public static FilterCreditEnum getByIndex(int index) {
        return Arrays.stream(FilterCreditEnum.values())
            .filter(e -> e.getIndex() == index)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Index no válido: " + index));
    }
}
