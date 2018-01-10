/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.sevices.AdminService;
import edu.esprit.pidev.sevices.AgenceService;
import edu.esprit.pidev.sevices.CarRentalService;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.HotelService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class FXMLScreenAdmin2Controller implements Initializable {

    @FXML
    private AnchorPane achorPane;
    @FXML
    private Label clientNbre;
    @FXML
    private Label guideNbre;
    @FXML
    private Label ALVnbre;
    @FXML
    private Label AVnbre;
    @FXML
    private Label HotelNbre;
    @FXML
    private Label AdminNbre;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private BarChart<?, ?> usersChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AgenceService agence=new AgenceService();
        AVnbre.setText(agence.nbrAV()+"");
        AdminService admin=new AdminService();
        AdminNbre.setText(admin.nbrAdmin()+"");
        ClientService client=new ClientService();
        clientNbre.setText(client.nbrClient()+"");
        GuideService guide=new GuideService();
        guideNbre.setText(guide.nbrGuide()+"");
        HotelService hotel=new HotelService();
        HotelNbre.setText(hotel.nbrHotel()+"");
        CarRentalService carRental=new CarRentalService();
        ALVnbre.setText(carRental.nbrALV()+"");
                
        XYChart.Series set1=new XYChart.Series<>();
        
        set1.getData().add(new XYChart.Data("AV", agence.nbrAV()));
        set1.getData().add(new XYChart.Data("ALV", carRental.nbrALV()));
        set1.getData().add(new XYChart.Data("Hotel", hotel.nbrHotel()));
        set1.getData().add(new XYChart.Data("Client", client.nbrClient()));
        set1.getData().add(new XYChart.Data("Guide", guide.nbrGuide()));
        
        usersChart.getData().addAll(set1);
    }
    
    
}
