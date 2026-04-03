package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorDetail;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoDebtorDetail;
import jakarta.inject.Singleton;

@Singleton
public class PojoDebtorDetailMapper implements IToOuter<PojoIntDebtorDetail, PojoDebtorDetail> {
    
    @Override
    public PojoDebtorDetail toOuter(PojoIntDebtorDetail inner) {
        if (inner == null) {
            return null;
        }
        final var out = new PojoDebtorDetail();
        out.setDebt(inner.getDebt());
        out.setIdDebtor(inner.getIdDebtor());
        out.setName(inner.getName());
        out.setPayments(inner.getPayments());
        out.setProduct(inner.getProduct());
        out.setQuantitySale(inner.getQuantitySale());
        out.setTimestamp(inner.getTimestamp());
        out.setTotalOnSale(inner.getTotalOnSale());
        return out;
    }
    
}
