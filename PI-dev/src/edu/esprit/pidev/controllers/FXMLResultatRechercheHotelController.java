/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Chambre;
import edu.esprit.pidev.sevices.ChambreService;
import java.net.URL;
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
    private ListView<Chambre > liste_hotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChambreService vs = new ChambreService();
        Chambre vo = new Chambre();
        ObservableList<Chambre> names = FXCollections.observableArrayList(vs.getAll());
        liste_hotel.setItems(names);
        liste_hotel.setCellFactory(studentListView -> new FXMLRowHotelController());
    }    
    
}
