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
    
    public void downloadLogs() {
        final var origen = new File(LOG_FILE_PATH);
        
        if (!origen.exists() || origen.length() == 0) {
            JOptionPane.showMessageDialog(null, 
                    "No hay logs registrados en esta sesión todavía.", 
                    "Información", 
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // 2. Configurar el JFileChooser
        final var fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo de Logs");
        // Sugerir un nombre de archivo por defecto al usuario
        fileChooser.setSelectedFile(new File("logs_sistema.log"));

        final var seleccion = fileChooser.showSaveDialog(null);

        // 3. Si el usuario presiona "Guardar"
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File destino = fileChooser.getSelectedFile();

            try {
                // Copiar el archivo reemplazándolo si ya existe un archivo con ese nombre
                Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                
                JOptionPane.showMessageDialog(null, 
                        "Archivo de logs guardado exitosamente en:\n" + destino.getAbsolutePath(), 
                        "Éxito", 
                        JOptionPane.INFORMATION_MESSAGE);
                        
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, 
                        "Error al exportar los logs: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}
