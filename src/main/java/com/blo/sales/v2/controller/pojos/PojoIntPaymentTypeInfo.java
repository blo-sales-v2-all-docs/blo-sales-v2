package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntPaymentTypeInfo {
    
    private long idSale;
    
    /** monto del pago con tarjeta*/
    private BigDecimal cardPay;
    
    /** referencia / autorizacion */
    private String reference;
    
    private BigDecimal cash;
    
    private BigDecimal totalToPay;
    
    private PaymentTypeIntEnum paymentType;

}
