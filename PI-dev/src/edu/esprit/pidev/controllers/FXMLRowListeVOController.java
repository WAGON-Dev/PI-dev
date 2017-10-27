/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.VoyageOrganise;
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
public class FXMLRowListeVOController extends ListCell<VoyageOrganise>{

    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView image_row_VO;
    @FXML
    private Label prix_row_vo;
    @FXML
    private Label destination_row_vo;
    @FXML
    private Button bt_reserver_row_vo;

    private FXMLLoader mLLoader;
    
    /**
     * Initializes the controller class.
     */
    @Override
    protected void updateItem(VoyageOrganise student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getClassLoader().getResource("edu/esprit/pidev/gui/FXMLRowListeVO.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            prix_row_vo.setText(String.valueOf(student.getDateDebutVoy()));
            destination_row_vo.setText(student.getDescription());
            File file = new File("C:/Users/Asus/Desktop/ESPRIT/4 infoB 1/Semestre 1/PI-Dev/Projet/PI-dev/PI-dev/src/edu/esprit/pidev/utils/logo.png");
            Image img = new Image(file.toURI().toString());
            image_row_VO.setImage(img);
            setText(null);
            setGraphic(pane);
            
        }

    }    

    @FXML
    private void OnReserverVO(MouseEvent event) {
    }
    
}
