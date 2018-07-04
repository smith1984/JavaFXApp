package ru.smith.evil_nerd_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JFXGridPane extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Расположение компонент");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label nameLabel = new Label("Имя пользователя:");
        GridPane.setConstraints(nameLabel, 0 , 0);

        TextField nameInput = new TextField("");
        nameInput.setPromptText("Введите имя");
        GridPane.setConstraints(nameInput,1, 0 );

        Label passLabel = new Label("Пароль:");
        GridPane.setConstraints(passLabel, 0, 1);

        TextField passInput = new PasswordField();
        passInput.setPromptText("Введите пароль");
        GridPane.setConstraints(passInput, 1,1);

        Label ageLabel = new Label("Возраст:");
        GridPane.setConstraints(ageLabel, 0 , 2);

        TextField ageInput = new TextField();
        ageInput.setPromptText("Введите возраст");
        GridPane.setConstraints(ageInput,1, 2 );

        Button buttonLogin = new Button("Войти");
        buttonLogin.setOnAction(event -> isNumber(ageInput)/*System.out.println(
                "Ваше имя - " + nameInput.getText() + "\nВаш пароль - " + passInput.getText() +
                "\nВаш возраст - " + Integer.valueOf(ageInput.getText()))*/
        );
        GridPane.setConstraints(buttonLogin, 1, 3);

        gridPane.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, ageLabel, ageInput,  buttonLogin);
        gridPane.setStyle("-fx-background-color: rgba(54,118,255,0.38)");
        Scene scene = new Scene(gridPane, 350, 150);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void isNumber(TextField input){
        try{
            System.out.println(Integer.parseInt(input.getText()));
        }
        catch (NumberFormatException e){
            input.setText("");
            input.setPromptText("Вы ввели не число");
        }
    }
}
