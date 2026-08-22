package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntDebtorInfoDetail {
    
    private long idDebtor;
    
    private BigDecimal debt;
    
    private String payments;
    
    private String name;
    
    private long idSale;
    
    private BigDecimal total;
    
    private BigDecimal totalCash;
    
    private BigDecimal totalCard;
    
    /** 
     * en esta lista la propiedad quantity tiene quantity_on_sale
     * la propiedad costOfSale tiene product_total_on_sale  
     */
    private List<PojoIntProduct> products;
    
}
