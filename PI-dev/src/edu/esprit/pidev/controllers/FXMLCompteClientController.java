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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClientService cs = new ClientService();
        Client c = new Client();
        c=cs.findByemail("wajdy.bouslama@esprit.tn");
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
        c.setNom(nom_conecter.getText());
        c.setPrenom(prenom_conecter.getText());
        c.setAdresse(adresse_conecter.getText());
        c.setMdp(mdp_conecter.getText());
        c.setEmail("wajdy.bouslama@esprit.tn");
        c.setRole(num_tel_conecter.getText());
        cs.update(c);
        
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
