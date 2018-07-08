package ru.smith.ru.javabegin.lesson_12.controller;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;

import lombok.Getter;

import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import ru.smith.ru.javabegin.lesson_12.interfaces.impls.CollectionAddressBook;
import ru.smith.ru.javabegin.lesson_12.objects.Person;
import ru.smith.ru.javabegin.lesson_12.utils.DialogManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.ResourceBundle;

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
    private CustomTextField searchTextField;

    private Parent root;

    private FXMLLoader fxmlLoader = new FXMLLoader();

    private Stage stage;

    private SecondWindow secondWindow;

    private ObservableList<Person> backUpList;

    @FXML
    private void initialize() {
        linkTable();
        initLoader();
        initListeners();
        fillData();
        setupClearButtonField(searchTextField);


    }

    private void linkTable() {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        nameFatherTableColumn.setCellValueFactory(new PropertyValueFactory<>("nameFather"));
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    private void fillData() {
        collectionAddressBook.fillData();
        backUpList = FXCollections.observableArrayList();
        backUpList.addAll(collectionAddressBook.getPersonArrayList());
        table.setItems(collectionAddressBook.getPersonArrayList());
        //table.getSelectionModel().select(0);
    }

    private void initListeners() {

        collectionAddressBook.getPersonArrayList().addListener((ListChangeListener) c -> updateCountLabel());

        table.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                secondWindow.setPerson((Person) table.getSelectionModel().getSelectedItem());
                showDialog();
            }
        });


    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("/ru/javabegin/lesson_12/second_window.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("ru.javabegin.bundles.Locale", new Locale("en")));
            root = fxmlLoader.load();
            secondWindow = fxmlLoader.getController();
        } catch (
                IOException e)

        {
            e.printStackTrace();
        }
    }

    private void updateCountLabel() {
        label.setText(fxmlLoader.getResources().getString("label") + collectionAddressBook.getPersonArrayList().size());
    }

    public void actionButtonClicked(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (!(source instanceof Button))
            return;

        Button btnclicked = (Button) source;

        Person selectedPerson = (Person)table.getSelectionModel().getSelectedItem();

        switch (btnclicked.getId()) {
            case "addButton":
                secondWindow.setPerson(new Person());
                showDialog();
                if (!(secondWindow.getPerson().equals(new Person("", "", "", ""))))
                    collectionAddressBook.add(secondWindow.getPerson());

                break;
            case "editButton":
                if (!personSelected(selectedPerson))
                    return;
                secondWindow.setPerson((Person) table.getSelectionModel().getSelectedItem());
                showDialog();

                break;
            case "delButton":
                if (!personSelected(selectedPerson))
                    return;
                collectionAddressBook.delete((Person) table.getSelectionModel().getSelectedItem());
                break;
        }


    }

    private boolean personSelected (Person selectedPerson){
        if (selectedPerson == null){
            DialogManager.showInfoDialog(fxmlLoader.getResources().getString("error"),
                    fxmlLoader.getResources().getString("select_person"));
            return false;
        }
        return true;
    }

    public void showDialog() {
        if (stage == null) {
            stage = new Stage();
            stage.setResizable(false);
            stage.setTitle(fxmlLoader.getResources().getString("addRec"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
        }
        stage.showAndWait();
    }

    private void setupClearButtonField(CustomTextField customTextField) {
        try {
            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
            m.setAccessible(true);
            m.invoke(null, customTextField, customTextField.rightProperty());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actionSearch(ActionEvent actionEvent){
        collectionAddressBook.getPersonArrayList().clear();

        for (Person person:backUpList){
            if (person.getName().toLowerCase().contains(searchTextField.getText().toLowerCase()) ||
                    person.getLastName().toLowerCase().contains(searchTextField.getText().toLowerCase()) ||
                    person.getNameFather().toLowerCase().contains(searchTextField.getText().toLowerCase()) ||
                    person.getPhone().toLowerCase().contains(searchTextField.getText().toLowerCase()))
            {collectionAddressBook.getPersonArrayList().add(person);}
        }
    }
}
