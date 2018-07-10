package ru.smith.jirnitonijfx.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import ru.smith.jirnitonijfx.views.model.Person;

import java.io.IOException;

public class ListViewController {

    @FXML
    private ListView<Person> list;

    @FXML
    public void initialize(){
        ObservableList<Person> array = FXCollections.observableArrayList();
        array.addAll(new Person("Yan", "Frank"), new Person("Julia", "Rudenko"));
        list.setItems(array);
    }

    public Parent init(){
        try {
            return FXMLLoader.load(getClass().getResource("/ru/smith/jirnitonijfx/list_view.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

