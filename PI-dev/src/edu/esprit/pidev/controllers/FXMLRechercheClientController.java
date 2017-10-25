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
import javafx.scene.layout.Pane;


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
    private void OnReserverVol(ActionEvent event)throws IOException{
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLReserverVol.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
        
    }

    @FXML
    private void OnReserverHotel(ActionEvent event) throws IOException{
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLReserverHotel.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
    }

    @FXML
    private void OnReserverVOrganise(ActionEvent event)throws IOException{
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLRecherchVoyageOrganise.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
    }

    @FXML
    private void OnLouerVoiture(ActionEvent event) throws IOException{
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLLouerVoiture.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
    }
    
}
