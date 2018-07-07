package ru.smith.ru.javabegin.lesson_12.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondWindow {
    @FXML
    TextField lastNameTextField;

    @FXML
    TextField nameTextField;

    @FXML
    TextField nameFatherTextField;

    @FXML
    TextField phoneTextField;

    @FXML
    Button okButton;

    @FXML
    Button cancelButton;

    public void close(ActionEvent actionEvent){
    }

}
