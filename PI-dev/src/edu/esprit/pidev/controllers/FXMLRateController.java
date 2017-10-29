/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXComboBox;
import edu.esprit.pidev.models.Agence;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.sevices.AgenceService;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.HotelService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLRateController implements Initializable {

    @FXML
    private JFXComboBox<String> comboboxchoice;
    @FXML
    private JFXComboBox<String> comboboxselction;

    private ObservableList<String> Liste_choice = FXCollections.observableArrayList("Agence de voyage", "Hotel", "Guide");
    private ObservableList<String> Liste_Hotel = FXCollections.observableArrayList();
    private ObservableList<String> Liste_AV = FXCollections.observableArrayList();
    private ObservableList<String> Liste_Guide = FXCollections.observableArrayList();
    @FXML
    private Rating rating;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxchoice.getItems().addAll(Liste_choice);
    }

    @FXML
    private void filtrechoice(ActionEvent event) {
        String i;
        i = comboboxchoice.getValue();

        if (i == "Hotel") {
            comboboxselction.getItems().clear();
            HotelService hs = new HotelService();
            comboboxselction.getItems().addAll(hs.getAll_name("hotel"));

        } else if (i == "Guide") {
            GuideService gs = new GuideService();
            comboboxselction.getItems().clear();
            comboboxselction.getItems().addAll(gs.getAllname("Guide"));

        } else {
            comboboxselction.getItems().clear();
            AgenceService as = new AgenceService();
            comboboxselction.getItems().addAll(as.getAllname("Agence de voyage"));

        }
    }

    @FXML
    private void filtreselection(ActionEvent event) {

        String i;
        i = comboboxselction.getValue();
        System.out.println(i);
        rating.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (comboboxchoice.getValue() == "Hotel") {

                    HotelService hs = new HotelService();
                    Hotel h = new Hotel();
                    h = hs.findByName_note(i);
                    //System.out.println(newValue.intValue());
                    h.setNote(newValue.intValue());
                    System.out.println(h);
                    hs.update_noote(h);
                } else if (comboboxchoice.getValue() == "Guide") {

                    GuideService gs = new GuideService();
                    Guide g = new Guide();
                    g = gs.findByName(i);
                    //System.out.println(g);
                    g.setNote(newValue.intValue());
                    System.out.println(g.getId_user());
                    gs.update_noote(g);
                } else {
                    AgenceService as = new AgenceService();
                    Agence g = new Agence();
                    g = as.findByName(i);
                    //System.out.println(g);
                    g.setNote(newValue.intValue());
                    System.out.println(g.getId_user());
                    as.update_noote(g);
                }
            }

        });
    }

}
