package ru.smith.next_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main_6 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My window");

        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(70);

        SepiaTone sepiaTone = new SepiaTone();
        Image image = new Image(getClass().getResourceAsStream("/Castle.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(450);
        imageView.setFitWidth(580);
        imageView.setEffect(sepiaTone);
        GridPane.setConstraints(imageView, 0, 0);
        GridPane.setColumnSpan(imageView, 3);

        Label opacityLabel = new Label("Opacity");
        GridPane.setConstraints(opacityLabel, 0, 1);

        Label sepiaLabel = new Label("Sepia");
        GridPane.setConstraints(sepiaLabel, 0, 2);

        Label sizelabel = new Label("Size");
        GridPane.setConstraints(sizelabel, 0, 3);

        Slider opacitySlider = new Slider(0, 1, 1);
        GridPane.setConstraints(opacitySlider, 1,1);

        Slider sepiaSlider = new Slider(0, 1, 1);
        GridPane.setConstraints(sepiaSlider, 1,2);

        Slider sizeSlider = new Slider(0,1, 1);
        GridPane.setConstraints(sizeSlider, 1,3);

        Label opacityValue = new Label(String.format("%.2f",opacitySlider.getValue()));
        GridPane.setConstraints(opacityValue, 2, 1);

        Label sepiaValue = new Label(String.format("%.2f",sepiaSlider.getValue()));
        GridPane.setConstraints(sepiaValue, 2, 2);

        Label sizeValue = new Label(String.format("%.2f",sizeSlider.getValue()));
        GridPane.setConstraints(sizeValue, 2, 3);

        opacitySlider.valueProperty().addListener((v, oldV, newV) ->{
            imageView.setOpacity(newV.doubleValue());
            opacityValue.setText(String.format("%.2f", newV));
        });

        sepiaSlider.valueProperty().addListener((v, oldV, newV) ->{
            sepiaTone.setLevel(newV.doubleValue());
            sepiaValue.setText(String.format("%.2f", newV));
        });

        sizeSlider.valueProperty().addListener((v, oldV, newV) ->{
            imageView.setScaleX(newV.doubleValue());
            imageView.setScaleY(newV.doubleValue());
            sizeValue.setText(String.format("%.2f", newV));
        });

        Tooltip tooltip = new Tooltip("THIS IS TOOLTIP");
        Tooltip tooltip1 = new Tooltip("THIS IS TOOLTIP FOR LABEL");

        Label label = new Label("It is Label");
        label.setTooltip(tooltip1);
        GridPane.setConstraints(label, 1, 4);
        Button btn = new Button("Click me");
        btn.setTooltip(tooltip);
        GridPane.setConstraints(btn, 0,4);

        ProgressBar progressBar = new ProgressBar(0);
        ProgressIndicator progressIndicator = new ProgressIndicator(0);
        Slider slider = new Slider(0,100, 0);
        GridPane.setConstraints(slider, 0, 5);
        GridPane.setConstraints(progressBar, 1, 5);
        GridPane.setConstraints(progressIndicator, 2, 5);

        slider.valueProperty().addListener((v, oldValue, newValue) ->{
            progressBar.setProgress((double)newValue/100);
            progressIndicator.setProgress((double)newValue/100);
        });

        root.getChildren().addAll(imageView, opacityLabel, sepiaLabel, sizelabel, opacitySlider, sepiaSlider,
                sizeSlider, opacityValue, sepiaValue, sizeValue, btn, label, slider, progressBar, progressIndicator);
        Scene scene = new Scene(root, 600, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}