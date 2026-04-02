package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import java.math.BigDecimal;

public class PojoIntPaymentTypeInfo {
    
    private long idSale;
    
    /** monto del pago con tarjeta*/
    private BigDecimal cardPay;
    
    /** referencia / autorizacion */
    private String reference;
    
    private BigDecimal cash;
    
    private BigDecimal totalToPay;
    
    private PaymentTypeIntEnum paymentType;

    public long getIdSale() {
        return idSale;
    }

    public void setIdSale(long idSale) {
        this.idSale = idSale;
    }

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

    public BigDecimal getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(BigDecimal totalToPay) {
        this.totalToPay = totalToPay;
    }

    public PaymentTypeIntEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeIntEnum paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntPaymentTypeInfo{");
        sb.append("idSale=").append(idSale);
        sb.append(", cardPay=").append(cardPay);
        sb.append(", reference=").append(reference);
        sb.append(", cash=").append(cash);
        sb.append(", totalToPay=").append(totalToPay);
        sb.append(", paymentType=").append(paymentType);
        sb.append('}');
        return sb.toString();
    }
}
