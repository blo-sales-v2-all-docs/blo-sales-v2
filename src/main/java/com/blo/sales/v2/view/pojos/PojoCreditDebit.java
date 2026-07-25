package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.TypeCreditDebitEnum;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoCreditDebit {
    
    private long idCreditDebit;
    
    private long fkUser;
    
    private String lenderDebtorName;
    
    private BigDecimal amount;
    
    private BigDecimal originalAmount;
    
    private boolean payed;
    
    private String payments;
    
    private String timestamp;
    
    private boolean available;
    
    private String updateDate;
    
    private TypeCreditDebitEnum type;
    
}
