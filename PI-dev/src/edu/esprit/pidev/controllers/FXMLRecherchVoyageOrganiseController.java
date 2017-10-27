/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLRecherchVoyageOrganiseController implements Initializable {

    @FXML
    private DatePicker date_debut_vo;
    
    public static DatePicker date_vo_debut;
    @FXML
    private DatePicker date_fin_vo;
    public static DatePicker date_vo_fin;
    @FXML
    private JFXTextField prix_max_vo;
    public static JFXTextField prix_vo_max;
    @FXML
    private JFXButton bt_chercher_vo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        date_vo_debut=date_debut_vo;
        date_vo_fin=date_fin_vo;
        prix_vo_max=prix_max_vo;
    }    

    @FXML
    private void OnChercherVO(ActionEvent event)throws IOException{
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLResultatRecherchVO.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
    }
    
}
