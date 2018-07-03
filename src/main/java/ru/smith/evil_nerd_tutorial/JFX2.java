package ru.smith.evil_nerd_tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JFX2 extends Application {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        Label label1 = new Label("Window #1");
        Button button1 = new Button("Переход во второе окно");
        button1.setOnAction(event -> window.setScene(scene2));
        Button button3 = new Button("Press me");
        button3.setOnAction(event -> {
            boolean result = ConfirmWindow.display("Confirm window", "??????");
            System.out.println(result);});
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button3);
        scene1 = new Scene(layout1, 300, 300);

        Label label2 = new Label("Window #2");
        Button button2 = new Button("Переход в первое окно");
        button2.setOnAction(event -> window.setScene(scene1));
       // HBox layout2 = new HBox(20);
        Button button = new Button("Click me");
        button.setPrefSize(120, 60);
        button.setOnAction(event -> AlertWindow.display("Window property", "Chosee property"));
        BorderPane layout2 = new BorderPane();
        layout2.setTop(label2);
        layout2.setBottom(button2);
        layout2.setCenter(button);
        //layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 300, 300);

        window.setScene(scene1);
        window.setTitle("Многооконность");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
