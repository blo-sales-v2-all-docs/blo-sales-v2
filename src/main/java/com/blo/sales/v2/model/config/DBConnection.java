package com.blo.sales.v2.model.config;

import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.utils.PropsKeysEnum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static Connection connection = null;
    
    private static final String RELEASE = "RELEASE";
    
    private static final String URL = BloSalesV2Utils.getProp(PropsKeysEnum.DB_URL.getKey());

    private static final String USER = BloSalesV2Utils.getProp(PropsKeysEnum.DB_USERNAME.getKey());
    
    private static final String PASSWORD = BloSalesV2Utils.getProp(PropsKeysEnum.DB_PASSWORD.getKey());
    
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Registrar el driver (opcional en versiones nuevas, pero seguro)
                Class.forName(BloSalesV2Utils.getProp(PropsKeysEnum.DB_DRIVER.getKey()));
                
                // Establecer la conexión
                connection = DriverManager.getConnection(getUrl(), USER, PASSWORD);
                final var env = getUrl().substring(getUrl().lastIndexOf("-") + 1);
                System.out.println("Conexi\u00f3n establecida con \u00e9xito. [" + env + "]");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
        return connection;
    }
    
    private static String getUrl() {
        var subfijo = "-dev";
        if (BloSalesV2Utils.getVersion().lastIndexOf(RELEASE) == 7) {
            subfijo = "-pre";
        }
        return URL.concat(subfijo);
    }
}
