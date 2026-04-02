package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntSaleProductData;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.view.pojos.PojoSaleProductData;
import jakarta.inject.Singleton;

@Singleton
public class PojoSaleProductDataMapper implements IToInner<PojoIntSaleProductData, PojoSaleProductData> {
    
    @Override
    public PojoIntSaleProductData toInner(PojoSaleProductData outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntSaleProductData();
        inner.setIdProduct(outer.getIdProduct());
        inner.setPrice(outer.getPrice());
        inner.setQuantityOnSale(outer.getQuantityOnSale());
        inner.setProductBuyTotal(outer.getProductBuyTotal());
        return inner;
    }
    
}
