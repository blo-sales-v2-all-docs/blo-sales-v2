package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCategory;
import com.blo.sales.v2.controller.pojos.WrapperIntPojoCategories;
import com.blo.sales.v2.model.entities.WrapperCategoriesEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperCategoriesEntityMapper implements IToOuter<WrapperCategoriesEntity, WrapperIntPojoCategories> {
    
    @Inject
    private CategoryEntityMapper categoryEntityMapper;
    
    @Override
    public WrapperIntPojoCategories toOuter(WrapperCategoriesEntity inner) {
        if (inner == null) {
            return null;
        }
        final var out = new WrapperIntPojoCategories();
        final var lst = new ArrayList<PojoIntCategory>();
        if (inner.getCategories() != null && !inner.getCategories().isEmpty()) {
            inner.getCategories().forEach(c ->{
                lst.add(categoryEntityMapper.toOuter(c));
            });
        }
        out.setCategories(lst);
        return out;
    }
    
}
