package com.blo.sales.v2.view.utils.business;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import lombok.Setter;
import lombok.ToString;


public @ToString class SaleBusiness {
    
    private Map<Integer, Object[]> productsOnSaleInfo;
    
    @Setter
    private BigDecimal totalOnSale;
    
    public Map<Integer, Object[]> getProductsOnSaleInfo() {
        if (productsOnSaleInfo == null) {
            productsOnSaleInfo = new HashMap<>();
        }
        return productsOnSaleInfo;
    }
    
    public BigDecimal getTotalOnSale() {
        if (totalOnSale == null) {
            totalOnSale = new BigDecimal(BigInteger.ZERO);
        }
        return totalOnSale;
    }
}
