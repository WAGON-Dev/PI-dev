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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import edu.esprit.pidev.sevices.VolService;
import java.sql.SQLData;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLResultatRechercheVolController implements Initializable {

    @FXML
    private TableView<Vol> table_res_vol;

    @FXML
    private TableColumn<Vol, String> columnvdepart;
    @FXML
    private TableColumn<Vol, String> columnvarriver;
    @FXML
    private TableColumn<Vol, Integer> columnprix;
    @FXML
    private TableColumn<Vol, String> columdatearriver;
    @FXML
    private TableColumn<Vol, String> columdatedepart;
    @FXML
    private TableColumn<Vol, String> columncompagnie;
    @FXML
    private JFXButton Refresh_table_vol;
    double prix = Double.parseDouble(FXMLReserverVolController.prix_vol_max.getText());
    String villedep = FXMLReserverVolController.ville_vol_depart.getText();
    String villearr = FXMLReserverVolController.ville_vol_arriver.getText();
    LocalDate ld = FXMLReserverVolController.date_vol_arriver.getValue();
    java.sql.Date da1 = java.sql.Date.valueOf(ld);
    LocalDate ld2 =FXMLReserverVolController.date_vol_depart.getValue() ;
        java.sql.Date da2 = java.sql.Date.valueOf(ld2);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        VolService vs = new VolService();
        Vol vol1 = new Vol();

       
        
        final ObservableList<Vol> names = FXCollections.observableArrayList(vs.getAllcondition(prix, villedep, villearr,da1,da2));
        columnvdepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        columnvarriver.setCellValueFactory(new PropertyValueFactory<>("arrivee"));
        columnprix.setCellValueFactory(new PropertyValueFactory<>("prix_vol"));
        columdatearriver.setCellValueFactory(new PropertyValueFactory<>("date_arrivee"));
        columdatedepart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        columncompagnie.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));

        /* ObservableList<Vol> names2 =null;
        
        final Date d =vol1.getDate_depart();
        //names2 = names.stream().filter(vol-> vol.getDate_arrivee().before(d)).collect(Collectors.toList());
         */
        table_res_vol.setItems(names);

    }

    @FXML
    private void OnRefreshVol(ActionEvent event) {
        table_res_vol.getColumns().get(0).setVisible(false);
        table_res_vol.getColumns().get(0).setVisible(true);
    }

}
