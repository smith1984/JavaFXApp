package ru.smith.firsttutorial;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class MainCharts extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        PieChart chart = new PieChart(data);
        chart.setTitle("products");

        root.getChildren().add(chart);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}