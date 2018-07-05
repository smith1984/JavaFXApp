package ru.smith.next_tutorial;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main_3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My window");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        TextField name = new TextField("Your Name");
        GridPane.setConstraints(name, 0, 0);

        TextField lastName = new TextField("Your Last Name");
        GridPane.setConstraints(lastName, 0, 1);

        TextField comment = new TextField();
        comment.setPromptText("Commentaries");
        GridPane.setConstraints(comment, 0, 2);

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0, 1,1,HPos.RIGHT, VPos.BASELINE);


        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1, 1,1,HPos.RIGHT, VPos.BASELINE);

        Label label = new Label("");
        GridPane.setConstraints(label, 0,3, 2, 1);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter you password");
        GridPane.setConstraints(passwordField, 1,2);
        gridPane.getChildren().addAll(name, lastName, comment, submit, clear, label, passwordField);

        submit.setOnAction(event -> {
            System.out.println(passwordField.getText());
            if (!comment.getText().isEmpty())
                label.setText(name.getText() + " " +
                lastName.getText() + " " + comment.getText());
            else
                label.setText("You have not left a comment");
        });

        clear.setOnAction(event -> {
            name.setText("");
            lastName.setText("");
            comment.setText("");
            label.setText("");
        });

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
