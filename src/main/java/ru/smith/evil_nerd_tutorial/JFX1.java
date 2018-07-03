package ru.smith.evil_nerd_tutorial;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JFX1 extends Application/* implements EventHandler<ActionEvent>*/
{
    Button button;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Первое приложение JavaFx");

        button = new Button("Press me");
        //раскоментировать при использованиии интерефейса EventHandler
        //button.setOnAction(this::handle);

        //раскоментировать при использованиии внутреннего класса
        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Pressed Button");
            }
        });*/
        button.setOnAction(event -> System.out.println("Test lambda"));
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //impl EventHandler
    /*@Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button){
            System.out.println("Pressed Button");
        }

    }*/
}
