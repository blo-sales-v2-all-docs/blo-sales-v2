package com.blo.sales.v2.view.pojos.enums;

import java.util.Arrays;

public enum PaymentTypeEnum {
    
    CASH("Efectivo", 0), TRANSFER("Pago con tarjeta", 1), BOTH("Ambos", 2);
    
    private final String paymentTypeTarget;
    
    private final int index;
    
    private PaymentTypeEnum(String paymentTypeTarget, int index) {
        this.paymentTypeTarget = paymentTypeTarget;
        this.index = index;
    }

    public String getPaymentTypeTarget() {
        return paymentTypeTarget;
    }

    public int getIndex() {
        return index;
    }
    
    public static PaymentTypeEnum getByIndex(int index) {
        return Arrays.stream(PaymentTypeEnum.values())
            .filter(e -> e.index == index)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Index no válido: " + index));
    }
}
