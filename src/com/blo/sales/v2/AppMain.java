package com.blo.sales.v2;

import com.blo.sales.v2.view.LoginFrm;
import com.blo.sales.v2.config.BloSalesV2SingletonConfig;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class AppMain {
    
    public static void main(String[] args) {
        try {
        Injector injector = Guice.createInjector(new BloSalesV2SingletonConfig());
        java.awt.EventQueue.invokeLater(() -> {
            LoginFrm login = injector.getInstance(LoginFrm.class);
            login.setVisible(true);
        });
    } catch (Exception e) {
        // ESTO TE DIRÁ EXACTAMENTE QUÉ PIEZA FALTA
        System.err.println("--- ERROR DE CONFIGURACIÓN DE GUICE ---");
        System.err.println(e.getMessage()); 
        System.exit(1);
    }
    }
    
}
