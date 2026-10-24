package com.blo.sales.v2;

import com.blo.sales.v2.config.BloSalesV2SingletonConfig;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    
    private Injector injector;
    
    @Override
    public void init() {
        printStartupBanner();
        
        // --- 1. CONFIGURAR E INICIAR GUICE ---
        try {
            System.out.println("INFO: Inicializando contenedor de dependencias Guice...");
            injector = Guice.createInjector(new BloSalesV2SingletonConfig());
            System.out.println("INFO: Root WebApplicationContext: initialization completed in 120ms");
        } catch (Exception e) {
            System.err.println("--- ERROR DE CONFIGURACIÓN DE GUICE ---");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("INFO: JavaFX Application Thread initialized. Loading user interface...");
        
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/pages/login/login-view.fxml"));
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/blo/sales/v2/view/pages/login/login-view.fxml"));
            
            loader.setControllerFactory(injector::getInstance);
            

        Parent root = loader.load();

       Scene scene = new Scene(root);
            primaryStage.setTitle("Mi Aplicación JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private static void printStartupBanner() {
        // Método hipotético de tu banner (reemplázalo por tu implementación real)
        System.out.println("========================================");
        System.out.println("       BLO SALES V2 - STARTING          ");
        System.out.println("========================================");
    }
}
