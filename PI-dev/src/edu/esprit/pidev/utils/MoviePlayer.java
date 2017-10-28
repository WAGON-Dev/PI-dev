/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.utils;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;

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

        final Timeline slidIn = new Timeline();
        final Timeline slidOut = new Timeline();
        root.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slidIn.play();
            }

        });
        root.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slidOut.play();
            }

        });
        final VBox vbox = new VBox();
        Slider slider = new Slider();

        vbox.getChildren().add(slider);

        final HBox hbox = new HBox(2);
        final int bands = player.getAudioSpectrumNumBands();
        final Rectangle[] rects = new Rectangle[bands];
        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle();
            rects[i].setFill(Color.GREENYELLOW);
            hbox.getChildren().add(rects[i]);
        }
        vbox.getChildren().add(hbox);
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

                hbox.setMinWidth(w);
                int bandWith = w / rects.length;
                for (Rectangle r : rects) {
                    r.setWidth(bandWith);
                    r.setHeight(2);
                }

                primaryStage.setMinWidth(w);
                primaryStage.setMinHeight(h);

                vbox.setMinSize(w, 100);
                vbox.setTranslateY(h - 45);

                slider.setMin(0.0);
                slider.setValue(0.0);
                slider.setMax(player.getTotalDuration().toSeconds());

                slidIn.getKeyFrames().addAll(
                        new KeyFrame(new Duration(0),
                                new KeyValue(vbox.translateYProperty(), h),
                                new KeyValue(vbox.opacityProperty(), 0.0)
                        ),
                        new KeyFrame(new Duration(300),
                                new KeyValue(vbox.translateYProperty(), h-100),
                                new KeyValue(vbox.opacityProperty(), 0.9)
                        )
                );
                slidOut.getKeyFrames().addAll(
                        new KeyFrame(new Duration(0),
                                new KeyValue(vbox.translateYProperty(), h-100),
                                new KeyValue(vbox.opacityProperty(), 0.9)
                        ),
                        new KeyFrame(new Duration(300),
                                new KeyValue(vbox.translateYProperty(), h),
                                new KeyValue(vbox.opacityProperty(), 0.0)
                        )
                );
            }
        });
        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration current) {
                slider.setValue(current.toSeconds());
            }
        });
        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player.seek(Duration.seconds(slider.getValue()));
            }
        });
        player.setAudioSpectrumListener(new AudioSpectrumListener() {
            @Override
            public void spectrumDataUpdate(double timestamp, double duration, float[] mags, float[] phases) {
                for (int i = 0; i < rects.length; i++) {
                    double h = mags[i] + 60;
                    if (h > 2) {
                        rects[i].setHeight(h);
                    }
                }
            }
        });
    }
}
