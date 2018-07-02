package ru.smith.firsttutorial;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainImage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Image image = new Image(new FileInputStream("./src/main/resources/image.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(200);

        PixelReader pixelReader = image.getPixelReader();
        for(int i = 0; i < image.getWidth(); i++){
            for (int j = 0; j < image.getHeight(); j++){
                Color color = pixelReader.getColor(i,j);
            }
        }
        WritableImage writableImage = new WritableImage((int) image.getWidth(), (int)image.getHeight());
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        for(int i = 0; i < image.getWidth(); i++){
            for (int j = 0; j < image.getHeight(); j++){
                Color color = pixelReader.getColor(i,j);
                pixelWriter.setColor(i,j, color);
            }
        }

        ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png",
                new FileOutputStream("test.png"));
        root.getChildren().add(imageView);
        root.getChildren().add(new ImageView(writableImage));
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
