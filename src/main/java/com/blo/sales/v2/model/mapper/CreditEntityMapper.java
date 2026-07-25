package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntCredit;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCredits;
import com.blo.sales.v2.model.entities.CreditDebitEntity;
import com.blo.sales.v2.model.entities.WrapperCreditsDebtsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreditEntityMapper {
    
    public static final CreditEntityMapper INSTANCE = Mappers.getMapper(CreditEntityMapper.class);
    
    @Mapping(source = "id_credit_debit", target = "idCreditDebit")
    @Mapping(source = "fk_user", target = "fkUser")
    @Mapping(source = "lender_debtor_name", target = "lenderDebtorName")
    @Mapping(source = "update_date", target = "updateDate")
    @Mapping(source = "original_amount", target = "originalAmount")
    PojoIntCredit toOuter(CreditDebitEntity inner);
    
    @Mapping(source = "idCreditDebit", target = "id_credit_debit")
    @Mapping(source = "fkUser", target = "fk_user")
    @Mapping(source = "lenderDebtorName", target = "lender_debtor_name")
    @Mapping(source = "updateDate", target = "update_date")
    @Mapping(source = "originalAmount", target = "original_amount")
    CreditDebitEntity toInner(PojoIntCredit outer);
    
     WrapperPojoIntCredits wrapperCreditsToOuter(WrapperCreditsDebtsEntity credits);
}
