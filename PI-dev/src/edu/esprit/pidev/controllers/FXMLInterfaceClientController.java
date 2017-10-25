/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLInterfaceClientController implements Initializable {

    @FXML
    private JFXDrawer menu_bar;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

       try {
            VBox Vbox = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLMenuBar.fxml"));
            menu_bar.setSidePane(Vbox);

        } catch (IOException ex) {
        }

    }

    @FXML
    private void OpenMenu(MouseEvent event) {
        if (menu_bar.isShown()) {
            menu_bar.close();
        }
    }

    @FXML
    private void ExitMenu(MouseEvent event) {
        menu_bar.open();

    }

}
