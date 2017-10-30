/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Car;
import edu.esprit.pidev.models.VoyageOrganise;
import edu.esprit.pidev.sevices.CarService;
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
public class FXMLResultatRechercheVoitureController implements Initializable {

    @FXML
    private ListView<Car> list_voiture;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CarService cs = new CarService();
        ObservableList<Car> names = FXCollections.observableArrayList(cs.FindByRateAndAdress(Integer.parseInt(FXMLLouerVoitureController.prix_min.getText()), Integer.parseInt(FXMLLouerVoitureController.prix_max.getText()),FXMLLouerVoitureController.ville.getText()));
        list_voiture.setItems(names);
        list_voiture.setCellFactory(studentListView -> new FXMLRowResultatListeVoitureController());
    }

}
