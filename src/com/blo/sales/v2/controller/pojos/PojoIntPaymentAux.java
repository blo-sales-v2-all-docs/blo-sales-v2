package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import com.blo.sales.v2.view.pojos.enums.PaymentTypeEnum;
import java.math.BigDecimal;

public class PojoIntPaymentAux {
    
    /** monto del pago con tarjeta*/
    private BigDecimal cardPay;
    
    /** referencia / autorizacion */
    private String reference;
    
    private BigDecimal cash;
    
    private PaymentTypeIntEnum type;

    public BigDecimal getCardPay() {
        return cardPay;
    }

    public void setCardPay(BigDecimal cardPay) {
        this.cardPay = cardPay;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public PaymentTypeIntEnum getType() {
        return type;
    }

    public void setType(PaymentTypeIntEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntPaymentAux{");
        sb.append("cardPay=").append(cardPay);
        sb.append(", reference=").append(reference);
        sb.append(", cash=").append(cash);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
