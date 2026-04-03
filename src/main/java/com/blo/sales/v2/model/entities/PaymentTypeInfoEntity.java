package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.PaymentTypeEntityEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PaymentTypeInfoEntity {
    
    private long id_sale;
    
    /** monto del pago con tarjeta*/
    private BigDecimal card_pay;
    
    /** referencia / autorizacion */
    private String reference;
    
    private BigDecimal cash;
    
    private PaymentTypeEntityEnum payment_type;
}
