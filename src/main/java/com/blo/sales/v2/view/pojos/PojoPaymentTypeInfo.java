package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.PaymentTypeEnum;
import java.math.BigDecimal;

/**
 * clase utilizada como wrapper para los detalles de una venta.
 * 
 * Vive todo en la clase sale / se agrego para no mover flujos completos
 */
public class PojoPaymentTypeInfo {
    
    private long idSale;
    
    /** cantidad a pagar con tarjeta */
    private BigDecimal cardPay;
    
    /** cantidad pagada con efectivo */
    private BigDecimal cash;
    
    /** string de autorizacion */
    private String reference;
    
    private PaymentTypeEnum paymentType;
    
    private BigDecimal totalToPay;

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

    public BigDecimal getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(BigDecimal totalToPay) {
        this.totalToPay = totalToPay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoPaymentTypeInfo{");
        sb.append("idSale=").append(idSale);
        sb.append(", cardPay=").append(cardPay);
        sb.append(", cash=").append(cash);
        sb.append(", reference=").append(reference);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", totalToPay=").append(totalToPay);
        sb.append('}');
        return sb.toString();
    }
}
