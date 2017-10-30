/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author zakiya
 */
public class AccueilAgenceController implements Initializable {

    @FXML
    private JFXButton GestVoy;
    @FXML
    private JFXButton statistiques;
    @FXML
    private AnchorPane Fond0;
    @FXML
    private JFXButton ClientInterf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GestVoyBut(ActionEvent event) {
        try{
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/testTableau.fxml"));
            System.out.println("pathgood");
          
          Parent root = fxmlLoader.load();
                    TestTableauController cntrl = fxmlLoader.getController();
                    Fond0.getScene().setRoot(root);

            /*Fond0.getChildren().clear();
            System.out.println("cleared");
            Fond0.getChildren().add(pane); */           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void Statistiquesbut(ActionEvent event) {
     try{
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("statistiques.fxml"));
            System.out.println("pathgood");
          
          Parent root = fxmlLoader.load();
                    StatistiquesController cntrl = fxmlLoader.getController();
                    Fond0.getScene().setRoot(root);

            /*Fond0.getChildren().clear();
            System.out.println("cleared");
            Fond0.getChildren().add(pane); */           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ClientInterfac(ActionEvent event) {
  
    } 
}


   
