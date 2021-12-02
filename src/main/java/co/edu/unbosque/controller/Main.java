package co.edu.unbosque.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("index"));
        scene.setFill(Color.TRANSPARENT);
        stage.getIcons().add(
                new Image(
                        String.valueOf(
                                getClass().getResource(
                                        packageS("icons/1.png"))
                        )
                )
        );
        stage.setTitle("Backtracking, (Rama y Poda)");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(
                packageS(fxml) + ".fxml"));
        return fxmlLoader.load();
    }

    public static String packageS(String text) {
        return "/" + text;
    }

    public static void main(String[] args) {
        launch();
    }
}