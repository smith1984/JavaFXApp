package ru.smith.ru.javabegin.lesson_12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ru/javabegin/lesson_12/main_window.fxml"));
        primaryStage.setTitle("Телефонный справочник");
        Scene scene = new Scene(root, 330, 300);
        scene.getStylesheets().add(0, "/ru/javabegin/lesson_12/css/my.css");
        primaryStage.setMinWidth(330);
        primaryStage.setMinHeight(330);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}