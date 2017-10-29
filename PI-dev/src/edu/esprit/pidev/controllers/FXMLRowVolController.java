/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Chambre;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.Vol;
import edu.esprit.pidev.sevices.ChambreService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.sevices.VolService;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLRowVolController extends ListCell<Vol> {

    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView image_compagnie;
    @FXML
    private Label nom_compagnie;
    @FXML
    private Label ville_depart;
    @FXML
    private Label ville_arriver;
    @FXML
    private Label date_depart;
    @FXML
    private Label date_arriver;
    @FXML
    private Label prix_vol;
    @FXML
    private Button bt_reserver_vol;
    @FXML
    private Button bt_contacter_vol;
    
    private FXMLLoader mLLoader;

    /**
     * Initializes the controller class.
     */
    @Override
    public void updateItem(Vol student, boolean empty) {
       super.updateItem(student, empty);
        
        VolService hs = new VolService();
        
        if (empty || student == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getClassLoader().getResource("edu/esprit/pidev/gui/FXMLRowVol.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            nom_compagnie.setText(student.getNom_Compagnie());
            ville_depart.setText(student.getDepart());
            ville_arriver.setText(student.getArrivee());
            date_depart.setText(String.valueOf(student.getDate_depart()));
            date_arriver.setText(String.valueOf(student.getDate_arrivee()));
            prix_vol.setText(String.valueOf(student.getPrix_vol()));
            File file = new File("C:/Users/Asus/Desktop/ESPRIT/4 infoB 1/Semestre 1/PI-Dev/Projet/PI-dev/PI-dev/src/edu/esprit/pidev/utils/logo.png");
            Image img = new Image(file.toURI().toString());
            image_compagnie.setImage(img);
            setText(null);
            setGraphic(pane);
            
        }
    }    

    @FXML
    private void OnReserverVol(MouseEvent event) {
    
    }

    @FXML
    private void OnMailVol(MouseEvent event) {
    }
    
}
