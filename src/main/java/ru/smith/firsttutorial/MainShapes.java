package ru.smith.firsttutorial;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainShapes extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();


        Line line = new Line(0, 0, 100, 100);
        line.setStroke(Color.GREEN);
        Ellipse ellipse = new Ellipse(0,0,100,100);
        Rectangle rectangle= new Rectangle(50,50,150,100);
        Text text = new Text(150, 150, "Shapes");
        text.setFont(Font.font(30));
        rectangle.setFill(Color.BLUE);
        root.getChildren().add(line);
        root.getChildren().add(ellipse);
        root.getChildren().add(rectangle);
        root.getChildren().add(text);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
