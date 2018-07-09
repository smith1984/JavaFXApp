package ru.smith.jirnitonijfx.listview;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import ru.smith.jirnitonijfx.listview.model.Person;

public class Controller {

    @FXML
    ListView listView;

    @FXML
    Button btn;

    Person smt = new Person("Smith");

    ObservableList<Person> list = FXCollections.observableArrayList( param -> new Observable[] {param.nameProperty()});

    public void initialize(){
        list.add(smt);
        listView.setItems(list);

    }

    public void addItemToList(){
        if (smt.getName().contentEquals("Smith"))
            smt.setName("Smithyy");
        else smt.setName("Smith");
        System.out.println(smt.getName());
    }
}
