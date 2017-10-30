package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import edu.esprit.pidev.models.Chambre;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.sevices.ChambreService;
import edu.esprit.pidev.sevices.HotelService;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
//import javimport javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;







public class HotelController implements Initializable {

    @FXML
    private JFXTextField PrixText;

    @FXML
    private JFXComboBox<String> typeText ;    
            @FXML
    private AnchorPane fondchb;


    @FXML
    private TableView<Chambre> tablechmbr;
    private ObservableList<Chambre> chambresData = FXCollections.observableArrayList();

    List<Chambre> chambres;
    @FXML
    private TableColumn<Chambre, String> typechambr;

    @FXML
    private TableColumn<Chambre, Float> prixparnuit;

    @FXML
    private JFXButton Ajouter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chambres = new ArrayList<Chambre>();
        ChambreService chambreService = new ChambreService();

        // System.out.println(evenementService.getAll().size());
        HotelService hotelServ = new HotelService();
        Hotel h = new Hotel();
        h = hotelServ.findById(1);
        chambres = chambreService.getByHotel(h); //String Type; double prix;
        typechambr.setCellValueFactory(new PropertyValueFactory<>("Type"));
        prixparnuit.setCellValueFactory(new PropertyValueFactory<>("prix"));

        chambresData.clear();
        chambresData.addAll(chambres);
        tablechmbr.setItems(chambresData);

        ObservableList<String> ls = javafx.collections.FXCollections.observableArrayList("individuelle", "Double", "Suite");
        typeText.setItems(ls);

    }

    @FXML
    void Ajouterchambr(ActionEvent event) {
        Chambre chambre = new Chambre();

        String a = PrixText.getText();

        float b = Float.parseFloat(a);

        chambre.setPrix(b);
        chambre.setType(typeText.getSelectionModel().getSelectedItem());

        ChambreService service = new ChambreService();
 HotelService hotelServ = new HotelService();
        Hotel h = new Hotel();
        h = hotelServ.findById(1);
        chambre.setHotel_fk(h);
        service.add(chambre);

        PrixText.setText(null);
       
        typeText.setValue(null);

        List<Chambre> chambres = new ArrayList<Chambre>();
        ChambreService chambreService = new ChambreService();
        // prendre le nombre d'evennements
        System.out.println(chambreService.getAll().size());
        // je prends tous les evnmts dans une liste 
     chambres = chambreService.getByHotel(h);
        typechambr.setCellValueFactory(new PropertyValueFactory<>("Type"));
        prixparnuit.setCellValueFactory(new PropertyValueFactory<>("prix"));

        chambresData.clear();
        chambresData.addAll(chambres);
        tablechmbr.setItems(chambresData);

        tray.notification.TrayNotification tr = new TrayNotification();
        tr.setTitle("Terminé");
        tr.setMessage("Ajout de la chambre avec succès");
        tr.setNotificationType(NotificationType.SUCCESS);
        tr.setAnimationType(AnimationType.SLIDE);
        tr.showAndDismiss(Duration.seconds(2));

    }


@FXML
    void Cancell(ActionEvent event) {
        
    }

    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void Supprimer(ActionEvent event) {

    }

    @FXML
    void retour(MouseEvent event) {
  try {
      //**********************  
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccueilAgence.fxml"));
            System.out.println("pathgood");

            Parent root = fxmlLoader.load();
            System.out.println("pane");
            AccueilAgenceController cntrl = fxmlLoader.getController();
            fondchb.getScene().setRoot(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
