package com.blo.sales.v2.view.utils;

import com.blo.sales.v2.view.pojos.PojoProduct;
import com.blo.sales.v2.view.utils.business.SaleBusiness;
import com.blo.sales.v2.view.utils.handler.ManagementProductStoreHandler;
import com.blo.sales.v2.view.utils.handler.ManagementSalesStoreHandler;
import java.math.BigDecimal;

public class GUIStore {
    
    private static PojoProduct product = new PojoProduct();
    
    private GUIStore() { }
    
    // product datos
    public static void addPropOnPojoProduct(ManagementProductStoreHandler prop, String value) {
        prop.apply(product, value);
    }
    
    public static void resetProductData() {
        product = null;
        product = new PojoProduct();
    }
    
    public static PojoProduct getProductData() {
        return product;
    }
    
    public static void addSaleInfoAndUpdateTotal(Object[] infoSale, BigDecimal total, int key) {
        ManagementSalesStoreHandler.addSaleInfoAndUpdateTotal(infoSale, total, key);
    }
    
    public static void removeSaleInfoByIndexAndUpdateTotal(BigDecimal total, int key) {
        ManagementSalesStoreHandler.removeSaleInfoByIndexAndUpdateTotal(total, key);
    }
    
    public static void updateQuantityOnSaleByIndex(BigDecimal total, BigDecimal totalOnSale, BigDecimal quantityOnSale, int key) {
        ManagementSalesStoreHandler.updateQuantityOnSaleByIndex(total, totalOnSale, quantityOnSale, key);
    }
    
    public static SaleBusiness getAllInfoFromStore() {
        return ManagementSalesStoreHandler.getAllInfoFromStore();
    }
    
    public static void clearInfoStore() {
        ManagementSalesStoreHandler.clearInfoStore();
    }
}
