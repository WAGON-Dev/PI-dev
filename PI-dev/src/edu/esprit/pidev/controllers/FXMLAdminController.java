/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import edu.esprit.pidev.models.Admin;
import edu.esprit.pidev.models.Agence;
import edu.esprit.pidev.models.CarRental;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.Users;
import edu.esprit.pidev.sevices.AdminService;
import edu.esprit.pidev.sevices.AgenceService;
import edu.esprit.pidev.sevices.CarRentalService;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.tests.AdminInterface;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class FXMLAdminController implements Initializable {
    
    
    @FXML
    private TableView<Client> tableViewUser;

    @FXML
    private TableColumn<Client, String> roleColumn;

    @FXML
    private TableColumn<Client, String> prenomColumn;

    @FXML
    private TableColumn<Client, String> nomColumn;

    @FXML
    private TableColumn<Client, String> emailColumn;

    @FXML
    private TableColumn<Client, Integer> numTelColumn;

    @FXML
    private TableColumn<Client, String> adresseColumn;

    @FXML
    private TableColumn<Client, String> numCinColumn;

    @FXML
    private TableColumn<Client, LocalDate> dateNaissColumn;

    private ObservableList<Client>data;
    
    @FXML
    private TableView<Agence> tableViewAV;

    @FXML
    private TableColumn<Agence, String> roleAVColumn;

    @FXML
    private TableColumn<Agence, String> nomAVColumn;

    @FXML
    private TableColumn<Agence, String> emailAVColumn;

    @FXML
    private TableColumn<Agence, Integer> numTelAVColumn;

    @FXML
    private TableColumn<Agence, String> adresseAVColumn;

    @FXML
    private TableColumn<Agence, Integer> nbrVoyageOrgAVColumn;
    
    private ObservableList<Agence>AVdata;
    
    @FXML
    private TableView<CarRental> tableViewAVL;

    @FXML
    private TableColumn<CarRental, String> roleAVLColumn;

    @FXML
    private TableColumn<CarRental, String> nomAVLColumn;

    @FXML
    private TableColumn<CarRental, String> emailAVLColumn;

    @FXML
    private TableColumn<CarRental, Integer> numTelAVLColumn;

    @FXML
    private TableColumn<CarRental, String> adresseAVLColumn;

    @FXML
    private TableColumn<CarRental, Integer> nbrVoitureAVLColumn;
    
    private ObservableList<CarRental>AVLdata;
    
    @FXML
    private TableView<Hotel> tableViewHotel;

    @FXML
    private TableColumn<Hotel, String> roleHotelColumn;

    @FXML
    private TableColumn<Hotel, String> nomHotelColumn;

    @FXML
    private TableColumn<Hotel, String> emailHotelColumn;

    @FXML
    private TableColumn<Hotel, Integer> numTelHotelColumn;

    @FXML
    private TableColumn<Hotel, String> adresseHotelColumn;

    @FXML
    private TableColumn<Hotel, Integer> etoileHotelColumn;

    @FXML
    private TableColumn<Hotel, Integer> nbChambHotelColumn;

    @FXML
    private TableColumn<Hotel, Integer> nbChReserHotelColumn;
    
    private ObservableList<Hotel>Hoteldata;
    
      @FXML
    private TableView<Guide> tableViewGuide;

    @FXML
    private TableColumn<Guide, String> roleGuideColumn;

    @FXML
    private TableColumn<Guide, String> prenomGuideColumn;

    @FXML
    private TableColumn<Guide, String> nomGuideColumn;

    @FXML
    private TableColumn<Guide, String> emailGuideColumn;

    @FXML
    private TableColumn<Guide, Integer> numTelGuideColumn;

    @FXML
    private TableColumn<Guide, String> adresseGuideColumn;

    @FXML
    private TableColumn<Guide, String> numCinGuideColumn;

    @FXML
    private TableColumn<Guide, LocalDate> dateNaissGuideColumn;
     @FXML
    private TableColumn<Guide, Integer> noteGuideColumn;

    @FXML
    private TableColumn<Guide, Integer> nbrNoteGuideColumn;

    
    private ObservableList<Guide>Guidedata;
    
     @FXML
    private TableView<Admin> tableViewAdmin;

    @FXML
    private TableColumn<Admin, String> roleAdminColumn;

    @FXML
    private TableColumn<Admin, String> prenomAdminColumn;

    @FXML
    private TableColumn<Admin, String> nomAdminColumn;

    @FXML
    private TableColumn<Admin, String> emailAdminColumn;

    @FXML
    private TableColumn<Admin, Integer> numTelAdminColumn;

    @FXML
    private TableColumn<Admin, String> adresseAdminColumn;

    @FXML
    private TableColumn<Admin, String> numCinAdminColumn;

    @FXML
    private TableColumn<Admin, LocalDate> dateNaissAdminColumn;
    
    private ObservableList<Admin>Admindata;
    
    
     @FXML
    private JFXButton deleteUserBtn;

    @FXML
    private JFXButton addUserBtn;

    @FXML
    private JFXButton sendEmailBtn;
    
    
    @FXML
    private JFXButton forumBtn;

    
      private Map<Integer,Integer> ids;
      
          @FXML
    private AnchorPane rootPane;
    @FXML
    private Pane UsersPane;
    @FXML
    private JFXButton usersBtn;
    @FXML
    private ImageView AdminImg;
    
    AnchorPane root=null;
    @FXML
    private ImageView imageUser;
    @FXML
    private Label nameUser;
    @FXML
    private Label emailUser;
     

   
      
   


   


    @FXML
    void addUserAction(ActionEvent event) {

    }

    @FXML
    void deleteUserAction(ActionEvent event) {

        int selectedIndex = tableViewAV.getSelectionModel().getSelectedIndex();
        int selectedIndex1=tableViewAVL.getSelectionModel().getSelectedIndex();
       int selectedIndex2=tableViewHotel.getSelectionModel().getSelectedIndex();
     int selectedIndex3=tableViewUser.getSelectionModel().getSelectedIndex();
     int selectedIndex4=tableViewGuide.getSelectionModel().getSelectedIndex();
        int selectedIndex5=tableViewAdmin.getSelectionModel().getSelectedIndex();
       
    if (selectedIndex >= 0) {
        //to get the id of the user we use map to save old user AVdata with key as index in tableview and value as id
        //then we remove from data base as well as from table view
       ids=new HashMap<>();
       for(int i=0;i<AVdata.size();i++){
          ids.put(i,AVdata.get(i).getId_user());
          
           System.out.println(ids.get(i).toString());
           
       }
        AgenceService agence=new AgenceService();
        
        tableViewAV.getItems().remove(selectedIndex);
      
        agence.remove(ids.get(selectedIndex));
         System.out.println(ids.get(selectedIndex));
         return;
        
       
    }  if(selectedIndex1 >= 0){
         //to get the id of the user we use map to save old user AVdata with key as index in tableview and value as id
        //then we remove from data base as well as from table view
       ids=new HashMap<>();
       for(int i=0;i<AVLdata.size();i++){
          ids.put(i,AVLdata.get(i).getId_user());
           System.out.println(selectedIndex1+""+ids.get(i));
            }
       
        CarRentalService agenceV=new CarRentalService();
        
        tableViewAVL.getItems().remove(selectedIndex1);
      
        agenceV.remove(ids.get(selectedIndex1));
         System.out.println(ids.get(selectedIndex1));
        
        return;
    }
     if(selectedIndex2 >= 0){
          //to get the id of the user we use map to save old user AVdata with key as index in tableview and value as id
        //then we remove from data base as well as from table view
       ids=new HashMap<>();
       for(int i=0;i<Hoteldata.size();i++){
          ids.put(i,Hoteldata.get(i).getId_user());
           System.out.println(selectedIndex2+""+ids.get(i));
           
       }
        HotelService agence=new HotelService();
        
        tableViewHotel.getItems().remove(selectedIndex2);
      
        agence.remove(ids.get(selectedIndex2));
         System.out.println(ids.get(selectedIndex2));
        
         return;
    }
     if(selectedIndex3 >= 0){
         ids=new HashMap<>();
       for(int i=0;i<data.size();i++){
          ids.put(i,data.get(i).getId_user());
           System.out.println(selectedIndex3+""+ids.get(i));
           
       }
           ClientService client=new ClientService();
        tableViewUser.getItems().remove(selectedIndex3);
      
        client.remove(ids.get(selectedIndex3));
         System.out.println(ids.get(selectedIndex3));
        
         
        
         return;
    }
     if(selectedIndex4 >= 0){
          ids=new HashMap<>();
       for(int i=0;i<Guidedata.size();i++){
          ids.put(i,Guidedata.get(i).getId_user());
           System.out.println(selectedIndex4+""+ids.get(i));
           
       }GuideService guide=new GuideService();
        tableViewGuide.getItems().remove(selectedIndex4);
      
        guide.remove(ids.get(selectedIndex4));
         System.out.println(ids.get(selectedIndex4));
        
         return;
    }
     if(selectedIndex5 >= 0){
          ids=new HashMap<>();
       for(int i=0;i<Admindata.size();i++){
          ids.put(i,Admindata.get(i).getId_user());
           System.out.println(selectedIndex5+""+ids.get(i));
           
       }AdminService admin=new AdminService();
        tableViewAdmin.getItems().remove(selectedIndex5);
      
        admin.remove(ids.get(selectedIndex5));
         System.out.println(ids.get(selectedIndex5));
        
         return;
    }
    
        // Nothing selected.
        Alert alert = new Alert(AlertType.WARNING);
       // alert.initOwner();
        alert.setTitle("No Selection");
        alert.setHeaderText("No Person Selected");
        alert.setContentText("Please select a person in the table.");

        alert.showAndWait();
          
    }
    
    
    
    
    

    @FXML
    void sendEmailAction(ActionEvent event){
         Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLAdminSndEmail.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        
       
        
       
         
    }
    
    
    
  
    
    
    
    
   
    
    /**
     * Initializes the controller class.
     */
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
      /**************CLIENT***************/
        ClientService client=new ClientService();
       
        data=FXCollections.observableArrayList();
        //set Up the columns in the table
      roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
       emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
     numTelColumn.setCellValueFactory(new PropertyValueFactory<>("numtel"));
     adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
       prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
     numCinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));
   dateNaissColumn.setCellValueFactory(new PropertyValueFactory<>("dateNaissence"));
     //load data   
   data.addAll(client.getByClient());
   tableViewUser.setItems(data);
   
   for(int i=0;i<data.size();i++) 
        System.out.println(data.get(i).toString());
   /**************AGENCE***************/
   AgenceService agence=new AgenceService();
           AVdata=FXCollections.observableArrayList();
                   //set Up the columns in the table
           roleAVColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
           nomAVColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
           emailAVColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
           numTelAVColumn.setCellValueFactory(new PropertyValueFactory<>("numtel"));
           adresseAVColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
           nbrVoyageOrgAVColumn.setCellValueFactory(new PropertyValueFactory<>("nbr_voyage_organise"));
