package com.blo.sales.v2.view.utils;

import com.blo.sales.v2.view.pojos.PojoProduct;
import com.blo.sales.v2.view.utils.business.SaleBusiness;
import com.blo.sales.v2.view.utils.handler.ManagementProductStoreHandler;
import java.math.BigDecimal;
import java.util.HashMap;

public class GUIStore {
    
    private static PojoProduct product = new PojoProduct();
    
    private static SaleBusiness saleBusiness = new SaleBusiness();
    
    private static GUIStore instance;
    
    private GUIStore() { }
    
    public static GUIStore getInstance() {
        if (instance == null) {
            instance = new GUIStore();
        }
        return instance;
    }
    
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
}
