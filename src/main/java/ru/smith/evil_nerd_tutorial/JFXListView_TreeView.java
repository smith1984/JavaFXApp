package ru.smith.evil_nerd_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JFXListView_TreeView extends Application {

    Stage window;
    Button button;
    Scene scene;
    ListView<String> listView;
    TreeView<String> treeView;

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Расположение компонент");

        button = new Button("Выбрать");

        listView = new ListView<>();
        listView.getItems().addAll("One", "Two", "Three", "Four");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(event -> {
            for (String m : listView.getSelectionModel().getSelectedItems())
                System.out.println(m);
        });

        TreeItem<String> root, movie, cartoon;
        root = new TreeItem<>();
        root.setExpanded(true);

        movie = addChild("Кинофильмы", root);
        movie.setExpanded(true);

        addChild("Film 1", movie);
        addChild("Film 2", movie);
        addChild("Film 3", movie);
        addChild("Film 4", movie);

        cartoon = addChild("Мультфильмы", root);
        cartoon.setExpanded(true);

        addChild("MFilm 1", cartoon);
        addChild("MFilm 2", cartoon);
        addChild("MFilm 3", cartoon);
        addChild("MFilm 4", cartoon);

        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);

        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue != null)
                System.out.println(newValue.getValue());
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button, treeView);

        scene = new Scene(layout, 350, 500);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private TreeItem<String> addChild(String name, TreeItem<String> parent){
        TreeItem<String> treeItem = new TreeItem<>(name);
        parent.getChildren().addAll(treeItem);
        return treeItem;
    }

}

