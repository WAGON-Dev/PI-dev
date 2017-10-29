/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.itextpdf.text.Anchor;
import edu.esprit.pidev.models.Car;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Demande;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.DemandeService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class FXMLRowResultatListeVoitureController extends ListCell<Car>{

    @FXML
    private Label reg_num_label;
    @FXML
    private Label modele_label;
    @FXML
    private Label prix_label;
    @FXML
    private ImageView agl_photo;
    @FXML
    private Label nom_agl_label;
    @FXML
    private Label numtel_label;
    @FXML
    private Rating rating_stars;
    @FXML
    private Label mail_sending_label;
    @FXML
    private Button reserver_btn;
    @FXML
    private Button annuler_btn;
    @FXML
    private Label state;
    @FXML
    private AnchorPane cell;
    
    private FXMLLoader mLLoader;

    /**
     * Initializes the controller class.
     */
      protected void updateItem(Car student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../gui/FXMLRowResultatListeVoiture.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            reg_num_label.setText(student.getModel());
            prix_label.setText(String.valueOf(student.getRate()));
            modele_label.setText(student.getRegNo());
            nom_agl_label.setText(student.getCarRentalID().getNom());
            numtel_label.setText(String.valueOf(student.getCarRentalID().getNumtel()));
            rating_stars.setRating(student.getCarRentalID().getStars());
            File file = new File("C:/Users/Ghassen/Desktop/Cours/4INFO/PI/PI-dev/PI-dev/src/edu/esprit/pidev/utils/" + student.getCarRentalID().getImage());
            Image img = new Image(file.toURI().toString());
            agl_photo.setImage(img);
            state.setText("");
            setText(null);
            setGraphic(cell);
        }
    }
    @FXML
    private void mail_sending_label_clicked(MouseEvent event) {
    }

    @FXML
    private void reserver_btn_clicked(MouseEvent event) {
    }

    @FXML
    private void annuler_btn_clicked(MouseEvent event) {
    }
    
}
