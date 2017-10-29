/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import edu.esprit.pidev.models.Vol;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import edu.esprit.pidev.sevices.VolService;
import java.time.LocalDate;
import javafx.event.ActionEvent;
/*
import edu.esprit.pidev.models.Chambre;
import edu.esprit.pidev.sevices.ChambreService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;*/
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLResultatRechercheVolController implements Initializable {

    
    double prix = Double.parseDouble(FXMLReserverVolController.prix_vol_max.getText());
    String villedep = FXMLReserverVolController.ville_vol_depart.getText();
    String villearr = FXMLReserverVolController.ville_vol_arriver.getText();
    LocalDate ld = FXMLReserverVolController.date_vol_arriver.getValue();
    java.sql.Date da1 = java.sql.Date.valueOf(ld);
    LocalDate ld2 =FXMLReserverVolController.date_vol_depart.getValue() ;
        java.sql.Date da2 = java.sql.Date.valueOf(ld2);
    @FXML
    private ListView<Vol> liste_vol;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VolService vs = new VolService();
        Vol vol1 = new Vol();

       
        
      

        ObservableList<Vol> names = FXCollections.observableArrayList(vs.getAllcondition(prix, villedep, villearr,da1,da2));
        liste_vol.setItems(names);
        liste_vol.setCellFactory(studentListView -> new FXMLRowVolController());

        

    }


}
