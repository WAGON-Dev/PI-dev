/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.utils;

import java.io.File;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 *
 * @author Asus
 */
public class MoviePlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Voyage organisé");
        Group root = new Group();
        File file = new File("src/edu/esprit/pidev/utils/thomas.mp4");
        String MEDIA_URL = file.toURI().toString();
        Media media = new Media(MEDIA_URL);
        MediaPlayer player = new MediaPlayer(media);
        MediaView view = new MediaView(player);

        final VBox vbox = new VBox();
        Slider slider = new Slider();

        vbox.getChildren().add(slider);
        root.getChildren().add(view);
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 400, 400, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        player.play();
        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                primaryStage.setMinWidth(w);
                primaryStage.setMinHeight(h);

                vbox.setMinSize(w, 100);
                vbox.setTranslateY(h - 45);
                
                slider.setMin(0.0);
                slider.setValue(0.0);
                slider.setMax(player.getTotalDuration().toSeconds());
            }
        });
        player.currentTimeProperty().addListener(new ChangeListener<Duration>(){
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration current) {
                slider.setValue(current.toSeconds());
            }
        });
        slider.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                player.seek(Duration.seconds(slider.getValue()));
            }
        
        
        
        });
    

    }
}
