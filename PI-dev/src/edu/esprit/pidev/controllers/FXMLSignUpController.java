/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.teknikindustries.bulksms.SMS;
import edu.esprit.pidev.models.Admin;
import edu.esprit.pidev.models.Agence;
import edu.esprit.pidev.models.CarRental;
//import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.sevices.AdminService;
import edu.esprit.pidev.sevices.AgenceService;
import edu.esprit.pidev.sevices.CarRentalService;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.tests.AdminInterface;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.mail.Session;
import javax.swing.Icon;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nouha
 */
public class FXMLSignUpController  implements Initializable{

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField passwordSignUp;

    @FXML
    private JFXPasswordField passwordComfSignUp;

    @FXML
    private JFXComboBox<String> roleComboBox;

    
    @FXML
    private JFXTextField phoneNum; 
   @FXML
    private Pane hotelPopUp;


    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField etoileHotel;

    @FXML
    private JFXButton signUpHotelBtn;

    @FXML
    private JFXSpinner spinner;

    @FXML
    private JFXButton SignUpGeneral;
      @FXML
    private Pane UserPopUp;

    @FXML
    private JFXButton signUpUserBtn;

    
    

    @FXML
    private JFXTextField numCin;

    @FXML
    private JFXDatePicker dateNaissance;
public static String role;

    ObservableList<String> listRole=FXCollections.observableArrayList("admin","client","hotel","agence de location de voiture","guide","agence de voyage");
    
    @FXML
    private Pane carRentalPopUp;
    @FXML
    private JFXTextField nbrVoituresALV;
    @FXML
    private JFXButton signUpALVBtn1;
    @FXML
    private JFXButton closeHotelPop;
    @FXML
    private JFXButton closeUserPop;
    @FXML
    private JFXButton closeALVPop;

    
  
    
     
   /*  @FXML
    void closePopUp(MouseEvent event) {

    }*/
   @FXML 
    void getRole(ActionEvent event) {
         
       role= roleComboBox.getSelectionModel().getSelectedItem();
       if(role.equals("hotel")){
           
           hotelPopUp.setVisible(true);
           
       }
       if(role.equals("admin")||role.equals("client")||role.equals("guide")){
           UserPopUp.setVisible(true);
       }
       if(role.equals("agence de location de voiture")){
           carRentalPopUp.setVisible(true);
       }
       if(role.equals("agence de voyage")){
           SignUpGeneral.setDisable(false);
       }
        
    }
    @FXML
    void SignUp(ActionEvent event) throws IOException {

     if(role.equals("agence de voyage")){
         if(passwordSignUp.getText().equals(passwordComfSignUp.getText())){
         AgenceService agence=new AgenceService();
         int numTel=Integer.parseInt(phoneNum.getText());
         Agence a=new Agence(role,firstName.getText() , email.getText(), passwordSignUp.getText(), numTel, address.getText(), 0);
        agence.add(a);
         /******ajout de linterface agence de voyage ???*******/
         FXMLLoader loader=new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/AccueilAgence.fxml"));
              Parent root=loader.load();
              SignUpGeneral.getScene().setRoot(root);
                   System.out.println("done !!");
                   
                   
                         Properties props=new Properties();
               props.put("mail.smtp.host", "smtp.gmail.com");
               props.put("mail.smtp.socketFactory.port", "465");
              props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
               props.put("mail.smtp.auth","true");
               props.put("mail.smtp.port","465");
               
               Session session=Session.getDefaultInstance(props,
                       new javax.mail.Authenticator() {
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication(){
                                   return new PasswordAuthentication("nanouasfour@gmail.com","64739502nanou");
                             }
                       
                       }
               );
               try{
                   
                   Message message=new MimeMessage(session);
                   message.setFrom(new InternetAddress("nanouasfour@gmail.com"));
                   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getText())/*InternetAddress.parse("nanouasfour@gmail.com")*/);
                   message.setSubject("you're currently registraing in our application");
                   message.setText("merci pour votre inscription");
                   Transport.send(message);
                  JOptionPane.showConfirmDialog(null, "message sent");
                 }
               catch(Exception e){
                   JOptionPane.showConfirmDialog(null, e);
                   
                 }///finishe using the mail api
         }else {   String g="your password and password comfirmation are not the same";
        JOptionPane.showMessageDialog(null, g);}
     }
     
       
            
    }