//load data
AVdata.addAll(agence.getByRole());
tableViewAV.setItems(AVdata);
   
 

   /**************CarRental***************/
        CarRentalService carRental=new CarRentalService();
        AVLdata=FXCollections.observableArrayList();
         //set Up the columns in the table
           roleAVLColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
           nomAVLColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
           emailAVLColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
           numTelAVLColumn.setCellValueFactory(new PropertyValueFactory<>("numtel"));
           adresseAVLColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
           nbrVoitureAVLColumn.setCellValueFactory(new PropertyValueFactory<>("carNbre"));
//load data
AVLdata.addAll(carRental.getByRole());
tableViewAVL.setItems(AVLdata);
        


for(int i=0;i<AVLdata.size();i++) 
        System.out.println(AVLdata.get(i).toString());
        
      /**************HOTEL***************/  
        
        HotelService hotel=new HotelService();
        Hoteldata=FXCollections.observableArrayList();
        
        //set Up the columns in the table
           roleHotelColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
           nomHotelColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
           emailHotelColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
           numTelHotelColumn.setCellValueFactory(new PropertyValueFactory<>("numtel"));
           adresseHotelColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
           etoileHotelColumn.setCellValueFactory(new PropertyValueFactory<>("etoile"));
           nbChambHotelColumn.setCellValueFactory(new PropertyValueFactory<>("nb_chambre"));
           nbChReserHotelColumn.setCellValueFactory(new PropertyValueFactory<>("nb_chambre_reserve"));

           Hoteldata.addAll(hotel.getByRole());
