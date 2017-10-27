/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXTextField;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.sevices.ClientService;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLloginController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField password;
    @FXML
    private Label resultat;
 public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {

        ClientService cs = new ClientService();

        List<Client> list = cs.getAll();
        Map<String, String> map = new HashMap<>();
        for (Client a : list) {
            map.put(a.getNom(), a.getMdp());
        }
        if (map.containsKey(name.getText())) {

            String x = map.get(name.getText());
            if (x.equals(password.getText())) {
                ClientService cs1 = new ClientService();
                cs1.existeUtilisateur(name.getText());
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/FXMLCrud_VP.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                resultat.setText("authetification done");

            } else {
                resultat.setText("please select a correct data");
            }

        } else {
            resultat.setText("not ok");
        }

    }
}

