/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLLouerVoitureController implements Initializable {

    @FXML
    private DatePicker date_debut_voiture;
    @FXML
    private DatePicker date_fin_voiture;
    @FXML
    private JFXButton bt_chercher_voiture;
    @FXML
    private JFXTextField ville_voiture;

    @FXML
    private JFXTextField prix_min_voiture;
    @FXML
    private JFXTextField prix_max_voiture;

    public static JFXTextField prix_max;
    public static JFXTextField prix_min;
    public static JFXTextField ville;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ville = ville_voiture;
        prix_max = prix_max_voiture;
        prix_min = prix_min_voiture;
    }

    @FXML
    private void OnChercherVoiture(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLResultatRechercheVoiture.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);

    }

}
