/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.pidev.models.Evenement;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.EvenementService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.sevices.VoyagePersonaliseService;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLAjouter_VPController implements Initializable {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField ville_depart;
    @FXML
    private JFXTextField ville_arrive;
    @FXML
    private JFXDatePicker Date_depart;
    @FXML
    private JFXDatePicker date_retour;
    @FXML
    private JFXTextField nbr_participant;
    @FXML
    private JFXTextField hotel;
    @FXML
    private JFXTextField event1_fk;
    @FXML
    private TableView<Evenement> table_event;
    @FXML
    private TableColumn<Evenement, String> evenemet;
    @FXML
    private TableColumn<Evenement, String> endroit;
    @FXML
    private TableColumn<Evenement,Date> date_evenement;
    @FXML
    private JFXButton ajouter;
    
     private ObservableList<Evenement> Liste_Event = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        VoyagePersonalise vp = new VoyagePersonalise();
        LocalDate da = Date_depart.getValue();
        vp.setDate_depart(java.sql.Date.valueOf(da));
        da = date_retour.getValue();
        vp.setDate_arrive(java.sql.Date.valueOf(da));
        vp.setNom(nom.getText());
        vp.setVille_depart(ville_depart.getText());
        vp.setVille_arrive(ville_arrive.getText());
        vp.setNbr_participant(Integer.parseInt(nbr_participant.getText()));
        HotelService hs = new HotelService();
        Hotel h = new Hotel();
        h = hs.findByName(hotel.getText());
        vp.setHotel(h);
        vp.setClient(ClientService.loggedUser);

        if ("".equals(event1_fk.getText())) {
            vps.add0(vp);
        } else {
            EvenementService es = new EvenementService();
            Evenement e = new Evenement();
            e = es.findByName(event1_fk.getText());
            vp.setEvent1(e);
            vps.add3(vp);
        }

    }

    @FXML
    private void event(ActionEvent event) {
        EvenementService es = new EvenementService();
        VoyagePersonalise vp1 = new VoyagePersonalise();

        LocalDate da = Date_depart.getValue();
        vp1.setDate_depart(java.sql.Date.valueOf(da));
        da = date_retour.getValue();
        vp1.setDate_arrive(java.sql.Date.valueOf(da));

        Liste_Event = FXCollections.observableArrayList(es.getAll_vp(vp1));

        evenemet.setCellValueFactory(new PropertyValueFactory<>("activite"));
        date_evenement.setCellValueFactory(new PropertyValueFactory<>("date_activite"));
        endroit.setCellValueFactory(new PropertyValueFactory<>("emplacement"));

        table_event.setItems(Liste_Event);

    }

    @FXML
    private void mail(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("email.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
