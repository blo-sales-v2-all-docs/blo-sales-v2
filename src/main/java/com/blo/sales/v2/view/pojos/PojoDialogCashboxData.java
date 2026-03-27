package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoDialogCashboxData {
    
    private BigDecimal totalActives;
    
    private BigDecimal totalPasives;
    
    private BigDecimal totalAmountInCashbox;
    
    private List<PojoActiveCost> items;
}
