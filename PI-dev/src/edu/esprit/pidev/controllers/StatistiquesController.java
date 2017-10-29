/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;


import edu.esprit.pidev.models.VoyageOrganise;
import edu.esprit.pidev.sevices.VoyageOrganiseService;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zakiya
 */
public class StatistiquesController implements Initializable {

   
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    private ObservableList<String> monthNames = FXCollections.observableArrayList();
    @FXML
    private AnchorPane FondS;
    @FXML
    private LineChart<String, Integer> linechar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Get an array with the English month names.
        String[] months = DateFormatSymbols.getInstance(Locale.FRANCE).getMonths();
        // Convert it to a list and add it to our ObservableList of months.
        monthNames.addAll(Arrays.asList(months));

        // Assign the month names as categories for the horizontal axis.
        x.setCategories(monthNames);
    
List <VoyageOrganise> voyages = new ArrayList<>() ;
    
        // Count the number of people having their birthday in a specific month.
        int[] monthCounter = new int[12];
        VoyageOrganiseService voyageService = new VoyageOrganiseService();
        voyages = voyageService.getTableByIdAgence(8);

        for (VoyageOrganise p : voyages) {
            System.out.println(p);
            int month = p.getDateDebutVoy().getMonth();
            monthCounter[month]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }

        linechar.getData().add(series);
    }
        /* // Count the number of people having their birthday in a specific month.
        VoyageOrganiseService voyageService = new VoyageOrganiseService();
        voyages = voyageService.getTableByIdAgence(8);

        int[] monthCounter = new int[12];
        int nbrjanvier = 0;
        int nbrfevr = 1;
        int nbrmars = 2;
        int nbrAvri = 3;
        int nbrMai = 4;
        int nbrjuin = 5;
        int nbrjuil = 6;
        int nbrAout = 7;
        int nbrSept = 8;
        int nbrOct = 9;
        int nbrNov = 10;
        int nbrDec = 11;

        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrjanvier == calendar.get(Calendar.MONTH)) {
                monthCounter[0]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrfevr == calendar.get(Calendar.MONTH)) {
                monthCounter[1]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrmars == calendar.get(Calendar.MONTH)) {
                monthCounter[2]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrAvri == calendar.get(Calendar.MONTH)) {
                monthCounter[3]++;
            }
        }

        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrMai == calendar.get(Calendar.MONTH)) {
                monthCounter[4]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrjuin == calendar.get(Calendar.MONTH)) {
                monthCounter[5]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrjuil == calendar.get(Calendar.MONTH)) {
                monthCounter[6]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrAout == calendar.get(Calendar.MONTH)) {
                monthCounter[7]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrSept == calendar.get(Calendar.MONTH)) {
                monthCounter[8]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrOct == calendar.get(Calendar.MONTH)) {
                monthCounter[9]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrNov == calendar.get(Calendar.MONTH)) {
                monthCounter[10]++;
            }
        }
        for (VoyageOrganise v : voyages) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(v.getDateDebutVoy());
            if (nbrDec == calendar.get(Calendar.MONTH)) {
                monthCounter[11]++;
            }

            XYChart.Series<String, Integer> series = new XYChart.Series<>();

            // Create a XYChart.Data object for each month. Add it to the series.
            for (int i = 0; i < monthCounter.length; i++) {
                series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
            }

            VoyageChart.getData().add(series);
        }
    }*/
    

    @FXML
    private void retouraccueilStat(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccueilAgence.fxml"));
            System.out.println("pathgood");

            Parent root = fxmlLoader.load();
            System.out.println("pane");
            AccueilAgenceController cntrl = fxmlLoader.getController();
            FondS.getScene().setRoot(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
