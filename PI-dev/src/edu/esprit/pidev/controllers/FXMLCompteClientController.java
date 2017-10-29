/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.sevices.ClientService;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLCompteClientController implements Initializable {

    @FXML
    private JFXTextField nom_conecter;
    @FXML
    private JFXTextField prenom_conecter;
    @FXML
    private JFXTextField mail_conecter;
    @FXML
    private JFXTextField mdp_conecter;
    @FXML
    private JFXTextField num_tel_conecter;
    @FXML
    private JFXTextField adresse_conecter;
    @FXML
    private JFXButton bt_modifier_conecter;
    @FXML
    private ImageView image_comte_client_modif;

    Pattern pattern;
    Matcher matcher;
    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    @FXML
    private Label ereur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClientService cs = new ClientService();
        Client c = new Client();
        c = cs.findByemail("wajdy.bouslama@esprit.tn");
        nom_conecter.setText(c.getNom());
        prenom_conecter.setText(c.getPrenom());
        mail_conecter.setText(c.getEmail());
        mdp_conecter.setText(c.getMdp());
        adresse_conecter.setText(c.getAdresse());
        num_tel_conecter.setText(c.getRole());
        File file = new File(c.getImage());
        Image img = new Image(file.toURI().toString());
        image_comte_client_modif.setImage(img);

    }

    @FXML
    private void OnModifierConecter(ActionEvent event) {
        Client c = new Client();
        ClientService cs = new ClientService();
        if (nom_conecter.getText() == null) {
            c.setNom(nom_conecter.getText());
            ereur.setText("Veuiller remplir le nom ");
            return;
        }
        if (prenom_conecter.getText() == null) {
            c.setPrenom(prenom_conecter.getText());
            ereur.setText("Veuiller remplir le prenom ");
            return;
        }
        if (adresse_conecter.getText() == null) {
            c.setAdresse(adresse_conecter.getText());
            ereur.setText("Veuiller remplir l'adresse ");
            return;
        }
        if (mdp_conecter.getText() == null) {
            c.setMdp(mdp_conecter.getText());
            ereur.setText("Veuiller remplir le mot de passe ");
            return;
        }
        if (adresse_conecter.getText()==null) {
            c.setEmail("wajdy.bouslama@esprit.tn");
            ereur.setText("Veuiller remplir votre adresse mail ");
            return;
        }
        if (num_tel_conecter.getText() == null) {
            c.setRole(num_tel_conecter.getText());
            ereur.setText("Veuiller remplir le numero de telephone ");
            return;
        }
        cs.update(c);
         TrayNotification tray = new TrayNotification();
        tray.setTitle("Modification effectué");
        tray.showAndDismiss(Duration.seconds(2));

    }

    @FXML
    private void OnModifImageClient(MouseEvent event) {
        FileChooser fc = new FileChooser();
        Client c = new Client();
        ClientService cs = new ClientService();
        c = cs.findByemail("wajdy.bouslama@esprit.tn");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            image_comte_client_modif.setImage(image);
            c.setImage(selectedFile.toURI().toString().substring(6));
            cs.update(c);

        } else {
            System.out.println("file invalid ");
        }
    }

}
