package ru.smith.evil_nerd_tutorial;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class JFXTableView extends Application {

    Stage window;
    Scene scene;
    TableView<eLibrary> tableView;

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Расположение компонент");

        TableColumn<eLibrary,String> nameColumn = new TableColumn<>();
        nameColumn.setText("Автор");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameAuthor"));

        TableColumn<eLibrary,String> titleColumn = new TableColumn<>();
        titleColumn.setText("Произведение");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("workTitle"));

        TableColumn<eLibrary,Double> priceColumn = new TableColumn<>();
        priceColumn.setText("Цена");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView = new TableView<>();
        tableView.setItems(getBook());
        tableView.getColumns().addAll(nameColumn, titleColumn, priceColumn);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(tableView);
        scene = new Scene(layout, 550, 270);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<eLibrary> getBook() {

        ObservableList<eLibrary> books = FXCollections.observableArrayList();
        books.add(new eLibrary("Лукьяненко Сергей Васильевич",
                "Черновик", 512.45));
        books.add(new eLibrary("Стивен Кинг",
                "Темная башня 1-6 том", 2412.45));
        books.add(new eLibrary("Стивен Кинг",
                "Нужные вещи", 412.45));
        books.add(new eLibrary("Айзек Азимов",
                "Я, Робот", 552.55));
        books.add(new eLibrary("Айзек Азимов",
                "Выбор Катастров", 542.45));
        books.add(new eLibrary("Беляев Александр",
                "Продавец Воздуха", 516.45));
        books.add(new eLibrary("Есенин Сергей Александрович",
                "Избранное", 1012.45));

        return  books;

    }
}

