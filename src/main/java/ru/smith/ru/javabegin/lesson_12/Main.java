package ru.smith.ru.javabegin.lesson_12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/ru/javabegin/lesson_12/main_window.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("ru.javabegin.bundles.Locale", new Locale("en")));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle(fxmlLoader.getResources().getString("address_book"));
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