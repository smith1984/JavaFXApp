package ru.smith.evil_nerd_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JFXChoiceBox_ComboBox extends Application {

    Stage window;
    Button button;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Расположение компонент");

        button = new Button("голосовать!");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Forest", "Jocker", "Ice Ventura", "Mia", "Mellory");
        choiceBox.getSelectionModel().select(0);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->
                System.out.println(oldValue + ":" + newValue));

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Noize Mc", "Assai", "Negative");
        comboBox.setPromptText("choice your artist");
        comboBox.setEditable(true);
        comboBox.setOnAction(e -> System.out.println(comboBox.getValue()));



        button.setOnAction(event -> {
            getChoise(choiceBox);
            if (!comboBox.getItems().contains(comboBox.getValue()))
            comboBox.getItems().add(comboBox.getValue());
            System.out.println(comboBox.getValue());
        });


        HBox layout = new HBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, comboBox, button);

        Scene scene = new Scene(layout, 350, 200);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void getChoise(ChoiceBox<String> choiceBox){
        System.out.println(choiceBox.getValue());
    }
}
