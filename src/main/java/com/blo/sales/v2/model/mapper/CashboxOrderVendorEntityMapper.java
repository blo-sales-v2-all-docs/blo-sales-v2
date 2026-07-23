package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxOrderVendor;
import com.blo.sales.v2.model.entities.CashboxOrderVendorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CashboxOrderVendorEntityMapper {
    
    CashboxOrderVendorEntityMapper INSTANCE = Mappers.getMapper(CashboxOrderVendorEntityMapper.class);
    
    CashboxOrderVendorEntity toInner(PojoIntCashboxOrderVendor outer);
    
    PojoIntCashboxOrderVendor toOuter(CashboxOrderVendorEntity inner);
}
