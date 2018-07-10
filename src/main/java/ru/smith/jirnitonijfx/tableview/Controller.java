package ru.smith.jirnitonijfx.tableview;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.smith.jirnitonijfx.tableview.model.Person;

public class Controller {

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, String> columnName;

    @FXML
    private TableColumn<Person, String> columnSurName;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldSurName;

    @FXML
    private  Tab tabTableView;

    @FXML
    private  Tab tabEdit;


    @FXML
    private TabPane tabPane;


    private boolean editing;

    private ObservableList<Person> items;

    @FXML
    public void initialize() {
        tabPane.getSelectionModel().select(1);
        System.out.println(tabPane.getSelectionModel().getSelectedItem().getText());
        items = FXCollections.observableArrayList();
        items.addAll(new Person("Maksim", "Petrov"),
                new Person("Valeriya", "Petrova"));

        table.setItems(items);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setRowFactory(param -> {
            TableRow<Person> row = new TableRow<>();
            MenuItem remove = new MenuItem("Remove");
            remove.setOnAction(event -> items.removeAll(table.getSelectionModel().getSelectedItems()));
            MenuItem edit = new MenuItem("Edit");
            edit.setOnAction(event -> {
                textFieldName.setText(table.getSelectionModel().getSelectedItem().getName());
                textFieldSurName.setText(table.getSelectionModel().getSelectedItem().getSurName());
                editing = true;
                tabPane.getSelectionModel().select(1);
            });
            ContextMenu menu = new ContextMenu(remove, edit);
            row.contextMenuProperty().setValue(menu);
            return row;
        });
        // можно так
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        /*или так через анонимный класс

        columnSurName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> param) {
                return new SimpleStringProperty(param.getValue().getSurName());
                }
        }*/
        //через lambda
        columnSurName.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getSurName()));

        table.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2)
                        //System.out.println(table.getSelectionModel().getSelectedItem()); <- Для singe mode
                        table.getSelectionModel().getSelectedItems().forEach(System.out::println);
                }
        );
    }

    @FXML
    private void add() {
        if (editing) {
            table.getSelectionModel().getSelectedItem().setName(textFieldName.getText());
            table.getSelectionModel().getSelectedItem().setSurName(textFieldSurName.getText());
            table.refresh();
            System.out.println("edited Person");
            editing = false;
        } else {
            if (!textFieldName.getText().equals("") && !textFieldSurName.getText().equals("")) {
                items.add(new Person(textFieldName.getText(), textFieldSurName.getText()));
                System.out.println("added new Person");
            }
        }
        textFieldName.clear();
        textFieldSurName.clear();
        tabPane.getSelectionModel().select(0);
    }

    @FXML
    private void close(){
        System.exit(0);
    }
}
