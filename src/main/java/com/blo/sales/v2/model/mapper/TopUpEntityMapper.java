package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.model.entities.TopUpEntity;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class TopUpEntityMapper implements IToInner<TopUpEntity, PojoIntTopUp>, IToOuter<TopUpEntity, PojoIntTopUp> {
    
    @Inject
    private MobileCompanyEntityMapper mobileCompanyMapper;
    
    @Inject
    private UserLoggedEntityMapper userMapper;
    
    @Override
    public TopUpEntity toInner(PojoIntTopUp outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new TopUpEntity();
        inner.setAmount(outer.getAmount());
        inner.setFk_mobile_company(mobileCompanyMapper.toInner(outer.getFkMobileCompany()));
        inner.setFk_user(userMapper.toInner(outer.getFkUser()));
        inner.setId_top_up(outer.getIdTopUp());
        inner.setChecked(outer.isChecked());
        inner.setPhone_number(outer.getPhoneNumber());
        inner.setTimestamp(outer.getTimestamp());
        return inner;
        
    }

    @Override
    public PojoIntTopUp toOuter(TopUpEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntTopUp();
        outer.setAmount(inner.getAmount());
        outer.setFkMobileCompany(mobileCompanyMapper.toOuter(inner.getFk_mobile_company()));
        outer.setFkUser(userMapper.toOuter(inner.getFk_user()));
        outer.setIdTopUp(inner.getId_top_up());
        outer.setChecked(inner.isChecked());
        outer.setPhoneNumber(inner.getPhone_number());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
