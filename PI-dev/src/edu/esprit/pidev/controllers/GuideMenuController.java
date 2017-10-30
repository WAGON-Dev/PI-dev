/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.sevices.GuideService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class GuideMenuController implements Initializable {

    @FXML
    private BorderPane menupane;
    @FXML
    private ImageView imgv_menu;
    @FXML
    private Button profile_menu_btn;
    @FXML
    private Button modifier_menu_btn;
    @FXML
    private Button vp_menu_button;
    @FXML
    private Label nom_guide_menu;
    @FXML
    private Label guide_menu_prenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GuideService gs = new GuideService();
        Guide g = gs.findByEmail("jemaighass@gmail.com");
        File file = new File("C:/Users/Ghassen/Desktop/Cours/4INFO/PI/PI-dev/PI-dev/src/edu/esprit/pidev/utils/" + g.getImage());
        Image img = new Image(file.toURI().toString());
        imgv_menu.setImage(img);
        nom_guide_menu.setText(g.getNom());
        guide_menu_prenom.setText(g.getPrenom());
    }

    @FXML
    private void profile_m_clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));

        Parent root = loader.load();

        GuideguiController profileController = loader.getController();

        imgv_menu.getScene().setRoot(root);
    }

    @FXML
    private void modif_menu_clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GuideModificationgui.fxml"));

        Parent root = loader.load();

        GuideModificationguiController modifController = loader.getController();

        FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));

        Parent rroot = lloader.load();

        GuideguiController guiController = lloader.getController();

        modifController.setNom_modif(guiController.guidelog.getNom());
        modifController.setPrenom_modif(guiController.guidelog.getPrenom());
        modifController.setAdresse_modif(guiController.guidelog.getAdresse());
        modifController.setEmail_modif(guiController.guidelog.getEmail());
        modifController.setPwd_modif(guiController.guidelog.getMdp());
        modifController.setCin_modif(String.valueOf(guiController.guidelog.getCIN()));
        modifController.setNumtel_modif(String.valueOf(guiController.guidelog.getNumtel()));

        imgv_menu.getScene().setRoot(root);

    }

    @FXML
    private void vp_menu_clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GuideVPList.fxml"));

        Parent root = loader.load();

        GuideVPListController modifController = loader.getController();

        imgv_menu.getScene().setRoot(root);
    }

}