@FXML
     void SignUpUser(ActionEvent event) throws IOException {
         if(passwordSignUp.getText().equals(passwordComfSignUp.getText())){
        SignUpGeneral.setDisable(true);
   if(role.equals("client")){
            ClientService cs = new ClientService();
            Date date = Date.from(dateNaissance.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
           int numTel=Integer.parseInt(phoneNum.getText());
           //String prenom, String cin, Date dateNaissence, String nom, String email, String mdp, int numtel, String adresse, String role, String image
            Client t=new Client(lastName.getText(), numCin.getText(),date, firstName.getText(), email.getText(), passwordSignUp.getText(), numTel, address.getText(), role, "");
            cs.add(t);
            /******ajout de linterface client ???*******/
              ClientService cs1=new ClientService();
            cs1.existeUtilisateur(firstName.getText());
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/FXMLInterfaceClient.fxml"));
              Parent root=loader.load();
              signUpUserBtn.getScene().setRoot(root);
                   System.out.println("done !!");
        }
   if(role.equals("admin")){
                   AdminService admin=new AdminService();
               Date date = Date.from(dateNaissance.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
               int numTel=Integer.parseInt(phoneNum.getText());
                 Admin a=new Admin(firstName.getText(), numCin.getText(), date, lastName.getText(), email.getText(), passwordSignUp.getText(), numTel, address.getText(), role, "");
                   admin.add(a);
                   Stage primaryStage=new Stage();
		   AdminInterface adminInterface=new AdminInterface();
		  Stage stage = (Stage) signUpUserBtn.getScene().getWindow();
		 try {
		    adminInterface.start(primaryStage);
                    
                          stage.close();
                     } catch (Exception e) {
			e.printStackTrace();
		} System.out.println("done !!");
        }
               
          // le traitement si le role est le guide
  if(role.equals("guide")){
                   GuideService guide=new GuideService();
                Date date = Date.from(dateNaissance.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
               int numTel=Integer.parseInt(phoneNum.getText());
               Guide g=new Guide(lastName.getText(), numCin.getText(), date, 0, 0, firstName.getText(), email.getText(), passwordSignUp.getText(), numTel, address.getText(), role, " ");
               guide.add(g);
               FXMLLoader loader=new FXMLLoader(getClass().getResource("/edu/esprit/pidev/gui/Guidegui.fxml"));
              Parent root=loader.load();
              signUpUserBtn.getScene().setRoot(root);
                   System.out.println("done !!");
    }
               ///***** send automatically an email to the user who signed up
              SMS sms=new SMS();
            sms.SendSMS("nouha1995", "64739502", "you are currently connecting on our application", "+216"+phoneNum.getText()," https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
               Properties props=new Properties();
               props.put("mail.smtp.host", "smtp.gmail.com");
               props.put("mail.smtp.socketFactory.port", "465");
              props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
               props.put("mail.smtp.auth","true");
               props.put("mail.smtp.port","465");
               
               Session session=Session.getDefaultInstance(props,
                       new javax.mail.Authenticator() {
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication(){
                                   return new PasswordAuthentication("nanouasfour@gmail.com","64739502nanou");
                             }
                       
                       }
               );
               try{
                   
                   Message message=new MimeMessage(session);
                   message.setFrom(new InternetAddress("nanouasfour@gmail.com"));
                   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getText())/*InternetAddress.parse("nanouasfour@gmail.com")*/);
                   message.setSubject("you're currently registraing in our application");
                   message.setText("merci pour votre inscription");
                   Transport.send(message);
                   JOptionPane.showConfirmDialog(null, "message sent");
                 }
               catch(Exception e){
                   JOptionPane.showConfirmDialog(null, e);
                   
                 }///finishe using the mail api
         }else {   String g="your password and password comfirmation are not the same";
        JOptionPane.showMessageDialog(null, g);}
 }
    @FXML
    void SignUpHotel(ActionEvent event) {
        if(passwordSignUp.getText().equals(passwordComfSignUp.getText())){
      if(role.equals("hotel")){
                  HotelService hotelService = new HotelService();
                int numTel=Integer.parseInt(phoneNum.getText());
                int etoile=Integer.parseInt(etoileHotel.getText());
               Hotel h=new Hotel(firstName.getText(), email.getText(), passwordSignUp.getText(), numTel, address.getText(), role, "", etoile, 0, 0);
                       hotelService.add(h);
                    
                         /******ajout de linterface  hotel???*******/
                   System.out.println("done !!");
                   SMS sms=new SMS();
              sms.SendSMS("nouha1995", "64739502", "you are currently connecting on our application", "+216"+phoneNum.getText()," https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
                         Properties props=new Properties();
               props.put("mail.smtp.host", "smtp.gmail.com");
               props.put("mail.smtp.socketFactory.port", "465");
              props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
               props.put("mail.smtp.auth","true");
               props.put("mail.smtp.port","465");
               
               Session session=Session.getDefaultInstance(props,
                       new javax.mail.Authenticator() {
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication(){
                                   return new PasswordAuthentication("nanouasfour@gmail.com","64739502nanou");
                             }
                       
                       }
               );
               try{
                   
                   Message message=new MimeMessage(session);
                   message.setFrom(new InternetAddress("nanouasfour@gmail.com"));
                   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getText())/*InternetAddress.parse("nanouasfour@gmail.com")*/);
                   message.setSubject("you're currently registraing in our application");
                   message.setText("merci pour votre inscription");
                   Transport.send(message);
                   JOptionPane.showConfirmDialog(null, "message sent");
                 }
               catch(Exception e){
                   JOptionPane.showConfirmDialog(null, e);
                   
                 }///finishe using the mail api
      }
        }else {   String g="your password and password comfirmation are not the same";
        JOptionPane.showMessageDialog(null, g);}
    }
    @FXML
    
    private void SignUpALV(ActionEvent event) {
        if(passwordSignUp.getText().equals(passwordComfSignUp.getText())){
        if(role.equals("agence de location de voiture")){
        CarRentalService carRental=new CarRentalService();
         int numTel=Integer.parseInt(phoneNum.getText());
          int num=Integer.parseInt(nbrVoituresALV.getText());
         CarRental c=new CarRental(firstName.getText(), email.getText(), passwordSignUp.getText(), numTel, address.getText(), role, 0, num);
         carRental.add(c);
         /******ajout de linterface  carRental???*******/
         SMS sms=new SMS();
              sms.SendSMS("nouha1995", "64739502", "you are currently connecting on our application", "+216"+phoneNum.getText()," https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
                   System.out.println("done !!");
                         Properties props=new Properties();
               props.put("mail.smtp.host", "smtp.gmail.com");
               props.put("mail.smtp.socketFactory.port", "465");
              props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
               props.put("mail.smtp.auth","true");
               props.put("mail.smtp.port","465");
               
               Session session=Session.getDefaultInstance(props,
                       new javax.mail.Authenticator() {
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication(){
                                   return new PasswordAuthentication("nanouasfour@gmail.com","64739502nanou");
                             }
                       
                       }
               );
               try{
                   
                   Message message=new MimeMessage(session);
                   message.setFrom(new InternetAddress("nanouasfour@gmail.com"));
                   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getText())/*InternetAddress.parse("nanouasfour@gmail.com")*/);
                   message.setSubject("you're currently registraing in our application");
                   message.setText("merci pour votre inscription");
                   Transport.send(message);
                   JOptionPane.showConfirmDialog(null, "message sent");
                 }
               catch(Exception e){
                   JOptionPane.showConfirmDialog(null, e);
                   
                 }///finishe using the mail api
        }}else {   String g="your password and password comfirmation are not the same";
        JOptionPane.showMessageDialog(null, g);}
    }
    
    
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
                SignUpGeneral.setDisable(true);
               System.out.println("whyyyyyy");
                roleComboBox.setItems(listRole);
                RequiredFieldValidator validator=new RequiredFieldValidator();
                firstName.getValidators().add(validator);
                lastName.getValidators().add(validator);
                email.getValidators().add(validator);
                passwordSignUp.getValidators().add(validator);
                passwordComfSignUp.getValidators().add(validator);
                phoneNum.getValidators().add(validator);
                address.getValidators().add(validator);
                etoileHotel.getValidators().add(validator);
                validator.setMessage("No Inupt Given");
                
                firstName.focusedProperty().addListener(new ChangeListener<Boolean>(){
                   @Override
                   public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                            if(!newValue)
                                firstName.validate();
                   }});
                lastName.focusedProperty().addListener(new ChangeListener<Boolean>(){
                   @Override
                   public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                            if(!newValue  ){
                                
                                lastName.validate();
                               
                            
                            }
                   }});
                
                 email.focusedProperty().addListener(new ChangeListener<Boolean>(){
                   @Override
                   public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                           if(!newValue ){
                              
                               email.validate();
                                }
                   }});
                 passwordSignUp.focusedProperty().addListener(new ChangeListener<Boolean>(){
                   @Override
                   public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                           if( !newValue){
                               passwordSignUp.validate();
                               
                                }
                   }});
                  passwordComfSignUp.focusedProperty().addListener(new ChangeListener<Boolean>(){
                   @Override
                   public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                           if(!newValue){
                               passwordComfSignUp.validate();
                              
                               }
                   }});
                  
                    address.focusedProperty().addListener(new ChangeListener<Boolean>(){
                   @Override
                   public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                           if(!newValue ){
                                address.validate();
                               
                               }
                   }});
                
                    phoneNum.focusedProperty().addListener(new ChangeListener<Boolean>(){
                   @Override
                   public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                           if(!newValue){
                               phoneNum.validate();
                               
                               }
                   }});
                
   }              

    @FXML
    private void closeHotelPop(ActionEvent event) {
        hotelPopUp.setVisible(false);
    }

    @FXML
    private void closeUserPop(ActionEvent event) {
        UserPopUp.setVisible(false);
    }

    @FXML
    private void closeALVPop(ActionEvent event) {
        carRentalPopUp.setVisible(false);
    }

    

   
    
}
