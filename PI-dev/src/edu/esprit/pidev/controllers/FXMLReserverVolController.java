/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLReserverVolController implements Initializable {

    @FXML
    private DatePicker date_depart_vol;
    @FXML
    private DatePicker date_arriver_vol;
    @FXML
    private JFXTextField ville_depart_vol;
    @FXML
    private JFXTextField ville_arriver_vol;
    @FXML
    private JFXTextField prix_min_vol;
    @FXML
    private JFXTextField prix_max_vol;
    @FXML
    private JFXButton bt_chercher_vol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void On_chercher_vol(ActionEvent event) {
    }
    
}
