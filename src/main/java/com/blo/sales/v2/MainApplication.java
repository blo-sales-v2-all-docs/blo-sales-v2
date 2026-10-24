package com.blo.sales.v2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/pages/login/login-view.fxml"));
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/blo/sales/v2/view/pages/login/login-view.fxml"));
            Parent root = loader.load();

       Scene scene = new Scene(root);
            primaryStage.setTitle("Mi Aplicación JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
