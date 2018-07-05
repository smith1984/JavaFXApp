package ru.smith.next_tutorial;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main_5 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My window");
        Pane root = new Pane();

        ListView<Double> listView = new ListView<>();
        ObservableList<Double> items = FXCollections.observableArrayList(0.1, 0.2, 0.3, 0.4, 0.5, 0.6,
                0.7, 0.8, 0.9, 1.0);
        listView.setItems(items);
        listView.setPrefSize(100, 150);

        Rectangle rectangle = new Rectangle(200, 200, Color.DARKBLUE);
        rectangle.setX(100);
        rectangle.setY(100);

        listView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->{
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), rectangle);
            if (oldValue == null)
                ft.setFromValue(1.0);
            else
                ft.setFromValue(oldValue.doubleValue());
            ft.setToValue(newValue.doubleValue());
        ft.play();
        });

        root.getChildren().addAll(listView, rectangle);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}