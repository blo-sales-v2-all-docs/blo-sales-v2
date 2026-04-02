package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntProducts;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoProduct;
import com.blo.sales.v2.view.pojos.WrapperPojoProducts;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoProductsMapper implements IToOuter<WrapperPojoIntProducts, WrapperPojoProducts> {
    
    @Inject
    private ProductMapper mapper;

    @Override
    public WrapperPojoProducts toOuter(WrapperPojoIntProducts inner) {
        if (inner == null) {
            return null;
        }
        final var out = new WrapperPojoProducts();
        final var products = new ArrayList<PojoProduct>();
        if (inner.getProducts() != null && !inner.getProducts().isEmpty()) {
            inner.getProducts().forEach(p -> products.add(mapper.toOuter(p)));
        }
        out.setProducts(products);
        return out;
    }
    
}
