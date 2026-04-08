package com.blo.sales.v2.view.pojos.enums;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public enum PaymentTypeEnum {
    
    CASH("Efectivo", 0), TRANSFER("Pago con tarjeta", 1), BOTH("Ambos", 2);
    
    @Getter
    private final String paymentTypeTarget;
    
    @Getter
    private final int index;
    
    private PaymentTypeEnum(String paymentTypeTarget, int index) {
        this.paymentTypeTarget = paymentTypeTarget;
        this.index = index;
    }
    
    public static List<PaymentTypeEnum> getVisiblesTypes() {
         return Arrays.asList(PaymentTypeEnum.values()).subList(0, 2);
    }
    
    public static PaymentTypeEnum getByIndex(int index) {
        return Arrays.stream(PaymentTypeEnum.values())
            .filter(e -> e.index == index)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Index no válido: " + index));
    }
}
