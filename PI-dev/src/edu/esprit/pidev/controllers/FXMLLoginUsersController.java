/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import edu.esprit.pidev.sevices.AdminService;
import edu.esprit.pidev.sevices.AgenceService;
import edu.esprit.pidev.sevices.CarRentalService;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.tests.AdminInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class FXMLLoginUsersController implements Initializable {

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private JFXHamburger humber;

    @FXML
    private JFXDrawer drawer;

    @FXML
    void loginAction(ActionEvent event) throws IOException, Exception {

    
    
        AdminService a = new AdminService();
        AgenceService ag = new AgenceService();
        CarRentalService car = new CarRentalService();
        ClientService cs = new ClientService();
        GuideService g = new GuideService();
        HotelService h = new HotelService();
        if (a.findByEmail(userName.getText()) != null) {

            Stage primaryStage = new Stage();
            AdminInterface adminInterface = new AdminInterface();
            Stage stage = (Stage) login.getScene().getWindow();

            adminInterface.start(primaryStage);

            stage.close();

            System.out.println("done1 !!");
        } else if ((ag.findByEmail(userName.getText()) != null)&&(ag.findByEmail(userName.getText()).getMdp().equals(password.getText()))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/AccueilAgence.fxml"));
            Parent root = loader.load();
            login.getScene().setRoot(root);

            System.out.print("done2!!");
            /**
             * ***LOading the interface***
             */

        } else if ((car.findByEmail(userName.getText()) != null)&&(car.findByEmail(userName.getText()).getMdp().equals(password.getText()))) {

            System.out.print("done3!!");
            /**
             * ***LOading the interface***
             */

        } else if ((cs.findByemail(userName.getText()) != null)&&(cs.findByemail(userName.getText()).getMdp().equals(password.getText()))) {
            ClientService cs1 = new ClientService();
            cs1.existeUtilisateur(userName.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/FXMLinterfaceClient.fxml"));
            Parent root = loader.load();
            login.getScene().setRoot(root);
            System.out.print("done4!!");
            /**
             * ***LOading the interface***
             */
        } else if ((g.findByEmail(userName.getText()) != null)&&(g.findByEmail(userName.getText()).getMdp().equals(password.getText()))) {
            System.out.print("done5!!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/Guidegui.fxml"));
            Parent root = loader.load();
            login.getScene().setRoot(root);
            /**
             * ***LOading the interface***
             */
        } else if ((h.findByemail(userName.getText()) != null)&&(h.findByemail(userName.getText()).getMdp().equals(password.getText()))) {
            System.out.print("done6!!");

            /**
             * ***LOading the interface***
             */
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLSignUp.fxml"));

            drawer.setSidePane(pane);
            drawer.setDefaultDrawerSize(500);

            HamburgerBackArrowBasicTransition burger = new HamburgerBackArrowBasicTransition(humber);

            burger.setRate(-1);
            humber.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burger.setRate(burger.getRate() * -1);
                burger.play();
                if (drawer.isShown()) {
                    drawer.close();
                } else {
                    drawer.open();
                }

            });

            System.out.println("OK");
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
