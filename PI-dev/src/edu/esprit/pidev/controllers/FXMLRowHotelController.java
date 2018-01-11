/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import edu.esprit.pidev.models.Chambre;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.Reservation;
import edu.esprit.pidev.sevices.ChambreService;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.sevices.ReservationService;
import edu.esprit.pidev.sevices.SendMail;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Rating;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLRowHotelController extends ListCell<Chambre>{

    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView hotal_image;
    @FXML
    private Rating rater;
    @FXML
    private Label nom_hotel;
    @FXML
    private Label adresse_hotel;
    @FXML
    private ImageView chambre_image;
    @FXML
    private Label type_chambre;
    @FXML
    private Label prix_chambre;
    @FXML
    private Button bt_reserver;
    @FXML
    private Button bt_contacter_mail_hotel;
    
    private FXMLLoader mLLoader;
    
    public static Chambre ch_res;

    /**
     * Initializes the controller class.
     */
    @Override
    public void updateItem(Chambre student, boolean empty)  {
        super.updateItem(student, empty);
        ChambreService cs = new ChambreService();
        Hotel hotel = new Hotel();
        HotelService hs = new HotelService();
        cs.getAll().toString();
        if (empty || student == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getClassLoader().getResource("edu/esprit/pidev/gui/FXMLRowHotel.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           // System.out.println(student.getHotel_fk().getNom());
           ch_res=student;
            nom_hotel.setText(String.valueOf(student.getClient_fk().getNom()));
            adresse_hotel.setText(student.getClient_fk().getAdresse());
            File file = new File("C:/Users/Ghassen/Desktop/Cours/4INFO/PI/JAVA/PI-dev-java/PI-dev/src/edu/esprit/pidev/utils/logo.png");
            Image img = new Image(file.toURI().toString());
            hotal_image.setImage(img);
            File file1 = new File("C:/Users/Ghassen/Desktop/Cours/4INFO/PI/JAVA/PI-dev-java/PI-dev/src/edu/esprit/pidev/utils/logo.png");
            Image img1 = new Image(file1.toURI().toString());
            chambre_image.setImage(img1);
            rater.setRating(4);
            type_chambre.setText(student.getType());
            prix_chambre.setText(String.valueOf(student.getPrix()));
            setText(null);
            setGraphic(pane);

        }

    }

    @FXML
    private void OnReserverHotel(MouseEvent event) throws Exception{
        ChambreService chs = new ChambreService();
        chs.updateres(ch_res,ClientService.loggedUser.getId_user());
    }

    @FXML
    private void OnContacterHotelMail(MouseEvent event) {
        ChambreService cs = new ChambreService();
        Hotel hotel = new Hotel();
        HotelService hs = new HotelService();
        hotel = hs.findById(ch_res.getHotel_fk().getId_user());
        SendMail.send(hotel.getEmail(), "Reservation", "Bonjour; \nJe voudrais avoir plus d'informations sur vos offres. \n\n Cordialement.\n", "wajdy.bouslama@esprit.tn", "sergeras95");
         TrayNotification tray = new TrayNotification();
        tray.setTitle("Email envoyé");
        tray.showAndDismiss(Duration.seconds(2));
    
    }

}
