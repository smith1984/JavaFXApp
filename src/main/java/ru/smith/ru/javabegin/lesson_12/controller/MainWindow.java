package ru.smith.ru.javabegin.lesson_12.controller;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import lombok.Getter;

import ru.smith.ru.javabegin.lesson_12.interfaces.impls.CollectionAddressBook;
import ru.smith.ru.javabegin.lesson_12.objects.Person;

import java.io.IOException;

@Getter
public class MainWindow {

    private CollectionAddressBook collectionAddressBook = new CollectionAddressBook();

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button delButton;

    @FXML
    private Label label;

    @FXML
    private TableView table;

    @FXML
    private TableColumn<Person, String> nameTableColumn;

    @FXML
    private TableColumn<Person, String> lastNameTableColumn;

    @FXML
    private TableColumn<Person, String> nameFatherTableColumn;

    @FXML
    private TableColumn<Person, String> phoneTableColumn;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private void initialize(){
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        nameFatherTableColumn.setCellValueFactory(new PropertyValueFactory<>("nameFather"));
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));


        collectionAddressBook.getPersonArrayList().addListener((ListChangeListener) c -> updateCountLabel());

        collectionAddressBook.fillData();
        table.setItems(collectionAddressBook.getPersonArrayList());
    }

    private void updateCountLabel(){
        label.setText("Количество записей: " + collectionAddressBook.getPersonArrayList().size());
    }
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
