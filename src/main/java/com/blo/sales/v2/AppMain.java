package com.blo.sales.v2;

import com.blo.sales.v2.view.LoginFrm;
import com.blo.sales.v2.config.BloSalesV2SingletonConfig;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class AppMain {
    
    private static final String BANNER_PATH = "/banner.txt";

    public static void main(String[] args) {
        printStartupBanner();

        // --- 2. CONFIGURAR E INICIAR GUICE (Lógica existente) ---
        try {
            // Creamos el inyector con nuestra configuración
            Injector injector = Guice.createInjector(new BloSalesV2SingletonConfig());
            
            // Opcional: Un log informando que el inyector está listo
            System.out.println("INFO: Root WebApplicationContext: initialization completed in 120ms");
            
            // Arrancamos la UI en el EventQueue de AWT
            java.awt.EventQueue.invokeLater(() -> {
                System.out.println("INFO: AWT EventQueue-0 initialized. Loading user interface...");
                // Obtenemos la instancia de LoginFrm DESDE el inyector
                LoginFrm login = injector.getInstance(LoginFrm.class);
                login.setVisible(true);
            });
            
        } catch (Exception e) {
            // Un catch generic para depurar errores de configuración
            System.err.println("--- ERROR DE CONFIGURACIÓN DE GUICE ---");
            e.printStackTrace(); 
            System.exit(1);
        }
    }
    
    /**
     * Carga y muestra el banner ASCII desde resources.
     */
    private static void printStartupBanner() {
        // Obtenemos el archivo como un Stream usando el ClassLoader
        try (InputStream inputStream = AppMain.class.getResourceAsStream(BANNER_PATH)) {
            
            if (inputStream == null) {
                // Si el archivo no existe, no fallamos, solo mostramos info genérica
                System.out.println("--- Starting BloSales V2 application... (Banner not found) ---");
                return;
            }

            // Leemos y recolectamos el contenido
            String banner = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));

            // Imprimimos el banner en la consola
            System.out.println(banner);
            
            // Opcional: Una línea de espacio extra
            System.out.println("\n");
            
        } catch (IOException e) {
            // Manejo silencioso de error al leer el banner (no crítico)
            System.err.println("Could not load startup banner.");
        }
    }
}
