package ru.smith.other_tutorial;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField field;

    @FXML
    private void handleButtonAction(){
        System.out.println("Button action");
        label.setText("Вы ввели:" + field.getText());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
