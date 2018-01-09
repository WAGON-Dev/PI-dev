/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXDrawer;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.sevices.GuideService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.util.Duration;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class GuideguiController implements Initializable {

    @FXML
    private AnchorPane guidegui_first;
    @FXML
    private JFXDrawer menu;
    @FXML
    private Label first_nom_label;
    @FXML
    private Label first_prenom_label;
    @FXML
    private Label first_cin_label;
    @FXML
    private Label first_email_label;
    @FXML
    private Label first_numtel_label;
    @FXML
    private Label first_ddn_label;
    @FXML
    private Label first_adresse_label;
    @FXML
    private Label first_note_label;
    @FXML
    private ImageView imagev;

    public static Guide guidelog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GuideService gs = new GuideService();
         Guide g = gs.findByEmail(FXMLLoginUsersController.mail_login);
        guidelog = g;
        File file = new File("C:/Users/Ghassen/Desktop/Cours/4INFO/PI/PI-dev/PI-dev/src/edu/esprit/pidev/utils/" + g.getImage());
       /* Guide g = gs.findByEmail("jemaighass@gmail.com");
        guidelog = g;
        File file = new File("E:/esprit/java/NetBeansProjects/PI-dev/PI-dev/src/edu/esprit/pidev/utils/" + g.getImage());*/
        Image img = new Image(file.toURI().toString());
        imagev.setImage(img);
        first_adresse_label.setText(g.getAdresse());
        first_cin_label.setText(String.valueOf(g.getCIN()));
        first_email_label.setText(g.getEmail());
        first_nom_label.setText(g.getNom());
        first_prenom_label.setText(g.getPrenom());
        first_ddn_label.setText(String.valueOf(g.getId_user()));
        first_numtel_label.setText(String.valueOf(g.getNumtel()));
        first_note_label.setText(String.valueOf(g.getNote()));
        first_ddn_label.setText(String.valueOf(g.getDateDeNaissance().toString()));
        try {
            BorderPane menupane = FXMLLoader.load(getClass().getResource("../gui/GuideMenu.fxml"));
            menu.setSidePane(menupane);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void mouseout(MouseEvent event) {
        if (menu.isShown()) {
            menu.close();
        }
    }

    @FXML
    private void mousein(MouseEvent event) {
        menu.open();
    }

    public Guide getGuidelog() {
        return guidelog;
    }

}
