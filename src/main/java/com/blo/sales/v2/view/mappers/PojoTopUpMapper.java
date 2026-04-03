package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoTopUp;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class PojoTopUpMapper implements IToInner<PojoIntTopUp, PojoTopUp>, IToOuter<PojoIntTopUp, PojoTopUp> {
    
    @Inject
    private PojoMobileCompanyMapper mobileCompanyMapper;
    
    @Inject
    private LoggedInUserMapper loggedInUserMapper;
    
    @Override
    public PojoIntTopUp toInner(PojoTopUp outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntTopUp();
        inner.setAmount(outer.getAmount());
        inner.setChecked(outer.isChecked());
        inner.setFkMobileCompany(mobileCompanyMapper.toInner(outer.getFkMobileCompany()));
        inner.setFkUser(loggedInUserMapper.toInner(outer.getFkUser()));
        inner.setIdTopUp(outer.getIdTopUp());
        inner.setPhoneNumber(outer.getPhoneNumber());
        inner.setTimestamp(outer.getTimestamp());
        return inner;
        
    }

    @Override
    public PojoTopUp toOuter(PojoIntTopUp inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoTopUp();
        outer.setAmount(inner.getAmount());
        outer.setChecked(inner.isChecked());
        outer.setFkMobileCompany(mobileCompanyMapper.toOuter(inner.getFkMobileCompany()));
        outer.setFkUser(loggedInUserMapper.toOuter(inner.getFkUser()));
        outer.setIdTopUp(inner.getIdTopUp());
        outer.setPhoneNumber(inner.getPhoneNumber());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
