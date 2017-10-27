/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.sevices.EmailSenderService;
import edu.esprit.pidev.sevices.SendMail;
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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class GuideMailSendingFXMLController implements Initializable {

    @FXML
    private TextArea sujet_m;
    @FXML
    private TextArea message_m;

    private String to;
    @FXML
    private Button envoi_mail_btn;
    @FXML
    private Button renit_btn;
    @FXML
    private AnchorPane panne;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void onEnvoyerClicked(MouseEvent event) {
        
        FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));
        try {
            Parent rroot = lloader.load();
        } catch (IOException ex) {
            Logger.getLogger(GuideVPListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuideguiController guiController = lloader.getController();
        SendMail.send(to, sujet_m.getText(), message_m.getText(), guiController.guidelog.getEmail(),"nannou kh 16febnk");
        Stage stage = (Stage) panne.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void OnInitClicked(MouseEvent event) {
        message_m.setText("");
        sujet_m.setText("");
    }

}
