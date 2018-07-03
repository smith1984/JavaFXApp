package ru.smith.evil_nerd_tutorial;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JFX3 extends Application {

    Stage window;
    Scene scene1;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        Button button1 = new Button("Закрыть программу");
        button1.setPrefSize(120, 60);
        button1.setOnAction(event -> closeProgram());

        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(button1);
        scene1 = new Scene(layout1, 300, 300);


        window.setScene(scene1);
        window.setTitle("Закрытие программы");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram(){
        boolean ansver =
                ConfirmWindow.display
                        ("Закрытие программы", "Вы действительно хотите закрыть программу?");
        if (ansver){
            System.out.println("Game saved");
            window.close();
        }

    }
}
