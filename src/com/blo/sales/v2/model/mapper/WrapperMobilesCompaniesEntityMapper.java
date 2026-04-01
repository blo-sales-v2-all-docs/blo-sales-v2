package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMobilesCompanies;
import com.blo.sales.v2.model.entities.WrapperMobilesCompaniesEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperMobilesCompaniesEntityMapper implements IToOuter<WrapperMobilesCompaniesEntity, WrapperPojoIntMobilesCompanies> {
    
    @Inject
    private MobileCompanyEntityMapper mapper;
    
    @Override
    public WrapperPojoIntMobilesCompanies toOuter(WrapperMobilesCompaniesEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoIntMobilesCompanies();
        final var lst = new ArrayList<PojoIntMobileCompany>();
        if (inner.getCompanies() != null && !inner.getCompanies().isEmpty()) {
            inner.getCompanies().forEach(c -> lst.add(mapper.toOuter(c)));
        }
        outer.setCompanies(lst);
        return outer;
    }
    
}
