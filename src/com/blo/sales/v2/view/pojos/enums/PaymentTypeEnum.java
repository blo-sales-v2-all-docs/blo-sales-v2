package com.blo.sales.v2.view.pojos.enums;

public enum PaymentTypeEnum {
    
    CASH("Efectivo", 0), TRANSFER("Pago con tarjeta", 1);
    
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
    
}
