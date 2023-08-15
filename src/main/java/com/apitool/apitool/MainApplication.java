package com.apitool.apitool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/apitool/apitool/main-view.fxml"));

        // Set the scene on the primary stage and show it
        Scene scene = new Scene(root, 800, 600);

        // Add the CSS stylesheet to the scene
        scene.getStylesheets().add(getClass().getResource("/com/apitool/apitool/styles.css").toExternalForm());

        primaryStage.setTitle("Api Testting Tool");
        primaryStage.setScene(scene);

       // primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
