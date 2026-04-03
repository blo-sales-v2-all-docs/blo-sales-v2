package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntPaymentTypeInfo;
import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoPaymentTypeInfo;
import com.blo.sales.v2.view.pojos.enums.PaymentTypeEnum;
import jakarta.inject.Singleton;

@Singleton
public class PojoPaymentTypeInfoMapper implements IToInner<PojoIntPaymentTypeInfo, PojoPaymentTypeInfo>, IToOuter<PojoIntPaymentTypeInfo, PojoPaymentTypeInfo> {
    
    @Override
    public PojoIntPaymentTypeInfo toInner(PojoPaymentTypeInfo outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntPaymentTypeInfo();
        inner.setIdSale(outer.getIdSale());
        inner.setCardPay(outer.getCardPay());
        inner.setCash(outer.getCash());
        inner.setReference(outer.getReference());
        inner.setPaymentType(PaymentTypeIntEnum.valueOf((outer.getPaymentType().name())));
        inner.setTotalToPay(outer.getTotalToPay());
        return inner;
    }

    @Override
    public PojoPaymentTypeInfo toOuter(PojoIntPaymentTypeInfo inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoPaymentTypeInfo();
        outer.setIdSale(inner.getIdSale());
        outer.setCardPay(inner.getCardPay());
        outer.setCash(inner.getCash());
        outer.setReference(inner.getReference());
        outer.setPaymentType(PaymentTypeEnum.valueOf(inner.getPaymentType().name()));
        outer.setTotalToPay(inner.getTotalToPay());
        return outer;
    }
    
}
