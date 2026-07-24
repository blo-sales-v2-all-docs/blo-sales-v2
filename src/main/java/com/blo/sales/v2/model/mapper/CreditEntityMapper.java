package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.model.entities.CreditEntity;
import com.blo.sales.v2.model.entities.WrapperCreditsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditEntityMapper {
    
    public static final CreditEntityMapper INSTANCE = Mappers.getMapper(CreditEntityMapper.class);
    
    @Mapping(source = "id_credit", target = "idCredit")
    @Mapping(source = "fk_user", target = "fkUser")
    @Mapping(source = "lender_name", target = "lenderName")
    @Mapping(source = "update_date", target = "updateDate")
    PojoIntCredit toOuter(CreditEntity inner);
    
    @Mapping(source = "idCredit", target = "id_credit")
    @Mapping(source = "fkUser", target = "fk_user")
    @Mapping(source = "lenderName", target = "lender_name")
    @Mapping(source = "updateDate", target = "update_date")
    CreditEntity toInner(PojoIntCredit outer);
    
     WrapperPojoIntCredits wrapperCreditsToOuter(WrapperCreditsEntity credits);
}
