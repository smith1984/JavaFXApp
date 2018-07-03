package ru.smith.evil_nerd_tutorial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmWindow {

    static boolean ansver;

    public static boolean display(String title, String message){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        //window.setMinWidth(250);
        //window.setMinHeight(200);

        Label label = new Label(message);
        label.setFont(Font.font(20));

        Button yesButton = new Button("Да");
        yesButton.setOnAction(event ->  {
            ansver = true;
            window.close();
        });
        Button noButton = new Button("Нет");
        noButton.setOnAction(event ->  {
            ansver = false;
            window.close();
        });
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label, yesButton, noButton);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 250, 200);

        window.setScene(scene);
        window.showAndWait();
        return ansver;
    }
}
