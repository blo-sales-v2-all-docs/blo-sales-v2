package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperIntPojoCategories;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoCategory;
import com.blo.sales.v2.view.pojos.WrapperPojoCategories;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoCategoriesMapper implements IToOuter<WrapperIntPojoCategories, WrapperPojoCategories> {
    
    @Inject
    private CategoryMapper categoryMapper;
    
    @Override
    public WrapperPojoCategories toOuter(WrapperIntPojoCategories inner) {
        if (inner == null) {
            return null;
        }
        final var out = new WrapperPojoCategories();
        final var lst = new ArrayList<PojoCategory>();
        if (inner.getCategories() != null && !inner.getCategories().isEmpty()) {
            inner.getCategories().forEach(c -> {
                lst.add(categoryMapper.toOuter(c));
            });
        }
        out.setCategories(lst);
        return out;
    }
    
}
