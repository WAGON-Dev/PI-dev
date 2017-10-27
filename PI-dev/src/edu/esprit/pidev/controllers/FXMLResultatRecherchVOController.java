/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.VoyageOrganise;
import edu.esprit.pidev.sevices.VoyageOrganiseService;
import edu.esprit.pidev.utils.MoviePlayer;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLResultatRecherchVOController implements Initializable {

    float prix = Integer.parseInt(FXMLRecherchVoyageOrganiseController.prix_vo_max.getText());
    LocalDate ld = FXMLRecherchVoyageOrganiseController.date_vo_debut.getValue();
    java.sql.Date da1 = java.sql.Date.valueOf(ld);
    LocalDate ld2 =FXMLRecherchVoyageOrganiseController.date_vo_fin.getValue();
    java.sql.Date da2 = java.sql.Date.valueOf(ld2);
    @FXML
    private ListView<VoyageOrganise> listeVO;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VoyageOrganiseService vs = new VoyageOrganiseService();
        VoyageOrganise vo = new VoyageOrganise();

        System.out.println(vs.getAllcondition(da1, da2, prix));
        System.err.println("aaaaa");
        ObservableList<VoyageOrganise> names = FXCollections.observableArrayList(vs.getAllcondition(da1, da2, prix));
        listeVO.setItems(names);
        listeVO.setCellFactory(studentListView -> new FXMLRowListeVOController());
    }

    @FXML
    private void OnVisualiserVoyageOrganiser(MouseEvent event)throws Exception {
        Stage primaryStage = new Stage();
        MoviePlayer mp = new MoviePlayer();
        mp.start(primaryStage);
    }

}
