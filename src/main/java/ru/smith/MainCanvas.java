package ru.smith;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainCanvas  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Canvas canvas = new Canvas(400, 300);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawShapes(context);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Canvas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

        private void drawShapes (GraphicsContext gc){
            gc.setFill(Color.GREEN);
            gc.setStroke(Color.BLUE);
            gc.setLineWidth(5);
            gc.strokeLine(15, 15, 350, 350);
        }
    }