package ru.smith.next_tutorial;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main_4 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My window");
        primaryStage.setWidth(260);
        primaryStage.setHeight(360);
        Pane root = new Pane();

        ScrollBar scrollX = new ScrollBar();
        scrollX.setMin(0);
        scrollX.setMax(260);
        scrollX.setValue(100);
        scrollX.setPrefWidth(260);

        ScrollBar scrollY = new ScrollBar();
        scrollY.setMin(0);
        scrollY.setMax(260);
        scrollY.setValue(100);
        scrollY.setOrientation(Orientation.VERTICAL);
        scrollY.setTranslateY(15);
        scrollY.setPrefHeight(260);

        ScrollBar scrollOpacity = new ScrollBar();
        scrollOpacity.setMin(0);
        scrollOpacity.setMax(1);
        scrollOpacity.setValue(0.5);
        scrollOpacity.setTranslateY(275);
        scrollOpacity.setPrefWidth(260);

        Rectangle rectangle = new Rectangle(100, 100, Color.WHITE);
        rectangle.setTranslateX(15);
        rectangle.setTranslateY(15);
        rectangle.setOpacity(0.5);

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setTranslateY(295);
        choiceBox.setItems(FXCollections.observableArrayList("Red", "Green", "Yellow", "Blue", "Black"));
        Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.BLACK};
        choiceBox.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) ->{
            rectangle.setFill(colors[newValue.intValue()]);
        });


        root.getChildren().addAll(scrollX, scrollY, scrollOpacity, rectangle, choiceBox);

        scrollX.valueProperty().addListener(event -> {
            rectangle.setWidth(scrollX.getValue());
        });

        scrollY.valueProperty().addListener(event -> {
            rectangle.setHeight(scrollY.getValue());
        });

        scrollOpacity.valueProperty().addListener(e -> {
            rectangle.setOpacity(scrollOpacity.getValue());
        });



        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
