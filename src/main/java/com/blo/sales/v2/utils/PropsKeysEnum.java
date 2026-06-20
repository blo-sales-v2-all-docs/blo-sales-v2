package com.blo.sales.v2.utils;

import lombok.Getter;

/**
 * llaves del archivo properties.properties
 * @author BLO
 */
public enum PropsKeysEnum {
    
    APP_VERSION("app.version"),
    DB_URL("db.url"),
    DB_USERNAME("db.username"),
    DB_PASSWORD("db.password"),
    DB_DRIVER("db.driver"),
    APP_PRODUCTS_ID_PAYMENTS_PRODUCT("app.products.id-payment-product"),
    APP_PRODUCTS_TOP_UP_COMISSION("app.products.top-up-comission"),
    APP_PRODUCTS_TOP_UP_PRODUCT("app.products.top-up-product");
    
    @Getter
    private final String key;
    
    private PropsKeysEnum(String key) {
        this.key = key;
    }
    
    
    
}
