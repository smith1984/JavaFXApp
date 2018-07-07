package ru.smith.ru.javabegin.lesson_06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/ru/javabegin/lesson_06/sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 300, 300);
        scene.getStylesheets().add(0, "/ru/javabegin/lesson_06/css/my.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}