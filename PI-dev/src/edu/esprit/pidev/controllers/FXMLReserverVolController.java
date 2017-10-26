/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.pidev.models.Vol;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
public class FXMLReserverVolController implements Initializable {

    @FXML
    private DatePicker date_depart_vol;
    public static DatePicker date_vol_depart;
    @FXML
    private DatePicker date_arriver_vol;
    public static DatePicker date_vol_arriver;
    
    @FXML
    private JFXTextField ville_depart_vol;
    public static JFXTextField ville_vol_depart;
    @FXML
    private JFXTextField ville_arriver_vol;
    public static JFXTextField ville_vol_arriver;
    private JFXTextField prix_min_vol;
    @FXML
    private JFXTextField prix_max_vol;
    
    public static JFXTextField prix_vol_max;
    @FXML
    private JFXButton bt_chercher_vol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        prix_vol_max=prix_max_vol;
        ville_vol_arriver=ville_arriver_vol;
        ville_vol_depart=ville_depart_vol;
        date_vol_arriver=date_arriver_vol;
        date_vol_depart=date_depart_vol;
    }    

    @FXML
    private void On_chercher_vol(ActionEvent event)throws IOException{
        Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLResultatRechercheVol.fxml"));
        FXMLInterfaceClientController.RootS.getChildren().clear();
        FXMLInterfaceClientController.RootS.getChildren().add(pane);
        
        
        
        
        
        
    }
    public  Vol TestDonne(){
        
        LocalDate localDate1 = date_depart_vol.getValue();
        LocalDate  localDate2 = date_arriver_vol.getValue();
        
        Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String ville_depart =ville_depart_vol.getText();
        String ville_arriver =ville_arriver_vol.getText();
        int prix_min = Integer.parseInt(prix_min_vol.getText());
        int prix_max = Integer.parseInt(prix_max_vol.getText());
        
        Vol vol=new Vol(date1, date2, Double.parseDouble(String.valueOf(prix_min)), "", 0, ville_depart, ville_arriver, "");
        return vol;
    }
    
}
