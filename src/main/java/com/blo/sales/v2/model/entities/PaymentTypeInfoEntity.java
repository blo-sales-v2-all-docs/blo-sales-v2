package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.PaymentTypeEntityEnum;
import java.math.BigDecimal;

public class PaymentTypeInfoEntity {
    
    private long id_sale;
    
    /** monto del pago con tarjeta*/
    private BigDecimal card_pay;
    
    /** referencia / autorizacion */
    private String reference;
    
    private BigDecimal cash;
    
    private PaymentTypeEntityEnum payment_type;

    public long getId_sale() {
        return id_sale;
    }

    public void setId_sale(long id_sale) {
        this.id_sale = id_sale;
    }

    public BigDecimal getCard_pay() {
        return card_pay;
    }

    public void setCard_pay(BigDecimal card_pay) {
        this.card_pay = card_pay;
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

    public PaymentTypeEntityEnum getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(PaymentTypeEntityEnum payment_type) {
        this.payment_type = payment_type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentTypeInfoEntity{");
        sb.append("id_sale=").append(id_sale);
        sb.append(", card_pay=").append(card_pay);
        sb.append(", reference=").append(reference);
        sb.append(", cash=").append(cash);
        sb.append(", payment_type=").append(payment_type);
        sb.append('}');
        return sb.toString();
    }
}
