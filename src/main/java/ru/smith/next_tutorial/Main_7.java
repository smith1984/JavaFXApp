package ru.smith.next_tutorial;

import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main_7 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My window");
        Pane root = new Pane();

        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
        rectangle.setX(100);
        rectangle.setY(100);

        Rectangle rectangle2 = new Rectangle(100, 100, Color.RED);
        rectangle2.setX(100);
        rectangle2.setY(250);


        rectangle.setOnMouseClicked(event -> {
            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), rectangle);
            rotateTransition.setByAngle(180);
            rotateTransition.setCycleCount(2);
            rotateTransition.setAutoReverse(true);
            rotateTransition.play();
        });

        rectangle2.setOnMouseEntered(event -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), rectangle2);
            scaleTransition.setToX(2);
            scaleTransition.setToY(2);
            scaleTransition.play();
        });

        rectangle2.setOnMouseExited(event -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), rectangle2);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });

        Rectangle rectangle3 = new Rectangle(100, 100, Color.RED);
        rectangle3.setX(250);
        rectangle3.setY(100);
        rectangle3.setStroke(Color.BLACK);
        rectangle3.setStrokeWidth(3);

        rectangle3.setOnMousePressed(event -> {
            StrokeTransition st = new StrokeTransition(Duration.seconds(1), rectangle3);
            st.setFromValue(Color.BLACK);
            st.setToValue(Color.GREENYELLOW);
            st.play();
        });

        rectangle3.setOnMouseReleased(event -> {
            StrokeTransition st = new StrokeTransition(Duration.seconds(1), rectangle3);
            st.setFromValue(Color.GREENYELLOW);
            st.setToValue(Color.BLACK);
            st.play();

        });

        Rectangle rectangle4 = new Rectangle(100, 100, Color.RED);
        rectangle4.setX(250);
        rectangle4.setY(250);

        rectangle4.setOnMouseEntered(event -> {
            FillTransition ft = new FillTransition(Duration.seconds(1), rectangle4);
            ft.setFromValue(Color.RED);
            ft.setToValue(Color.BLUE);
            ft.setOnFinished(event1 -> {
                System.out.println("Finished");
            });
            ft.play();
        });

        rectangle4.setOnMouseExited(event -> {
            FillTransition ft = new FillTransition(Duration.seconds(1), rectangle4);
            ft.setFromValue(Color.BLUE);
            ft.setToValue(Color.RED);
            ft.play();
        });

        root.getChildren().addAll(rectangle, rectangle2, rectangle3, rectangle4);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}