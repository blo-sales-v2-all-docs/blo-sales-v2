package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntPaymentTypeInfo;
import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import com.blo.sales.v2.model.entities.PaymentTypeInfoEntity;
import com.blo.sales.v2.model.entities.enums.PaymentTypeEntityEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class PaymentTypeInfoEntityMapper implements IToInner<PaymentTypeInfoEntity, PojoIntPaymentTypeInfo>, IToOuter<PaymentTypeInfoEntity, PojoIntPaymentTypeInfo> {

    @Override
    public PaymentTypeInfoEntity toInner(PojoIntPaymentTypeInfo outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PaymentTypeInfoEntity();
        inner.setCard_pay(outer.getCardPay());
        inner.setCash(outer.getCash());
        inner.setId_sale(outer.getIdSale());
        inner.setPayment_type(PaymentTypeEntityEnum.valueOf(outer.getPaymentType().name()));
        inner.setReference(outer.getReference());
        return inner;
    }

    @Override
    public PojoIntPaymentTypeInfo toOuter(PaymentTypeInfoEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntPaymentTypeInfo();
        outer.setCardPay(inner.getCard_pay());
        outer.setCash(inner.getCash());
        outer.setIdSale(inner.getId_sale());
        outer.setPaymentType(PaymentTypeIntEnum.valueOf(inner.getPayment_type().name()));
        outer.setReference(inner.getReference());
        return outer;
    }
    
}
