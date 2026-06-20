package com.blo.sales.v2.model.entities.enums;

import lombok.Getter;

public enum StatusOrderVendorEntityEnum {
    
    PENDIG("Se levantó pedido y está a la espera de entrega"), CANCELLED("El pedido fue cancelado"), DELIVERED("El pedido fue entregado");
    
    @Getter
    private final String description;
    
    private StatusOrderVendorEntityEnum(String description) {
        this.description = description;
    }
    
}
