/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import edu.esprit.pidev.models.Reservation;
import edu.esprit.pidev.sevices.ReservationService;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLReservationClientController implements Initializable {

    @FXML
    private TableView<Reservation> table_reservation;
    @FXML
    private TableColumn<Reservation, String> column_id_reservation;
    @FXML
    private TableColumn<Reservation, String> column_prix_reservation;
    @FXML
    private JFXButton bt_annuler_reservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ReservationService rs = new ReservationService();
        final ObservableList<Reservation> data = FXCollections.observableArrayList(rs.getAllByClient("wajdy.bouslama@esprit.tn"));
        column_id_reservation.setCellValueFactory(new PropertyValueFactory<>("type_reservation"));
        column_prix_reservation.setCellValueFactory(new PropertyValueFactory<>("prix"));
        table_reservation.setItems(data);
    }

    @FXML
    private void OnAnnulerReservation(ActionEvent event) {

        Reservation r = table_reservation.getSelectionModel().getSelectedItem();
        table_reservation.getItems().remove(r);
        ReservationService service = new ReservationService();
        service.remove(r.getId_reservation());
}

}
