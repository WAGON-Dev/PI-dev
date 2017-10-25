/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLRechercheClientController implements Initializable {

    @FXML
    private JFXButton bt_reserver_vol;
    @FXML
    private JFXButton bt_reserver_hotel;
    @FXML
    private JFXButton bt_reserver_vo;
    @FXML
    private JFXButton bt_louer_voiture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnReserverVol(ActionEvent event) {
    }

    @FXML
    private void OnReserverHotel(ActionEvent event) {
    }

    @FXML
    private void OnReserverVOrganise(ActionEvent event) {
    }

    @FXML
    private void OnLouerVoiture(ActionEvent event) {
    }
    
}
