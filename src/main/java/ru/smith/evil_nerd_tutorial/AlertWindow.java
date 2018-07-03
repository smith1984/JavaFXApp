package ru.smith.evil_nerd_tutorial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {
    public static void display(String title, String message){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        //window.setMinWidth(250);
        //window.setMinHeight(200);

        Label label = new Label(message);
        label.setFont(Font.font(20));

        Button button = new Button("Close window");
        button.setOnAction(e -> window.close());

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label, button);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 250, 200);

        window.setScene(scene);
        window.show();

    }
}
