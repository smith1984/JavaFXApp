package ru.smith.evil_nerd_tutorial;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JFX4 extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Расположение компонент");

        HBox topMenu = new HBox(5);
        topMenu.setAlignment(Pos.CENTER);
        Button button1 = new Button("File");
        Button button2 = new Button("View");
        Button button3 = new Button("Edit");
        topMenu.getChildren().addAll(button1, button2, button3);

        VBox leftMenu = new VBox(5);
        leftMenu.setAlignment(Pos.CENTER_LEFT);
        Button button4 = new Button("Copy");
        Button button5 = new Button("Cut");
        Button button6 = new Button("Paste");
        leftMenu.getChildren().addAll(button4, button5, button6);

        VBox rightMenu = new VBox(5);
        rightMenu.setAlignment(Pos.CENTER_RIGHT);
        Button button7 = new Button("Color");
        Button button8 = new Button("Fill");
        Button button9 = new Button("Undo" );
        rightMenu.getChildren().addAll(button7, button8, button9);

        HBox bottomMenu = new HBox(5);
        bottomMenu.setAlignment(Pos.CENTER);
        bottomMenu.setStyle("-fx-background-color: #c0eef3");
        Button button10 = new Button("Close");
        bottomMenu.getChildren().addAll(button10);

        BorderPane bp = new BorderPane();
        bp.setBottom(bottomMenu);
        bp.setTop(topMenu);
        bp.setLeft(leftMenu);
        bp.setRight(rightMenu);

        StackPane layout1 = new StackPane();
        Scene scene = new Scene(bp, 500, 200);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}