tableViewHotel.setItems(Hoteldata);
        
      /**************GUIDE***************/  

GuideService guide=new GuideService();

Guidedata=FXCollections.observableArrayList();
        //set Up the columns in the table
      roleGuideColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
            nomGuideColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
       emailGuideColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
     numTelGuideColumn.setCellValueFactory(new PropertyValueFactory<>("numtel"));
     adresseGuideColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
       prenomGuideColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
     numCinGuideColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));
   dateNaissGuideColumn.setCellValueFactory(new PropertyValueFactory<>("dateDeNaissance"));
        noteGuideColumn.setCellValueFactory(new PropertyValueFactory<>("Note"));
     nbrNoteGuideColumn.setCellValueFactory(new PropertyValueFactory<>("nbrNote"));

     //load data   
   Guidedata.addAll(guide.getByRole());
   tableViewGuide.setItems(Guidedata);
   
         /**************ADMIN***************/ 
                AdminService admin=new AdminService();
                
                 Admindata=FXCollections.observableArrayList();
        //set Up the columns in the table
      roleAdminColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
            nomAdminColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
       emailAdminColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
     numTelAdminColumn.setCellValueFactory(new PropertyValueFactory<>("numtel"));
     adresseAdminColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
       prenomAdminColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
     numCinAdminColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));
   dateNaissAdminColumn.setCellValueFactory(new PropertyValueFactory<>("dateNaissence"));
     //load data   
   Admindata.addAll(admin.getByAdmin());
   tableViewAdmin.setItems(Admindata);

   
    
}

    @FXML
    private void loadSecondScreen(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLScreenAdmin2.fxml"));
        UsersPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadUsersScene(ActionEvent event) throws IOException {
        if(root==null)
       root =  FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLAdmin.fxml"));
            rootPane.getChildren().setAll(root);
                   
    
    }
  
 
}