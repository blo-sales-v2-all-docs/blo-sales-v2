package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntMobilesCompanies;
import com.blo.sales.v2.model.entities.WrapperMobilesCompaniesEntity;
import com.blo.sales.v2.utils.IToOuter;
import java.util.ArrayList;

public class WrapperMobilesCompaniesEntityMapper implements IToOuter<WrapperMobilesCompaniesEntity, WrapperPojoIntMobilesCompanies> {
    
    private static final MobileCompanyEntityMapper mapper = MobileCompanyEntityMapper.getInstance();
    
    private static WrapperMobilesCompaniesEntityMapper instance;
    
    private WrapperMobilesCompaniesEntityMapper() { }
    
    public static WrapperMobilesCompaniesEntityMapper getInstance() {
        if (instance == null) {
            instance = new WrapperMobilesCompaniesEntityMapper();
        }
        return instance;
    }

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
