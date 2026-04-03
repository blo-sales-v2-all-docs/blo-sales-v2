package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntMobilesCompanies;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoMobileCompany;
import com.blo.sales.v2.view.pojos.WrapperPojoMobilesCompanies;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoMobilesCompaniesMapper implements IToOuter<WrapperPojoIntMobilesCompanies, WrapperPojoMobilesCompanies> {
    
    @Inject
    private PojoMobileCompanyMapper mapper;

    @Override
    public WrapperPojoMobilesCompanies toOuter(WrapperPojoIntMobilesCompanies inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoMobilesCompanies();
        final var lst = new ArrayList<PojoMobileCompany>();
        if (inner.getCompanies() != null && !inner.getCompanies().isEmpty()) {
            inner.getCompanies().forEach(c -> lst.add(mapper.toOuter(c)));
        }
        outer.setCompanies(lst);
        return outer;
    }
    
}
