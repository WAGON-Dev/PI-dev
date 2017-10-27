/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.ClientService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
            nom_client_row.setText(c.getNom());
            prenom_client_row.setText(c.getPrenom());
            state.setText("");
            setText(null);
            setGraphic(cell);
        }
    }

    @FXML
    private void OnEnvoyerMail(MouseEvent event) {
    }

    @FXML
    private void OnPostulerRow(MouseEvent event) {
    }

    @FXML
    private void OnAnullerRow(MouseEvent event) {
    }

}
