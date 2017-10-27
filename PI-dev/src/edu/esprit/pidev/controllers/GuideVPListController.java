/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXDrawer;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.VoyagePersonaliseService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Ghassen
 */
public class GuideVPListController implements Initializable {

    @FXML
    private AnchorPane guide_listvp_gui;
    @FXML
    private JFXDrawer menu;
    @FXML
    private ListView<VoyagePersonalise> list_vp;
    @FXML
    private Button postuler_vp_btn;
    @FXML
    private Button annuler_vp_btn;

     private ObservableList<VoyagePersonalise> vplist;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GuideguiController gui = new GuideguiController();
        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        vplist = FXCollections.observableArrayList(vps.getAllbyAdresse("Tunis"));
        list_vp.setItems(vplist);
        list_vp.setCellFactory(studentListView -> new GuideModifguiCellController());
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

}
