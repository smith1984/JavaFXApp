package ru.smith.ru.javabegin.lesson_12.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

    @FXML
    TableColumn tableColumnPhone;

    @FXML
    TableColumn tableColumnName;

    @FXML
    Button addButton;

    @FXML
    Button editButton;

    @FXML
    Button delButton;

    @FXML
    Label label;

    @FXML
    TableView<String> table;

    @FXML
    Button searchButton;

    @FXML
    TextField searchTextField;



    public void showDialog (ActionEvent actionEvent){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/ru/javabegin/lesson_12/second_window.fxml"));
            Stage stage = new Stage();
            stage.setTitle(((Button)actionEvent.getSource()).getText().equals("Добавить")?
                    "Добавить запись":"Редактирование записи");
            // stage.setMinHeight(205);
            // stage.setMinWidth(270);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
