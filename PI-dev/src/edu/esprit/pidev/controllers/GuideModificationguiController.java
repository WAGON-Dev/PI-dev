/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXDrawer;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.sevices.GuideService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class GuideModificationguiController implements Initializable {

    @FXML
    private AnchorPane guide_modification_gui;
    @FXML
    private JFXDrawer menu;
    @FXML
    private ImageView imagev_modif;
    @FXML
    private Label photo_changer;
    @FXML
    private DatePicker date_modif;
    @FXML
    private PasswordField pwd_modif;
    @FXML
    private PasswordField pwdverif_modif;
    @FXML
    private Button confirm_btn;
    @FXML
    private Button renitialiser_btn;
    @FXML
    private TextField nom_modif;
    @FXML
    private TextField prenom_modif;
    @FXML
    private TextField cin_modif;
    @FXML
    private TextField numtel_modif;
    @FXML
    private TextField email_modif;
    @FXML
    private TextField adresse_modif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        GuideService gs = new GuideService();
        Guide g = gs.findByEmail("jemaighass@gmail.com");
        File file = new File("C:/Users/Ghassen/Desktop/Cours/4INFO/PI/PI-dev/PI-dev/src/edu/esprit/pidev/utils/" + g.getImage());
        Image img = new Image(file.toURI().toString());
        imagev_modif.setImage(img);
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

    @FXML
    private void photo_changer_mouse_out(MouseEvent event) {

        imagev_modif.getStyleClass().add("label");
    }

    @FXML
    private void photo_changer_mouse_in(MouseEvent event) {
        imagev_modif.getStyleClass().add("custom_label");
    }

    @FXML
    private void photo_changer_mouse_clicked(MouseEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imagev_modif.setImage(image);

        } else {
            System.out.println("file invalid ");
        }
    }

    @FXML
    private void confirm_mod_clicked(MouseEvent event) throws IOException {
        if (adresse_modif == null || cin_modif == null || date_modif == null || email_modif == null || nom_modif == null || pwd_modif == null || prenom_modif == null || pwdverif_modif == null) {
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Completer tous les champs !");
            tray.showAndDismiss(Duration.seconds(3));

        } else {
            String em = email_modif.getText();
            if (!(em.indexOf("@") >= 0)) {
                TrayNotification tray = new TrayNotification();
                tray.setTitle("Email invalide !");
                tray.showAndDismiss(Duration.seconds(3));
            } else {
                if (pwd_modif.getText().equals(pwdverif_modif.getText())) {
                    FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));

                    Parent rroot = lloader.load();

                    GuideguiController guiController = lloader.getController();

                    guiController.guidelog.setNom(nom_modif.getText());
                    guiController.guidelog.setPrenom(prenom_modif.getText());
                    guiController.guidelog.setAdresse(adresse_modif.getText());
                    guiController.guidelog.setCIN(cin_modif.getText());
                    guiController.guidelog.setNumtel(Integer.parseInt(numtel_modif.getText()));
                    LocalDate localDate2 = date_modif.getValue();
                    Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    guiController.guidelog.setDateDeNaissance(date2);
                    GuideService gs = new GuideService();
                    gs.update2(guiController.guidelog);
                    TrayNotification tray = new TrayNotification();
                    tray.setTitle("Modification effectuée");
                    tray.setMessage("Vos informations sont modifiés !");
                    tray.showAndDismiss(Duration.seconds(3));

                } else {
                    TrayNotification tray = new TrayNotification();
                    tray.setTitle("Verification non effectuée !");
                    tray.setMessage("Verifier votre mot de passe.");
                    tray.showAndDismiss(Duration.seconds(3));
                }
            }
        }
    }

    @FXML
    private void renitialize_mod_clicked(MouseEvent event) throws IOException {
        FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));

        Parent rroot = lloader.load();

        GuideguiController guiController = lloader.getController();

        nom_modif.setText(guiController.guidelog.getNom());
        prenom_modif.setText(guiController.guidelog.getPrenom());
        adresse_modif.setText(guiController.guidelog.getAdresse());
        email_modif.setText(guiController.guidelog.getEmail());
        pwd_modif.setText(guiController.guidelog.getMdp());
        cin_modif.setText(String.valueOf(guiController.guidelog.getCIN()));
        numtel_modif.setText(String.valueOf(guiController.guidelog.getNumtel()));
    }

    public void setDate_modif(DatePicker date_modif) {
        this.date_modif = date_modif;
    }

    public void setPwd_modif(String pwd_modif) {
        this.pwd_modif.setText(pwd_modif);
    }

    public void setNom_modif(String nom_modif) {
        this.nom_modif.setText(nom_modif);
    }

    public void setPrenom_modif(String prenom_modif) {
        this.prenom_modif.setText(prenom_modif);
    }

    public void setCin_modif(String cin_modif) {
        this.cin_modif.setText(cin_modif);
    }

    public void setNumtel_modif(String numtel_modif) {
        this.numtel_modif.setText(numtel_modif);
    }

    public void setEmail_modif(String email_modif) {
        this.email_modif.setText(email_modif);
    }

    public void setAdresse_modif(String adresse_modif) {
        this.adresse_modif.setText(adresse_modif);
    }

    @FXML
    private void photo_label_clicked(MouseEvent event) {
        FileChooser fc = new FileChooser();
//        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.jpg","*.png","*.gif"));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imagev_modif.setImage(image);

        } else {
            System.out.println("file invalid ");
        }
    }

    @FXML
    private void photo_clicked(MouseEvent event) {
        FileChooser fc = new FileChooser();
//        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.jpg","*.png","*.gif"));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imagev_modif.setImage(image);
        } else {
            System.out.println("file invalid ");
        }
    }

}
