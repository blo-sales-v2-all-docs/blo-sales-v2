package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntProduct;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntProducts;
import com.blo.sales.v2.model.entities.WrapperProductsEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperProductsEntityMapper implements IToOuter<WrapperProductsEntity, WrapperPojoIntProducts> {
    
    @Inject
    private ProductEntityMapper mapper;

    @Override
    public WrapperPojoIntProducts toOuter(WrapperProductsEntity inner) {
        if (inner == null) {
            return null;
        }
        final var out = new WrapperPojoIntProducts();
        final var products = new ArrayList<PojoIntProduct>();
        if (inner.getProducts() != null && !inner.getProducts().isEmpty()) {
            inner.getProducts().forEach(p -> products.add(mapper.toOuter(p)));
        }
        out.setProducts(products);
        return out;
    }

}
