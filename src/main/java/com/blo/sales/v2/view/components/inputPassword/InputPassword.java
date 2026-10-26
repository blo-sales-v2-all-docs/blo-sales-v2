/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blo.sales.v2.view.components.inputPassword;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Orlando
 */
public class InputPassword extends VBox {
       
    @FXML private Label pwdTitle;
    @FXML private PasswordField passwordField;
    @FXML private Label lblError;

    public InputPassword() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/blo/sales/v2/view/components/inputPassword/input-password.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar custom-input.fxml", e);
        }
    }

    // Métodos públicos para controlar el input desde tus controladores
    public String getText() {
        return passwordField.getText();
    }
    
    public String getTitle() {
        return pwdTitle.getText();
    }

    public void setText(String value) {
    	passwordField.setText(value);
    }

    public void setTitle(String title) {
    	pwdTitle.setText(title);
    }

    public void setPromptText(String prompt) {
        if (passwordField != null) {
        	passwordField.setPromptText(prompt);
        }
    }

    public String getPromptText() {
        return passwordField != null ? passwordField.getPromptText() : "";
    }
    
    public StringProperty getTextProperty() {
    	return passwordField.textProperty();
    }

    // Método útil para mostrar errores visuales de validación
    public void setError(String errorMessage) {
        if (errorMessage != null && !errorMessage.isEmpty()) {
            lblError.setText(errorMessage);
            lblError.setVisible(true);
            lblError.setManaged(true);
            // Cambia el borde a rojo si hay error
            passwordField.setStyle("-fx-background-radius: 6px; -fx-border-radius: 6px; -fx-border-color: #dc2626; -fx-padding: 8px;");
        } else {
            lblError.setText("");
            lblError.setVisible(false);
            lblError.setManaged(false);
            // Restaura el borde normal
            passwordField.setStyle("-fx-background-radius: 6px; -fx-border-radius: 6px; -fx-border-color: #d1d5db; -fx-padding: 8px;");
        }
    }
}
