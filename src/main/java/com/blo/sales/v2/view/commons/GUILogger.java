package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.utils.BloSalesV2Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class GUILogger {
    
    private static final Map<String, GUILogger> instances = new HashMap<>();
    
    private final String className;
    
    private GUILogger(String className) {
        this.className = className;
    }
    
    public static GUILogger getLogger(String classFrom) {
        if (!instances.containsKey(classFrom)) {
            instances.put(classFrom, new GUILogger(classFrom));
        }
        return instances.get(classFrom);
    }
    
    public void error(String str) {
        final var _str = String.format("%s [%s] ERROR - %s \n", BloSalesV2Utils.getTimestamp(), className, str);
        Logger.getLogger(className).log(Level.SEVERE, _str);
    }
    
    public void error(String str, Object... args) {
        final var _str = String.format("%s [%s] ERROR - %s \n", BloSalesV2Utils.getTimestamp(), className, String.format(str, args));
        Logger.getLogger(className).log(Level.SEVERE, _str);
    }
    
    public void info(String str, Object... args) {
        final var _str = String.format("%s [%s] INFO - %s \n", BloSalesV2Utils.getTimestamp(), className, String.format(str, args));
        Logger.getLogger(className).log(Level.INFO, _str);
    }
    
    public void info(String str) {
        final var _str = String.format("%s [%s] INFO - %s \n", BloSalesV2Utils.getTimestamp(), className, str);
        Logger.getLogger(className).log(Level.INFO, _str);
    }
    
    public void warn(String str) {
        final var _str = String.format("%s [%s] WARNING - %s \n", BloSalesV2Utils.getTimestamp(), className, str);
        Logger.getLogger(className).log(Level.INFO, _str);
    }
}
