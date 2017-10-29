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
public class FXMLReserverHotelController implements Initializable {

    @FXML
    private DatePicker date_hotel_debut;
    public static DatePicker date_hotel_debut2;

    @FXML
    private DatePicker date_hotel_fin;
    public static DatePicker date_hotel_fin2;

    @FXML
    private JFXTextField ville_hotel;
    public static JFXTextField ville_hotel2;

    @FXML
    private JFXTextField prix_max_hotel;
    public static JFXTextField prix_max_hotel2;
    

    @FXML
    private JFXButton bt_chercher_hotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        date_hotel_debut2=date_hotel_debut;
        date_hotel_fin2=date_hotel_fin;
        ville_hotel2=ville_hotel;
        prix_max_hotel2=prix_max_hotel;
    }

    @FXML
    private void OnChercherHotel(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLResultatRechercheHotel.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
    }

}
