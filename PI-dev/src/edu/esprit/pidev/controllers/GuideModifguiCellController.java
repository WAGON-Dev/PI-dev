/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Demande;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.DemandeService;
import edu.esprit.pidev.sevices.VoyagePersonaliseService;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class GuideModifguiCellController extends ListCell<VoyagePersonalise> {

    @FXML
    private ImageView image_row;
    @FXML
    private Label titre_VP_row;
    @FXML
    private Label ville_depart_row;
    @FXML
    private Label ville_arriver_row;
    @FXML
    private Label adresse_row_VP;
    @FXML
    private ImageView image_row_client;
    @FXML
    private Label nom_client_row;
    @FXML
    private Label prenom_client_row;
    @FXML
    private Label envoyer_mail_row;
    @FXML
    private Label date_debut_row;
    @FXML
    private Label date_fin_row;
    @FXML
    private Button bt_postuler_row;
    @FXML
    private Button bt_anuller_row;

    private FXMLLoader mLLoader;

    @FXML
    private AnchorPane cell;
    @FXML
    private Label state;

    private Client cls;

    public Client getCls() {
        return cls;
    }

    public void setCls(Client cls) {
        this.cls = cls;
    }

    @Override
    protected void updateItem(VoyagePersonalise student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../gui/GuideModifguiCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            titre_VP_row.setText(student.getNom());
            adresse_row_VP.setText(student.getVille_depart());
            ville_depart_row.setText(student.getVille_depart());
            ville_arriver_row.setText(student.getVille_arrive());
            date_debut_row.setText(String.valueOf(student.getDate_depart()));
            date_fin_row.setText(String.valueOf(student.getDate_arrive()));
            ClientService cs = new ClientService();
            Client c = cs.findById(student.getClient().getId_user());
            setCls(c);
            nom_client_row.setText(c.getNom());
            prenom_client_row.setText(c.getPrenom());

            FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));
            try {
                Parent rroot = lloader.load();
            } catch (IOException ex) {
                Logger.getLogger(GuideVPListController.class.getName()).log(Level.SEVERE, null, ex);
            }
            GuideguiController guiController = lloader.getController();

            Demande dem = new Demande();
            dem.setId_vp(student);
            dem.setId_client(student.getClient());
            dem.setId_guide(guiController.guidelog);
            DemandeService ds = new DemandeService();
            if (dem.equals(ds.findGuideEmail(guiController.guidelog.getEmail()))) {
                state.setText("Demande déjà envoyé");
            } else {
                state.setText("");
            }

            File file = new File("C:/Users/Ghassen/Desktop/Cours/4INFO/PI/PI-dev/PI-dev/src/edu/esprit/pidev/utils/" + c.getImage());
            Image img = new Image(file.toURI().toString());
            image_row_client.setImage(img);
            setText(null);
            setGraphic(cell);
        }
    }

    @FXML
    private void OnEnvoyerMail(MouseEvent event) {
        Parent mroot = new Parent() {
        };
        FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));
        try {
            Parent rroot = lloader.load();
        } catch (IOException ex) {
            Logger.getLogger(GuideVPListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuideguiController guiController = lloader.getController();
        FXMLLoader mloader = new FXMLLoader(getClass().getResource("../gui/GuideMailSendingFXML.fxml"));
        try {
            mroot = mloader.load();
        } catch (IOException ex) {
            Logger.getLogger(GuideVPListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuideMailSendingFXMLController mailController = mloader.getController();
        Scene scene = new Scene(mroot);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        String to = cls.getEmail();
        mailController.setTo(to);
    }

    @FXML
    private void OnPostulerRow(MouseEvent event) {
        FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));
        try {
            Parent rroot = lloader.load();
        } catch (IOException ex) {
            Logger.getLogger(GuideVPListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuideguiController guiController = lloader.getController();

        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        VoyagePersonalise vp = vps.findByName(titre_VP_row.getText());
        Demande dem = new Demande();
        dem.setId_vp(vp);
        dem.setId_client(vp.getClient());
        dem.setId_guide(guiController.guidelog);
        DemandeService ds = new DemandeService();
        if (!dem.equals(ds.findGuideEmail(guiController.guidelog.getEmail()))) {
            ds.add(dem);
            state.setText("Demande reçu");
        } else {
            state.setText("Demande déjà envoyé");
        }
    }

    @FXML
    private void OnAnullerRow(MouseEvent event) {
        FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Guidegui.fxml"));
        try {
            Parent rroot = lloader.load();
        } catch (IOException ex) {
            Logger.getLogger(GuideVPListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuideguiController guiController = lloader.getController();
        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        VoyagePersonalise vp = vps.findByName(titre_VP_row.getText());
        Demande dem = new Demande();
        dem.setId_vp(vp);
        dem.setId_client(vp.getClient());
        dem.setId_guide(guiController.guidelog);
        DemandeService ds = new DemandeService();
        
        if (dem.equals(ds.findGuideEmail(guiController.guidelog.getEmail()))) {
            ds.add(dem);
            ds.remove(dem.getId_vp().getId_vp());
        state.setText("Demande Annulé");
        Timeline t = new Timeline(new KeyFrame(
                Duration.millis(1200),
                ae -> state.setText("")));
        t.play();
        }else{
            state.setText("Vous n'avez pas postulé dans cette offre !!");
            Timeline t1 = new Timeline(new KeyFrame(
                Duration.millis(3000),
                ae -> state.setText("")));
        t1.play();
        }
    }

}
