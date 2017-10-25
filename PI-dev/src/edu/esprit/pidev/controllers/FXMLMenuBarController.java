/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLMenuBarController implements Initializable {

    @FXML
    private ImageView image_menu_bar;
    @FXML
    private Label nom_p_menu_bar;
    @FXML
    private Label mail_menu_bar;
    @FXML
    private JFXButton compte_menubar;
    @FXML
    private JFXButton rechercher_menu_bar;
    @FXML
    private JFXButton VP_menu_bar;
    @FXML
    private JFXButton forum_menu_bar;
    @FXML
    private JFXButton rate_menu_bar;
    @FXML
    private JFXButton exit_menu_bar;
    @FXML
    private VBox Vbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void On_Compte_menu_bar(ActionEvent event) {
    }

    @FXML
    private void OnRechercherMenuBar(ActionEvent event) throws IOException{
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLRechercheClient.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
    }

    @FXML
    private void OnVPMenuBar(ActionEvent event) {
    }

    @FXML
    private void OnForumMenuBar(ActionEvent event) {
    }

    @FXML
    private void OnRateMenuBar(ActionEvent event) {
    }

    @FXML
    private void OnExitMenuBar(ActionEvent event) {
    }
    
}
