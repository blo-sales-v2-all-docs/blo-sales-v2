package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorInfoDetail;
import com.blo.sales.v2.view.pojos.PojoDebtorInfoDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PojoDebtorInfoDetailMapper {

    public static final PojoDebtorInfoDetailMapper INSTANCE = Mappers.getMapper(PojoDebtorInfoDetailMapper.class);
    
    PojoDebtorInfoDetail toOuter(PojoIntDebtorInfoDetail outer);
}
