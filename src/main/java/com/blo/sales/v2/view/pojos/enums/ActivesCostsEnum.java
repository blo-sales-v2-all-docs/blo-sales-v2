package com.blo.sales.v2.view.pojos.enums;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public enum ActivesCostsEnum  {
    
    ACTIVO("Activo", 0), PASIVO("Costo", 1);
    
    @Getter
    private final String target;
    
    @Getter
    private final int index;
    
    private ActivesCostsEnum(String target, int index) {
        this.target = target;
        this.index = index;
    }
    
    public static List<ActivesCostsEnum> getVisiblesTypes() {
         return Arrays.asList(ActivesCostsEnum.values());
    }
    
    public static ActivesCostsEnum getByIndex(int index) {
        return Arrays.stream(ActivesCostsEnum.values())
            .filter(e -> e.getIndex() == index)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Index no válido: " + index));
    }
}
