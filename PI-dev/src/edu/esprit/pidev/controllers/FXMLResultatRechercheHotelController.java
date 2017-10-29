/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Chambre;
import edu.esprit.pidev.sevices.ChambreService;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLResultatRechercheHotelController implements Initializable {

    @FXML
    private ListView<Chambre> liste_hotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        int prix = Integer.parseInt(FXMLReserverHotelController.prix_max_hotel2.getText());
      /*  LocalDate ld = FXMLReserverHotelController.date_hotel_debut2.getValue();
        java.sql.Date da1 = java.sql.Date.valueOf(ld);
        LocalDate ld2 = FXMLReserverHotelController.date_hotel_fin2.getValue();
        java.sql.Date da2 = java.sql.Date.valueOf(ld2);
        String ville= FXMLReserverHotelController.ville_hotel2.getText();*/

        ChambreService vs = new ChambreService();
        Chambre vo = new Chambre();
        ObservableList<Chambre> names = FXCollections.observableArrayList(vs.getAllcondition(prix));
        liste_hotel.setItems(names);
        liste_hotel.setCellFactory(studentListView -> new FXMLRowHotelController());
    }

}
