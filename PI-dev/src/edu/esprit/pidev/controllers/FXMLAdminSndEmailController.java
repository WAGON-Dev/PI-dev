/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class FXMLAdminSndEmailController implements Initializable {

    @FXML
    private JFXTextField from;
    @FXML
    private JFXTextField to;
    @FXML
    private JFXTextArea context;
    @FXML
    private JFXTextField subject;
    @FXML
    private JFXButton send2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendEmail(ActionEvent event) {
        
        String From=from.getText();
        String To=to.getText();
        String Subject=subject.getText();
        String text=context.getText();
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
                                   return new PasswordAuthentication("nanouasfour@gmail.com","64739502nouhaasfour");
                             }
                       
                       }
               );
               try{
                   
                   Message message=new MimeMessage(session);
                   message.setFrom(new InternetAddress(From));
                   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To)/*InternetAddress.parse("nanouasfour@gmail.com")*/);
                   message.setSubject(Subject);
                   message.setText(text);
                   Transport.send(message);
                   JOptionPane.showConfirmDialog(null, "message sent");
                 }
               catch(Exception e){
                   JOptionPane.showConfirmDialog(null, e);
                   
                 }///finishe using the mail api
    }
    
}
