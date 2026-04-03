package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.PaymentTypeEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * clase utilizada como wrapper para los detalles de una venta.
 * 
 * Vive todo en la clase sale / se agrego para no mover flujos completos
 */
@Setter
@Getter
public @ToString class PojoPaymentTypeInfo {
    
    private long idSale;
    
    /** cantidad a pagar con tarjeta */
    private BigDecimal cardPay;
    
    /** cantidad pagada con efectivo */
    private BigDecimal cash;
    
    /** string de autorizacion */
    private String reference;
    
    private PaymentTypeEnum paymentType;
    
    private BigDecimal totalToPay;
}
