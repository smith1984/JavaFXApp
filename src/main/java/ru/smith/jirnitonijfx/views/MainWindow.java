package ru.smith.jirnitonijfx.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {
    private static String title = "Main Window";
    private BorderPane root;


    public MainWindow init(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ru/smith/jirnitonijfx/main_window.fxml"));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root, Main.WIDTH, Main.HEIGHT));
        primaryStage.show();
        return this;
    }

    public void setContent(Parent parent){
        root.setCenter(parent);
    }
}