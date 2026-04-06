package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntSaleDeletedDetail;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoSaleDeletedDetail;
import jakarta.inject.Singleton;

@Singleton
public class PojoSaleDeletedDetailMapper implements IToOuter<PojoIntSaleDeletedDetail, PojoSaleDeletedDetail> {

    @Override
    public PojoSaleDeletedDetail toOuter(PojoIntSaleDeletedDetail inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoSaleDeletedDetail();
        outer.setFkSaleProduct(inner.getFkSaleProduct());
        outer.setFkUser(inner.getFkUser());
        outer.setIdSaleDeleted(inner.getIdSaleDeleted());
        outer.setProduct(inner.getProduct());
        outer.setReason(inner.getReason());
        outer.setTimestamp(inner.getTimestamp());
        outer.setUsername(inner.getUsername());
        return outer;
    }
    
}
