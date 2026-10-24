package com.blo.sales.v2.view.components.inputText;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.scene.layout.VBox;

public class InputText extends VBox {
    
    @FXML private Label lblTitle;
    @FXML private TextField textField;
    @FXML private Label lblError;

    public InputText() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/blo/sales/v2/view/components/inputText/input-text.fxml"));
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
        return textField.getText();
    }
    
    public String getTitle() {
        return lblTitle.getText();
    }

    public void setText(String value) {
        textField.setText(value);
    }

    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public void setPromptText(String prompt) {
        if (textField != null) {
            textField.setPromptText(prompt);
        }
    }

    public String getPromptText() {
        return textField != null ? textField.getPromptText() : "";
    }

    // Método útil para mostrar errores visuales de validación
    public void setError(String errorMessage) {
        if (errorMessage != null && !errorMessage.isEmpty()) {
            lblError.setText(errorMessage);
            lblError.setVisible(true);
            lblError.setManaged(true);
            // Cambia el borde a rojo si hay error
            textField.setStyle("-fx-background-radius: 6px; -fx-border-radius: 6px; -fx-border-color: #dc2626; -fx-padding: 8px;");
        } else {
            lblError.setText("");
            lblError.setVisible(false);
            lblError.setManaged(false);
            // Restaura el borde normal
            textField.setStyle("-fx-background-radius: 6px; -fx-border-radius: 6px; -fx-border-color: #d1d5db; -fx-padding: 8px;");
        }
    }
    
}
