package com.blo.sales.v2.view.pages.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblMensaje;

    @FXML
    private void handleLoginButtonAction() {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        // Lógica de validación simulada
        if (usuario.equals("admin") && password.equals("1234")) {
            if (lblMensaje != null) {
                lblMensaje.setStyle("-fx-text-fill: #16a34a; -fx-font-weight: bold;");
                lblMensaje.setText("¡Acceso concedido exitosamente!");
            }
            System.out.println("Login correcto para: " + usuario);

            // Aquí podrías abrir la siguiente ventana (Dashboard)

        } else {
            if (lblMensaje != null) {
                lblMensaje.setStyle("-fx-text-fill: #dc2626; -fx-font-weight: bold;");
                lblMensaje.setText("Usuario o contraseña incorrectos.");
            }
        }
    }
}
