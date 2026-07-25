package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.view.pojos.PojoCredit;
import com.blo.sales.v2.view.pojos.WrapperPojoCredits;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PojoCreditMapper {
    
    public static final PojoCreditMapper INSTANCE = Mappers.getMapper(PojoCreditMapper.class);
    
    PojoIntCredit toInner(PojoCredit credit);
    
    WrapperPojoCredits wrapperCreditsToOuter(WrapperPojoIntCredits outer);
}
