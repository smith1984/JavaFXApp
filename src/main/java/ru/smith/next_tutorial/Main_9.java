package ru.smith.next_tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main_9 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Button btn = new Button("New window");
        btn.setOnAction(event ->
            ModalWindow.newWindow("Modal window")
        );

        pane.getChildren().add(btn);
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Base window");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
