/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXTextField;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.EmailSenderService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLMail_VPController implements Initializable {

    @FXML
    private JFXTextField passw;
    @FXML
    private JFXTextField msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
         EmailSenderService emailS = new EmailSenderService();
        String[] to = {"ahmed.benamribettaieb@esprit.tn"};
        Client c = new Client();
        c = ClientService.loggedUser;
        String adresse = ClientService.loggedUser.getEmail();
        String subject = "offre d'emplois pour guide";
        String message = msg.getText();
        if (emailS.sendMail(adresse, passw.getText(), message, subject, to)) {
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.initOwner(adresse.getScene().getWindow());
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Email Envoyer Avec Succées ");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {

            }
        });
    }
    
}
