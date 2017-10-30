/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.pidev.interfaces.IDemandeService;
import edu.esprit.pidev.models.Demande;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.sevices.DemandeService;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.VoyagePersonaliseService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLDemande_VPController implements Initializable {

    @FXML
    private TableView<Demande> table_demande;
    @FXML
    private TableColumn<Demande, String> id_vp;
    @FXML
    private TableColumn<Demande, String> id_guide;
    @FXML
    private JFXTextField passw;

    private ObservableList<Demande> Liste_VP = FXCollections.observableArrayList();
    @FXML
    private JFXButton afficher;
    @FXML
    private JFXButton email;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label cin;
    @FXML
    private Label dateN;
    @FXML
    private Label numtel;
    @FXML
    private Label note;
    @FXML
    private Label emaillabel;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void afficher(ActionEvent event) {
        DemandeService ds = new DemandeService();

        //System.out.println(ds.getAll());
        Liste_VP = FXCollections.observableArrayList(ds.getAll());

        id_vp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Demande, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Demande, String> param) {
                return new SimpleStringProperty(param.getValue().getId_vp().getNom());
            }

        });
        id_guide.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Demande, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Demande, String> param) {
                return new SimpleStringProperty(param.getValue().getId_guide().getNom());
            }

        });

        table_demande.setItems(Liste_VP);
    }

    @FXML
    private void pdf(ActionEvent event) throws DocumentException {
        Demande d = new Demande();
        /**
         * *********************
         */
        Guide g1 = new Guide();
        GuideService gs = new GuideService();
        String nom = table_demande.getSelectionModel().getSelectedItem().getId_guide().getNom();
        g1 = gs.findByName(nom);
        /**
         * ********************
         */
        VoyagePersonalise vp = new VoyagePersonalise();
        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        String nom_vp = table_demande.getSelectionModel().getSelectedItem().getId_vp().getNom();
        vp = vps.findByName(nom_vp);

        Document document = new Document() {
        };
        try {
            PdfWriter.getInstance(document, new FileOutputStream(g1.getNom() + ".pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDemande_VPController.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
        try {
            document.add(new Paragraph("\n--------------------REPONSE A VOTRE DEMANDE DE TRAVAIL--------------------------\n\n"
                    + "votre demande de travail a ete confirme vu vos competences "
                    + "la date du depart :" + vp.getDate_depart() + " " + " \n"
                    + "la date retour :" + " " + vp.getDate_arrive() + " " + " \n "
                    + "l'evenement que vous aller nous guider :" + " " +"" + " \n "
                    + "PRIX : " + "200DT" + " \n\n\n"
                    + " a bientôt "
            ));

            document.addTitle("title");
            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(FXMLDemande_VPController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        System.out.println("pdf avec success");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("la reponse a été imprimer en PDF avec success");
        alert.show();
    }

    @FXML
    private void envoyer(ActionEvent event) {
        /*EmailSender emailS = new EmailSender();
        String[] to = {"ahmed.benamribettaieb@esprit.tn"};
        Client c = new Client();
        c = ClientService.loggedUser;
        
        String subject = "offre d'emplois pour guide";
        String message1 = msg.getText();*/
        Guide g = new Guide();
        GuideService gs = new GuideService();
        final String UsernameSender = ClientService.loggedUser.getEmail();

        String nom = table_demande.getSelectionModel().getSelectedItem().getId_guide().getNom();
        g = gs.findByName(nom);
        final String username = g.getEmail(); //ur email
        final String password = passw.getText();

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(UsernameSender, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(UsernameSender));//ur email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(username));//u will send to
            message.setSubject("Subject");
            message.setText("aaaaaaaaaaaaaa");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();

            //attached 1 --------------------------------------------
            String file = g.getNom() + ".pdf";
            String fileName = "resultat";
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("sending");
            Transport.send(message);
            System.out.println("Done");

       

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.initOwner(adresse.getScene().getWindow());
        DemandeService ds = new DemandeService();
        Demande d =table_demande.getSelectionModel().getSelectedItem();
        
        
        
        
        //d.getId_guide().getId_user();
        VoyagePersonalise vp = new VoyagePersonalise() ;
        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        vp =vps.findById(d.getId_vp().getId_vp());
        //System.out.println(d.getId_vp().getId_vp());
        vp.setGuide(d.getId_guide());
        vps.update_demande(vp);
        
        
        //ds.remove(d.getId_vp().getId_vp());
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Email Envoyer Avec Succées ");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
            }
        }
        );
         } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
 
    public static  String convert (java.util.Date d){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String t = df.format(d);
        return t ;
        
    }
    @FXML
    private void label_table(MouseEvent event) {
        GuideService gs = new GuideService();
        Guide g = new Guide();
        String nom = table_demande.getSelectionModel().getSelectedItem().getId_guide().getNom();
        g = gs.findByName(nom);
        this.nom.setText(g.getNom());
        this.prenom.setText(g.getPrenom());
        this.cin.setText(g.getCIN());
        this.dateN.setText(convert(g.getDateDeNaissance()));
        this.emaillabel.setText(g.getEmail());
        this.numtel.setText(Integer.toString(g.getNumtel()));
        this.note.setText(Integer.toString(g.getNote()));
        
        
        
    }
}
