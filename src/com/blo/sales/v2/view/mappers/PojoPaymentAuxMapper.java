package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntPaymentAux;
import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.view.pojos.PojoPaymentAux;

public class PojoPaymentAuxMapper implements IToInner<PojoIntPaymentAux, PojoPaymentAux> {

    private static PojoPaymentAuxMapper instance;
    
    private PojoPaymentAuxMapper() { }
    
    public static PojoPaymentAuxMapper getInstance() {
        if (instance == null) {
            instance = new PojoPaymentAuxMapper();
        }
        return instance;
    }
    
    @Override
    public PojoIntPaymentAux toInner(PojoPaymentAux outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntPaymentAux();
        inner.setCardPay(outer.getCardPay());
        inner.setCash(outer.getCash());
        inner.setReference(outer.getReference());
        inner.setType(PaymentTypeIntEnum.valueOf((outer.getType().name())));
        return inner;
    }
    
}
