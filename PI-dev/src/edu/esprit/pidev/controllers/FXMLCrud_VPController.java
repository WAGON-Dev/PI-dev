/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLCrud_VPController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_vp(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/FXMLAjouter_VP.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void modifier_vp(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/FXMLModifier_VP.fxml"));
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("css_email.css");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void demande(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/FXMLDemande_VP.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
