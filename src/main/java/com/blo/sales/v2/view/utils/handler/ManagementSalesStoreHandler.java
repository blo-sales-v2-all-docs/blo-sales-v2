package com.blo.sales.v2.view.utils.handler;

import com.blo.sales.v2.view.utils.business.SaleBusiness;
import java.math.BigDecimal;

public class ManagementSalesStoreHandler {
    
    private static final SaleBusiness saleBusiness = new SaleBusiness();
    
    private ManagementSalesStoreHandler() { }
    
    public static void addSaleInfoAndUpdateTotal(Object[] infoSale, BigDecimal total, int key) {
        saleBusiness.getProductsOnSaleInfo().put(key, infoSale);
        saleBusiness.setTotalOnSale(total);
    }
    
    public static void removeSaleInfoByIndexAndUpdateTotal(BigDecimal total, int key) {
        final var originalSize = saleBusiness.getProductsOnSaleInfo().size();
        for (var i = key; i < originalSize - 1; i++) {
            saleBusiness.getProductsOnSaleInfo().put(i, saleBusiness.getProductsOnSaleInfo().get(i + 1));
        }
        saleBusiness.getProductsOnSaleInfo().remove(originalSize - 1);
        saleBusiness.setTotalOnSale(total);
    }
    
    public static void updateQuantityOnSaleByIndex(BigDecimal total, BigDecimal totalOnSale, BigDecimal quantityOnSale, int key) {
        final var item = saleBusiness.getProductsOnSaleInfo().get(key);
        item[2] = quantityOnSale;
        item[4] = totalOnSale;
        saleBusiness.getProductsOnSaleInfo().put(key, item);
        saleBusiness.setTotalOnSale(total);
    }
    
    public static SaleBusiness getAllInfoFromStore() {
        return saleBusiness;
    }
    
    public static void clearInfoStore() {
        saleBusiness.setTotalOnSale(BigDecimal.ZERO);
        saleBusiness.getProductsOnSaleInfo().clear();
    }
}
