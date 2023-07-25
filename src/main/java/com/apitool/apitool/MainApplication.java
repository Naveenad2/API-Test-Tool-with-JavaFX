package com.apitool.apitool;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label to display "Hello, World!"
        Label helloLabel = new Label("Hello, World!");

        // Create a button
        Button button = new Button("Click Me!");
        button.setOnAction(e -> System.out.println("Hello, World!"));

        // Create a layout to hold the label and button
        StackPane root = new StackPane();
        root.getChildren().addAll(helloLabel, button);

        // Create the scene and add the layout to it
        Scene scene = new Scene(root, 300, 200);

        // Set the scene on the primary stage and show it
        primaryStage.setTitle("Hello, World JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
