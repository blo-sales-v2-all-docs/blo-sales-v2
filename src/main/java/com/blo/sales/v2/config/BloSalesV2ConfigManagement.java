package com.blo.sales.v2.config;

import com.blo.sales.v2.view.commons.GUILogger;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BloSalesV2ConfigManagement {

    private static final GUILogger logger = GUILogger.getLogger(BloSalesV2ConfigManagement.class.getName());
    private static final Properties properties = new Properties();
    private static final String FILE_NAME = "properties.properties";

    /**
     * propiedades que serán reemplazadas por valores del POM
     */
    private static final Map<String, String> propsProtected = new HashMap<>();

    private BloSalesV2ConfigManagement() {
    }

    /**
     * Se encarga de hacer la busqueda y carga de todas las propiedades
     */
    static {
        logger.info("INICIA carga de configuracion %s");
        propsProtected.put("app.version", "${project.version}");

        // 1. Intentar obtener la ruta del directorio real donde está el ejecutable .jar
        Path targetPath = null;
        try {
            final var locationUri = BloSalesV2ConfigManagement.class.getProtectionDomain().getCodeSource().getLocation().toURI();
            targetPath = Paths.get(locationUri).getParent();
        } catch (Exception ex) {
            logger.error("[WARN] No se pudo determinar la ubicación física del ejecutable: %s", ex.getMessage());
        }

        // 2. Resolver la ruta final del archivo externo (Si falla el JAR, cae en user.dir como respaldo para NetBeans)
        final Path finalPath = (targetPath != null)
                ? targetPath.resolve(FILE_NAME)
                : Paths.get(System.getProperty("user.dir")).resolve(FILE_NAME);

        logger.info("Cargando servicios desde: %s", finalPath.toAbsolutePath().toString());

        // 3. Intentar cargar obligatoriamente el archivo externo desde el disco duro
        if (Files.exists(finalPath)) {
            try (InputStream is = new FileInputStream(finalPath.toFile())) {
                properties.load(is);
                logger.info("---> ¡Configuración externa cargada! Propiedades: %s", properties.size());
                properties.forEach((key, value) -> logger.info("[Propiedad] %s: %s", key, value));
                // 4. Ajustar y proteger las propiedades del POM (como la versión de BloSales v2)
                final var configLoaded = loadDefaultConfigs();
                propsProtected.forEach((key, val) -> {
                    final var propFromConfig = configLoaded.getProperty(key);
                    if (propFromConfig != null && !propFromConfig.contains(val)) {
                        properties.setProperty(key, propFromConfig);
                        logger.info("[OK] Propiedad protegida '%s' sincronizada con el POM -> %s", key, propFromConfig);
                    }
                });
            } catch (IOException e) {
                logger.error("[ERROR] Error al leer archivo en ruta externa: %s", e.getMessage());
            }
        } else {
            logger.info("Archivo externo no encontrado.");
        }

    }

    public static String getProperty(String key) {
        final var prop = properties.getProperty(key);
        // Validación: Evita NullPointerException si la clave buscada no existe en el mapa
        if (prop == null || prop.trim().isBlank()) {
            return "";
        }
        return prop.trim();
    }

    private static Properties loadDefaultConfigs() {
        final var props = new Properties();
        // Corregido para buscar desde su propia clase de gestión (o puedes dejar BloSalesV2Utils si lo prefieres)
        try (InputStream is = BloSalesV2ConfigManagement.class.getClassLoader().getResourceAsStream(FILE_NAME)) {
            if (is == null) {
                throw new RuntimeException("No se pudo encontrar " + FILE_NAME + " dentro del JAR.");
            }
            props.load(is);
        } catch (Exception e) {
            logger.error("[CRÍTICO] Falló el respaldo interno: %s", e.getMessage());
        }
        return props;
    }
}
