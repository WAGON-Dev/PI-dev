/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.utils;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Asus
 */
public class MoviePlayer extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        File file = new File("src/edu/esprit/pidev/utils/thomas.mp4");
        String MEDIA_URL = file.toURI().toString();
        Media media = new Media(MEDIA_URL);
        MediaPlayer player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        root.getChildren().add(view);
        Scene scene = new Scene(root, 400, 400, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        player.play();
    }
}
