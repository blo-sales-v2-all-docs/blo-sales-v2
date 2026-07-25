package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.view.pojos.PojoCreditDebit;
import com.blo.sales.v2.view.pojos.WrapperPojoCredits;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PojoCreditDebitMapper {
    
    public static final PojoCreditDebitMapper INSTANCE = Mappers.getMapper(PojoCreditDebitMapper.class);
    
    PojoIntCredit toInner(PojoCreditDebit credit);
    
    WrapperPojoCredits wrapperCreditsToOuter(WrapperPojoIntCredits outer);
}
