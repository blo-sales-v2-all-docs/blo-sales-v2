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
    DB_DRIVER("db.driver");
    
    @Getter
    private final String key;
    
    private PropsKeysEnum(String key) {
        this.key = key;
    }
    
    
    
}
