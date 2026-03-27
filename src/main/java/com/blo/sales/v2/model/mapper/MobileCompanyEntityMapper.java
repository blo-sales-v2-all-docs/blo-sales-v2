package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntMobileCompany;
import com.blo.sales.v2.model.entities.MobileCompanyEntity;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;

public class MobileCompanyEntityMapper implements IToInner<MobileCompanyEntity, PojoIntMobileCompany>, IToOuter<MobileCompanyEntity, PojoIntMobileCompany> {
    
    private static MobileCompanyEntityMapper instance;
    
    private MobileCompanyEntityMapper() { }
    
    public static MobileCompanyEntityMapper getInstance() {
        if (instance == null) {
            instance = new MobileCompanyEntityMapper();
        }
        return instance;
    }

    @Override
    public MobileCompanyEntity toInner(PojoIntMobileCompany outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new MobileCompanyEntity();
        inner.setId_mobile_company(outer.getIdMobileCompany());
        inner.setMobile_company(outer.getMobileCompany());
        return inner;
    }

    @Override
    public PojoIntMobileCompany toOuter(MobileCompanyEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntMobileCompany();
        outer.setIdMobileCompany(inner.getId_mobile_company());
        outer.setMobileCompany(inner.getMobile_company());
        return outer;
    }
    
}
