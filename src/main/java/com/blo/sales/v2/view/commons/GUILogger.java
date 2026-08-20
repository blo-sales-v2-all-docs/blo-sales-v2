package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.utils.BloSalesV2Utils;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public final class GUILogger {
    
    private static final Map<String, GUILogger> instances = new HashMap<>();
    
    private final String className;
    
    private static final String LOG_FILE_PATH = "app_logs.log";
    
    static {
        try {
            // El segundo parámetro 'true' es para que haga append (añada texto al final)
            FileHandler fileHandler = new FileHandler(LOG_FILE_PATH, true);
            fileHandler.setFormatter(new SimpleFormatter()); // Formato básico de java.util.logging
            
            // Configuramos el Logger raíz para que capture todo lo que envíen las instancias
            Logger rootLogger = Logger.getLogger("");
            rootLogger.addHandler(fileHandler);
        } catch (IOException | SecurityException e) {
            System.err.println("No se pudo inicializar el archivo de logs: " + e.getMessage());
        }
    }
    
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
    
    public void info(Object[] array) {
        Logger.getLogger(className).log(Level.INFO, String.format("%s [%s] INFO - %s \n", BloSalesV2Utils.getTimestamp(), className, "INICIO log de arreglo"));
        for (Object item : array) {
            Logger.getLogger(className).log(Level.INFO, String.format("%s [%s] INFO - %s \n", BloSalesV2Utils.getTimestamp(), className, item));
        }
        Logger.getLogger(className).log(Level.INFO, String.format("%s [%s] INFO - %s \n", BloSalesV2Utils.getTimestamp(), className, "FIN log de arreglo"));
    }
    
}
