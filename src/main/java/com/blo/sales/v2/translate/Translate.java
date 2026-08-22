package com.blo.sales.v2.translate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Translate {

    private ResourceBundle bundle;

    public Translate(String lang, String country) {
        // Define la ruta del directorio externo donde residen tus archivos de propiedades
        final String externalPath = "config/i18n/"; 
        
        // Construye el nombre del archivo esperado, p. ej., "es.properties" o "es_ES.properties"
        final String fileName = lang + (country != null && !country.isEmpty() ? "_" + country : "") + ".properties";
        File file = new File(externalPath + fileName);

        // Si el archivo específico no existe, se intenta un fallback simple (ej. "es.properties")
        if (!file.exists()) {
            file = new File(externalPath + lang + ".properties");
        }

        try (InputStream input = new FileInputStream(file)) {
            // Carga directamente el ResourceBundle desde el archivo externo
            this.bundle = new PropertyResourceBundle(input);
        } catch (IOException e) {
            System.err.println("No se pudo cargar el archivo externo: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }

    public String get(String key) {
        if (bundle != null && bundle.containsKey(key)) {
            return bundle.getString(key);
        }
        return "¡¡" + key + "!!";
    }
}
