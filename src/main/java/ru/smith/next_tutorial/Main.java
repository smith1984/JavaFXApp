package ru.smith.next_tutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("My window");
        primaryStage.setWidth(450);
        primaryStage.setHeight(300);

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        Button button = new Button("Click me");
        button.setPrefSize(90, 20);
        button.setStyle("-fx-background-color: #20806e");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GREEN);
        dropShadow.setRadius(40);

        Rectangle rectangle = new Rectangle(50, 50);

        button.setOnAction(event -> {System.out.println("Hello");
        rectangle.setFill(Color.RED);
        button.setEffect(dropShadow);});

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("Button one");
        RadioButton radioButton2 = new RadioButton("Button two");
        RadioButton radioButton3 = new RadioButton("Button three");

        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        radioButton2.setSelected(true);
        radioButton1.setUserData("1");
        radioButton2.setUserData("2");
        radioButton3.setUserData("3");

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(radioButton1, radioButton2, radioButton3);

        HBox hpic = new HBox(10);
        hpic.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(new Image(getClass()
                .getResourceAsStream("/" + toggleGroup.getSelectedToggle().getUserData() + ".png")));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        hpic.getChildren().add(imageView);

        toggleGroup.selectedToggleProperty().addListener(event -> imageView.setImage(new Image(getClass()
                    .getResourceAsStream("/" + toggleGroup.getSelectedToggle().getUserData() + ".png")))

        );
        root.getChildren().addAll(button, rectangle);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(root);
        borderPane.setTop(hBox);
        borderPane.setBottom(hpic);

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
