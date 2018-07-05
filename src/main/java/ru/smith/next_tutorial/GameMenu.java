package ru.smith.next_tutorial;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Image img = new Image(getClass().getResourceAsStream("/Castle.jpg"));
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(900);
        imageView.setFitHeight(600);
        root.getChildren().addAll(imageView);

        MenuItem newGame = new MenuItem("Новая игра");
        MenuItem options = new MenuItem("Настройки");
        MenuItem exitGame = new MenuItem("Выход");

        SubMenu mainMenu = new SubMenu(newGame, options, exitGame);

        MenuItem sound = new MenuItem("Звук");
        MenuItem video = new MenuItem("Видео");
        MenuItem keys = new MenuItem("Управление");
        MenuItem optionsBack = new MenuItem("Назад");

        SubMenu optionsMenu = new SubMenu(sound, video, keys, optionsBack);

        MenuItem nG1 = new MenuItem("Турнир");
        MenuItem nG2 = new MenuItem("Одиночный заезд");
        MenuItem nG3 = new MenuItem("2 игрока");
        MenuItem nGBack = new MenuItem("Назад");

        SubMenu newGameMenu = new SubMenu(nG1, nG2, nG3, nGBack);

        MenuBox menuBox = new MenuBox(mainMenu);

        newGame.setOnMouseClicked(e -> {
            menuBox.setSubMenu(newGameMenu);
        });
        options.setOnMouseClicked(e -> {
            menuBox.setSubMenu(optionsMenu);
        });
        exitGame.setOnMouseClicked(e -> {
            System.exit(0);
        });
        options.setOnMouseClicked(e -> {
            menuBox.setSubMenu(optionsMenu);
        });
        nGBack.setOnMouseClicked(e -> {
            menuBox.setSubMenu(mainMenu);
        });
        optionsBack.setOnMouseClicked(e -> {
            menuBox.setSubMenu(mainMenu);
        });
        root.getChildren().addAll(mainMenu);

        Scene scene = new Scene(root, 900, 600);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                FadeTransition ft = new FadeTransition(Duration.seconds(1), menuBox);
                if (!menuBox.isVisible()) {
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                } else {
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.play();
                    ft.setOnFinished(event1 -> menuBox.setVisible(false));

                }
            }
        });

        primaryStage.setTitle("Game menu");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static class MenuItem extends StackPane {
        MenuItem(String name) {
            Rectangle bg = new Rectangle(200, 20, Color.WHITE);
            bg.setOpacity(0.5);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
            FillTransition fillTransition = new FillTransition(Duration.seconds(0.5), bg);

            setOnMouseEntered(event -> {
                fillTransition.setToValue(Color.DARKGOLDENROD);
                fillTransition.setFromValue(Color.DARKGRAY);
                fillTransition.setCycleCount(Animation.INDEFINITE);
                fillTransition.setAutoReverse(true);
                fillTransition.play();
            });

            setOnMouseExited(event -> {
                fillTransition.stop();
                bg.setFill(Color.WHITE);
            });
        }

    }

    private static class MenuBox extends Pane{

    }

}
