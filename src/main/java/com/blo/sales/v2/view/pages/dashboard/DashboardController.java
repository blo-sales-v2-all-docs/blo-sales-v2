package com.blo.sales.v2.view.pages.dashboard;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class DashboardController {
	
	@FXML
    private StackPane contentArea;

    //private static final Logger logger = Logger.getLogger(DashboardController.class.getName());

    /**
     * Método genérico para cargar cualquier FXML dentro del área central del wrapper.
     */
    public void cargarVista(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent vista = loader.load();
            // Reemplaza el contenido actual del StackPane con la nueva vista
            contentArea.getChildren().setAll(vista);
        } catch (IOException e) {
        	System.err.println(e.getMessage());
            //logger.log(Level.SEVERE, "No se pudo cargar la vista: " + fxmlPath, e);
        }
    }

    @FXML
    private void cargarVistaVentas() {
        cargarVista("/com/blo/sales/v2/view/pages/sales/sales-view.fxml");
    }

    @FXML
    private void cargarVistaProductos() {
        cargarVista("/com/blo/sales/v2/view/pages/product/product-view.fxml");
    }

    @FXML
    private void cerrarSesion() {
        // Lógica para regresar al login o cerrar la aplicación
    }

}
