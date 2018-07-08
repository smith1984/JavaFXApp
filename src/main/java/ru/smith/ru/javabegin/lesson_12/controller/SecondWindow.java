package ru.smith.ru.javabegin.lesson_12.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import ru.smith.ru.javabegin.lesson_12.objects.Person;
import ru.smith.ru.javabegin.lesson_12.utils.DialogManager;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondWindow implements Initializable {
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

    private Person person;


    private ResourceBundle resourceBundle;

    public void setPerson (Person person){
        this.person = person;

        nameTextField.setText(person.getName());
        lastNameTextField.setText(person.getLastName());
        nameFatherTextField.setText(person.getNameFather());
        phoneTextField.setText(person.getPhone());
    }
    public Person getPerson(){
        return person;
    }

    public void closeWindow(ActionEvent actionEvent){
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.hide();
    }

    public void actionSave(ActionEvent actionEvent){
        if (!checkValues()){
            return;
        }
        person.setName(nameTextField.getText());
        person.setLastName(lastNameTextField.getText());
        person.setNameFather(nameFatherTextField.getText());
        person.setPhone(phoneTextField.getText());
        closeWindow(actionEvent);
    }

    private boolean checkValues() {
        if (nameTextField.getText().trim().length()==0 || lastNameTextField.getText().trim().length()==0
                || nameFatherTextField.getText().trim().length()==0 || phoneTextField.getText().trim().length()==0){
            DialogManager.showInfoDialog(resourceBundle.getString("error"), resourceBundle.getString("fill_field"));
            return false;
        }

        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
    }
}
