package ru.smith.next_tutorial;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main_8 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My window");
        Pane root = new Pane();
        Bullet bullet = new Bullet();

        root.getChildren().add(bullet);

        Scene scene = new Scene(root, 600, 600);

        scene.setOnMouseMoved(event -> {
            bullet.setTarget(event.getSceneX(), event.getSceneY());
        });

        scene.setOnMouseClicked(event -> {
            bullet.velocity = new Point2D(0, 0);
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                bullet.move();
            }
        };
        animationTimer.start();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}