/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Vol;
import edu.esprit.pidev.models.VoyageOrganise;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLResultatRecherchVOController implements Initializable {

    @FXML
    private TableView<VoyageOrganise> table_vo;
    @FXML
    private TableColumn<VoyageOrganise, String> TitreVO;
    @FXML
    private TableColumn<VoyageOrganise, String> date_debut;
    @FXML
    private TableColumn<VoyageOrganise, String> date_fin;
    @FXML
    private TableColumn<VoyageOrganise, Integer> prix_vo;
    @FXML
    private TableColumn<VoyageOrganise, String> description_vo;

    
    float prix = Integer.parseInt(FXMLRecherchVoyageOrganiseController.prix_vo_max.getText());
    LocalDate ld = FXMLRecherchVoyageOrganiseController.date_vo_debut.getValue();
    java.sql.Date da1 = java.sql.Date.valueOf(ld);
    LocalDate ld2 =FXMLRecherchVoyageOrganiseController.date_vo_fin.getValue();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*VoyageOrganise
        final ObservableList<VoyageOrganise> names = FXCollections.observableArrayList(vs.getAllcondition(prix, villedep, villearr,da1,da2));*/
    }    
    
}
