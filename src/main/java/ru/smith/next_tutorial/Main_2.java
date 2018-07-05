package ru.smith.next_tutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main_2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My window");
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);

        ToggleButton tb1 = new ToggleButton("Green");
        ToggleButton tb2 = new ToggleButton("Blue");
        ToggleButton tb3 = new ToggleButton("Red");

        tb1.setUserData(Color.LIGHTGREEN);
        tb2.setUserData(Color.LIGHTBLUE);
        tb3.setUserData(Color.LIGHTCORAL);

        tb1.setStyle("-fx-base: lightgreen");
        tb2.setStyle("-fx-base: lightblue");
        tb3.setStyle("-fx-base: lightcoral");

        ToggleGroup group = new ToggleGroup();
        tb1.setToggleGroup(group);
        tb2.setToggleGroup(group);
        tb3.setToggleGroup(group);

        HBox tbuttons = new HBox(10);
        tbuttons.getChildren().addAll(tb1, tb2, tb3);
        tbuttons.setAlignment(Pos.CENTER);

        Rectangle rectangle = new Rectangle(300, 300);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.DARKOLIVEGREEN);
        rectangle.setStrokeWidth(2);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);

        group.selectedToggleProperty().addListener(e -> {
            if (group.getSelectedToggle() == null)
                rectangle.setFill(Color.WHITE);
            else
                rectangle.setFill((Color) group.getSelectedToggle().getUserData());
        });
        tb2.setSelected(true);

        VBox btns = new VBox(20);
        btns.setAlignment(Pos.CENTER_LEFT);

        VBox rects = new VBox(10);
        rects.setAlignment(Pos.CENTER);

        CheckBox[] cbs = new CheckBox[]{
                new CheckBox("red"),
                new CheckBox("green"),
                new CheckBox("blue")
        };

        Rectangle[] rc = new Rectangle[]{
                new Rectangle(100, 100, Color.RED),
                new Rectangle(100, 100, Color.GREEN),
                new Rectangle(100, 100, Color.BLUE)
        };

        for (int i = 0; i < 3; i++) {
            CheckBox ch = cbs[i];
            Rectangle rect = rc[i];
            btns.getChildren().add(ch);
            ch.selectedProperty().addListener(e -> {
                if (ch.isSelected())
                    rects.getChildren().add(rect);
                else
                    rects.getChildren().remove(rect);
            });
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(tbuttons);
        borderPane.setCenter(rectangle);
        borderPane.setLeft(btns);
        borderPane.setRight(rects);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
