/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXDrawer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLInterfaceClientController implements Initializable {

    @FXML
    private JFXDrawer menu_bar;
    @FXML
    private Pane scene_pricipal;
    public static Pane RootS;
    @FXML
    private ImageView logo_go_voyage;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RootS = scene_pricipal;
        try {
            VBox Vbox = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLMenuBar.fxml"));
            menu_bar.setSidePane(Vbox);

        } catch (IOException ex) {
        }
        try {
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLRechercheClient.fxml"));
            scene_pricipal.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
        }

        translationLogo();
    }

    @FXML
    private void OpenMenu(MouseEvent event) {
        if (menu_bar.isShown()) {
            menu_bar.close();
        }
    }

    @FXML
    private void ExitMenu(MouseEvent event) {
        menu_bar.open();

    }
public void translationLogo() {
        FadeTransition lettreTransin = new FadeTransition(Duration.seconds(2), logo_go_voyage);
        lettreTransin.setFromValue(0);
        lettreTransin.setToValue(1);
        lettreTransin.setCycleCount(1);
        lettreTransin.play();

        FadeTransition lettreTransOut = new FadeTransition(Duration.seconds(2), logo_go_voyage);
        lettreTransOut.setFromValue(1);
        lettreTransOut.setToValue(0);
        lettreTransOut.setCycleCount(1);

        lettreTransin.setOnFinished((e) -> {
            lettreTransOut.play();
        });

        lettreTransOut.setOnFinished((e) -> {
            lettreTransin.play();
        });
    }
}

