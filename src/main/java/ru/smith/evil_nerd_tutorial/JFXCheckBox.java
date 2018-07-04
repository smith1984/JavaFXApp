package ru.smith.evil_nerd_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JFXCheckBox extends Application {
    Stage window;
    Button button;
    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Расположение компонент");

        CheckBox checkBox1 = new CheckBox("One");
        CheckBox checkBox2 = new CheckBox("Two");
        CheckBox checkBox3 = new CheckBox("Three");
        CheckBox checkBox4 = new CheckBox("Four");
        checkBox1.setSelected(true);

        button = new Button("голосовать!");
        button.setOnAction(event -> handleProperty(checkBox1, checkBox2, checkBox3, checkBox4));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20 , 20));
        layout.getChildren().addAll(button, checkBox1, checkBox2, checkBox3, checkBox4);

        Scene scene = new Scene(layout,350, 200);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void handleProperty(CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4){
        System.out.println("Вы проголосовали за\n" +
                (box1.isSelected()?box1.getText() + "\n":"") +
                (box2.isSelected()?box2.getText() + "\n":"") +
                (box3.isSelected()?box3.getText() + "\n":"") +
                (box4.isSelected()?box4.getText() + "\n":""));
    }
}

