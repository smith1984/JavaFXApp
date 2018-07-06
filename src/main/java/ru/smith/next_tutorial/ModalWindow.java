package ru.smith.next_tutorial;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class ModalWindow {

    public static void newWindow(String title){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Pane pane = new Pane();

        Label label = new Label("It is modal window");
        Button button = new Button("Close window");
        button.setOnAction(event -> window.close());

        pane.getChildren().add(label);
        Scene scene = new Scene(pane, 100, 100);
        window.setTitle(title);
        window.setScene(scene);
        window.showAndWait();
    }
}
