/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.sevices.ClientService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

        Client cl = new Client();
        ClientService cs = new ClientService();

        cl = cs.findByemail("wajdy.bouslama@esprit.tn");
        nom_p_menu_bar.setText(cl.getNom() + " " + cl.getPrenom());
        mail_menu_bar.setText(cl.getEmail());
        File file = new File(cl.getImage());
        Image img = new Image(file.toURI().toString());
        image_menu_bar.setImage(img);
    }

    @FXML
    private void On_Compte_menu_bar(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLCompteClient.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
    }

    @FXML
    private void OnRechercherMenuBar(ActionEvent event) throws IOException {
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
