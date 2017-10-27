/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.sevices.VoyagePersonaliseService;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLModifier_VPController implements Initializable {

    @FXML
    private TableView<VoyagePersonalise> table_vp;
    @FXML
    private TableColumn<VoyagePersonalise, String> nom;
    @FXML
    private TableColumn<VoyagePersonalise, String> ville_depart;
    @FXML
    private TableColumn<VoyagePersonalise, String> ville_arrive;
    @FXML
    private TableColumn<VoyagePersonalise, Date> date_depart;
    @FXML
    private TableColumn<VoyagePersonalise, Date> date_retour;
    @FXML
    private TableColumn<VoyagePersonalise, Integer> nbr_participant;
    @FXML
    private TableColumn<VoyagePersonalise, String> hotel;
    @FXML
    private JFXTextField nom1;
    @FXML
    private JFXTextField ville_depart1;
    @FXML
    private JFXTextField ville_arrive1;
    @FXML
    private JFXTextField nbr_participant1;
    @FXML
    private JFXTextField hotel1;
    @FXML
    private JFXDatePicker Date_depart;
    @FXML
    private JFXDatePicker date_retour1;

    private ObservableList<VoyagePersonalise> Liste_VP = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click(MouseEvent event) {
        if (table_vp.getSelectionModel().getSelectedItem() != null) {
            VoyagePersonalise selectedVP = table_vp.getSelectionModel().getSelectedItem();
            nom1.setText(selectedVP.getNom());
            ville_depart1.setText(selectedVP.getVille_depart());
            ville_arrive1.setText(selectedVP.getVille_arrive());

            Date d = selectedVP.getDate_depart();
            LocalDate ld = d.toLocalDate();
            Date_depart.setValue(ld);

            Date d1 = selectedVP.getDate_arrive();
            LocalDate ld1 = d1.toLocalDate();
            date_retour1.setValue(ld1);

            nbr_participant1.setText(Integer.toString(selectedVP.getNbr_participant()));
            hotel1.setText(selectedVP.getHotel().getNom());

        }
    }

    @FXML
    private void afficher_vp(ActionEvent event) {
        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        VoyagePersonalise vp1 = new VoyagePersonalise();

        //ClientService cs = new ClientService();
        //vp1.setClient(ClientService.loggedUser);
        Liste_VP = FXCollections.observableArrayList(vps.getAll2(ClientService.loggedUser));

        id.setCellValueFactory(new PropertyValueFactory<>("id_vp"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ville_depart.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
        ville_arrive.setCellValueFactory(new PropertyValueFactory<>("ville_arrive"));
        date_depart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        date_retour.setCellValueFactory(new PropertyValueFactory<>("date_arrive"));
        nbr_participant.setCellValueFactory(new PropertyValueFactory<>("nbr_participant"));
        hotel.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyagePersonalise, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<VoyagePersonalise, String> param) {
                return new SimpleStringProperty(param.getValue().getHotel().getNom());
            }

        });

        table_vp.setItems(Liste_VP);

        table_vp.getColumns().get(0).setVisible(false);
        table_vp.getColumns().get(0).setVisible(true);
    }

    @FXML
    private void modifier(ActionEvent event) {
        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        if (table_vp.getSelectionModel().getSelectedItem() != null) {
            VoyagePersonalise selectedVP = table_vp.getSelectionModel().getSelectedItem();
            VoyagePersonalise vp = new VoyagePersonalise();
            vp = vps.findById(selectedVP.getId_vp());
            vp.setNom(nom1.getText());
            vp.setVille_depart(ville_depart1.getText());
            vp.setVille_arrive(ville_arrive1.getText());
            vp.setNbr_participant(Integer.parseInt(nbr_participant1.getText()));
            HotelService hs = new HotelService();
            vp.setHotel(hs.findById(Integer.parseInt(hotel1.getText())));
            LocalDate ld1 = Date_depart.getValue();
            vp.setDate_depart(Date.valueOf(ld1));
            LocalDate ld = date_retour1.getValue();
            vp.setDate_arrive(Date.valueOf(ld));
            vps.update(vp);

        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        if (table_vp.getSelectionModel().getSelectedItem() != null) {
            VoyagePersonalise selectedVP = table_vp.getSelectionModel().getSelectedItem();
            vps.remove(selectedVP.getId_vp());
        }

    }
}
