package com.blo.sales.v2.view.pojos.enums;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public enum StatusOrderProviderEnum {
    
    PENDIG("Pendiente de entrega", 0), DELIVERED("Entregado", 1), CANCELLED("Cancelado", 2);
    
    @Getter
    private final String target;
    
    @Getter
    private final int index;
    
    private StatusOrderProviderEnum(String target, int index) {
        this.target = target;
        this.index = index;
    }
    
    public static List<StatusOrderProviderEnum> getVisiblesTypes(int sinceIndex) {
         return Arrays.asList(StatusOrderProviderEnum.values()).subList(sinceIndex, StatusOrderProviderEnum.values().length);
    }
    
    public static StatusOrderProviderEnum getByIndex(int index) {
        return Arrays.stream(StatusOrderProviderEnum.values())
            .filter(e -> e.getIndex() == index)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Index no válido: " + index));
    }
}
