package ru.smith;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainLayout extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(200, 150);
        borderPane.setCenter(new Button("Press my"));

        //root.getChildren().addAll(new Button("Press my"), new TextField("Бла бла бла"));
        root.getChildren().add(borderPane);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
