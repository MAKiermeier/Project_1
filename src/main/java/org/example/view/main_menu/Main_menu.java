package org.example.view.main_menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Main_menu extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hallo JavaFX!");

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 300);
        stage.setMaximized(true);
        stage.setTitle("Mein erstes JavaFX Fenster");
        stage.setScene(scene);
        stage.show();
    }
    public void main_menu_launch(){
    launch();
    }
}

