package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.PaymentTypeEnum;
import java.math.BigDecimal;

public class PojoPaymentTypeAux {
    
    /** cantidad a pagar con tarjeta */
    private BigDecimal cardpay;
    
    /** cantidad pagada con efectivo */
    private BigDecimal cash;
    
    /** string de autorizacion */
    private String reference;
    
    private PaymentTypeEnum paymentType;

    public BigDecimal getCardpay() {
        return cardpay;
    }

    public void setCardpay(BigDecimal cardpay) {
        this.cardpay = cardpay;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoPaymentTypeAux{");
        sb.append("cardpay=").append(cardpay);
        sb.append(", cash=").append(cash);
        sb.append(", reference=").append(reference);
        sb.append(", paymentType=").append(paymentType);
        sb.append('}');
        return sb.toString();
    }
    
}
