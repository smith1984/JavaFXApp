package ru.smith.next_tutorial;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("My window");
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);

        Group root = new Group();

        Button button = new Button("Click me");
        button.setTranslateX(100);
        button.setTranslateY(100);
        button.setPrefSize(90, 20);
        button.setStyle("-fx-background-color: #20806e");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GREEN);
        dropShadow.setRadius(40);

        Rectangle rectangle = new Rectangle(50, 50);

        button.setOnAction(event -> {System.out.println("Hello");
        rectangle.setFill(Color.RED);
        button.setEffect(dropShadow);});
        root.getChildren().addAll(button, rectangle);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
