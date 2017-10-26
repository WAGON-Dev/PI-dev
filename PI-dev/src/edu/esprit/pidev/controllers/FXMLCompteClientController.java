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

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLCompteClientController implements Initializable {

    @FXML
    private JFXTextField nom_conecter;
    @FXML
    private JFXTextField prenom_conecter;
    @FXML
    private JFXTextField mail_conecter;
    @FXML
    private JFXTextField mdp_conecter;
    @FXML
    private JFXTextField num_tel_conecter;
    @FXML
    private JFXTextField adresse_conecter;
    @FXML
    private JFXButton bt_modifier_conecter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnModifierConecter(ActionEvent event) {
    }
    
}
