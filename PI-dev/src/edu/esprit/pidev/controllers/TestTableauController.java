/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.pidev.models.VoyageOrganise;
import edu.esprit.pidev.sevices.VoyageOrganiseService;
import edu.esprit.pidev.models.Agence;
import edu.esprit.pidev.sevices.AgenceService ;
import java.io.IOException;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import javafx.fxml.Initializable;

import tray.notification.TrayNotification;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author zakiya
 */
public class TestTableauController implements Initializable {

    @FXML
    private TableView<VoyageOrganise> tabletest;
    private final ObservableList<VoyageOrganise> voyageData = FXCollections.observableArrayList();
    List<VoyageOrganise> voyages;
    @FXML
    private TableColumn<VoyageOrganise, Float> prix;
    @FXML
    private TableColumn<VoyageOrganise, Integer> nbre_dispo;
    @FXML
    private TableColumn<VoyageOrganise, Date> datedep;
    @FXML
    private TableColumn<VoyageOrganise, Date> datearrivee;
    @FXML
    private TableColumn<VoyageOrganise, String> destin;
    @FXML
    private TableColumn<VoyageOrganise, Date> dateLimiteReservation12;
    @FXML
    private TableColumn<VoyageOrganise, Integer> nombre_Reservations9;
    @FXML
    private TableColumn<VoyageOrganise, String> Descriptionnns;
    @FXML
    private JFXTextField destinatText;
    @FXML
    private JFXTextField PrixTexts;
    @FXML
    private AnchorPane Fond1;
    @FXML
    private JFXTextField nbrPlacesDisposText;
    @FXML
    private JFXTextField nbrePlacesReservesText;
    @FXML
    private JFXDatePicker DateDepartText;
    @FXML
    private JFXDatePicker DateArriveeText;
    @FXML
    private JFXDatePicker DateLimiteReservationText;
    @FXML
    private JFXButton AjouterFields;
    @FXML
    private JFXTextArea DescriptionTexttt;
    @FXML
    private JFXTextField RechercheDestText;
    @FXML
    private JFXButton modifierbu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        voyages = new ArrayList<VoyageOrganise>();
        VoyageOrganiseService voyageService = new VoyageOrganiseService();
        voyages = voyageService.getTableByIdAgence(8);
      
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        nbre_dispo.setCellValueFactory(new PropertyValueFactory<>("nbrePlacesDisp"));
        datedep.setCellValueFactory(new PropertyValueFactory<>("dateDebutVoy"));
        datearrivee.setCellValueFactory(new PropertyValueFactory<>("dateFinVoy"));
        destin.setCellValueFactory(new PropertyValueFactory<>("titreVoyage"));
        dateLimiteReservation12.setCellValueFactory(new PropertyValueFactory<>("dateLimiteRes"));
        nombre_Reservations9.setCellValueFactory(new PropertyValueFactory<>("nbrePlacesRes"));
        Descriptionnns.setCellValueFactory(new PropertyValueFactory<>("description"));

        tabletest.setItems(voyageData);
        voyageData.clear();
        voyageData.addAll(voyages);
        System.out.println(voyages.size());
    }

    private boolean validerChamps() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        ///alert.initOwner(mainStage);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Erreur de saisie");
        if (destinatText.getText().isEmpty()) {
            alert.setContentText("Veuillez Saisir la destination");
            alert.showAndWait();
            return false;

        } else if (destinatText.getText().length() < 3) {
            alert.setContentText("Veuillez Saisir une destination claire  ");
            alert.showAndWait();

            return false;
        } else if (DescriptionTexttt.getText().isEmpty()) {
            alert.setContentText("Veuillez Saisir la  description");
            alert.showAndWait();
            return false;
        } else if (PrixTexts.getText().isEmpty()) {
            alert.setContentText("Veuillez Saisir le prix");
            alert.showAndWait();
            return false;
        } else if (DescriptionTexttt.getText().length() < 20) {
            alert.setContentText("la description est tres courte ");
            alert.showAndWait();

            return false;
        } else if (nbrPlacesDisposText.getText().isEmpty()) {
            alert.setContentText("Veuillez Saisir le nombre de places disponibles");
            alert.showAndWait();
            return false;

        } else if (nbrePlacesReservesText.getText().isEmpty()) {
            alert.setContentText("Veuillez Saisir le nombre de places disponibles");
            alert.showAndWait();
            return false;
// si pas de nombre de reservés == 0 par defaut

        } else if (DateDepartText.getValue() == null) {
            alert.setContentText("Veuillez Saisir la date de départ");
            alert.showAndWait();
            return false;
        } else if (DateArriveeText.getValue() == null) {
            alert.setContentText("Veuillez Saisir la date d'arrivée");
            alert.showAndWait();
            return false;
        } else if (DateLimiteReservationText.getValue() == null) {
            alert.setContentText("Veuillez Saisir la date limite de reservation");
            alert.showAndWait();
            return false;
            // LocalTime time = LocalTime.now();
            //Date ddd = Date.valueOf(LocalDate.now());
        } else if (DateDepartText.getValue() != null && DateDepartText.getValue().compareTo(LocalDate.now()) < 0) {
            alert.setContentText("Date de départ ne peut pas etre dans le passé ");
            alert.showAndWait();
            return false;
        } else if (DateDepartText.getValue().compareTo(LocalDate.now()) == 0) {
            alert.setContentText("Date de départ ne peut pas etre aujourd'hui");
            alert.showAndWait();
            return false;
        } else if (DateLimiteReservationText.getValue() != null && DateLimiteReservationText.getValue().compareTo(LocalDate.now()) < 0) {
            alert.setContentText("Date limite de reservation ne peut pas etre dans le passé ");
            alert.showAndWait();
            return false;
        } else if (DateLimiteReservationText.getValue().compareTo(LocalDate.now()) == 0) {
            alert.setContentText("Date limite de reservation ne peut pas etre aujourd'hui");
            alert.showAndWait();
            return false;
        } else if (DateDepartText.getValue() != null && DateLimiteReservationText.getValue() != null && DateDepartText.getValue().compareTo(DateLimiteReservationText.getValue()) < 0) {
            alert.setContentText("Date de limite de reservation  est inférieure à la date de début du voyage!!");
            alert.showAndWait();
            return false;
        } else if (DateDepartText.getValue() != null && DateArriveeText.getValue() != null && DateDepartText.getValue().compareTo(DateArriveeText.getValue()) > 0) {
            alert.setContentText("Date de Départ Inférieur à la date d'arivée");
            alert.showAndWait();
            return false;

            // control saisie prix
        } else {
            return true;
        }
    }


    @FXML
    private void AjouterVoyageOrg(ActionEvent event) {
        VoyageOrganiseService servicevo = new VoyageOrganiseService();

        if (validerChamps()) {
            System.out.println("entrer a la validation ");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            // alert.initOwner(mainStage);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Création Voyage");
            alert.setContentText("Voulez vous ajouter ce voyage!");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    System.out.println("boutton ok");
                    VoyageOrganise voyage = new VoyageOrganise();
                    System.out.println("creation new voyage org");

                    voyage.setTitreVoyage(destinatText.getText());
                    System.out.println("set destination");

                    voyage.setDescription(DescriptionTexttt.getText());
                    System.out.println("set description ");

                    voyage.setDateDebutVoy(java.sql.Date.valueOf(DateDepartText.getValue()));
                    System.out.println("date depart");

                    voyage.setDateFinVoy(java.sql.Date.valueOf(DateArriveeText.getValue()));
                    System.out.println("date arrivee");

                    voyage.setDateLimiteRes(java.sql.Date.valueOf(DateLimiteReservationText.getValue()));
                    System.out.println("date limite");

                    try {
                        Float.parseFloat(PrixTexts.getText());
                    } catch (NumberFormatException e) {
                        alert.setContentText("Veillez saisir un Prix valide!!");
                        alert.showAndWait();
                    }
                    String a = PrixTexts.getText();

                    float b = Float.parseFloat(a);

                    voyage.setPrix(b);
                    try {
                        Integer.parseInt(nbrPlacesDisposText.getText());
                    } catch (NumberFormatException e) {
                        alert.setContentText("Veillez saisir un nombre de places disponibles, entier!!");
                        alert.showAndWait();
                    }
                    int nbrd = Integer.parseInt(nbrPlacesDisposText.getText());
                    voyage.setNbrePlacesDisp(nbrd);
                    System.out.println("set bnre places dispo");
                    try {
                        Integer.parseInt(nbrePlacesReservesText.getText());
                    } catch (NumberFormatException e) {
                        alert.setContentText("Veillez saisir un nombre de places reservées entier!!");
                        alert.showAndWait();
                    }
                    int nbrre = Integer.parseInt(nbrePlacesReservesText.getText());
                    voyage.setNbrePlacesRes(nbrre);
                    System.out.println("set places reservés");

                    AgenceService agservice = new AgenceService();
                    // agence id  doit etre agence connectée , ce 8 doit etre remplacé par l'id de l'agence connectée
                    Agence ag = agservice.findById(8);
                    System.out.println(ag);

                    voyage.setAgence(ag);
                            
                    System.out.println("set agence");
                    if (servicevo.AjoutCond(voyage)!=null) {
                        Alert alert1 = new Alert(Alert.AlertType.WARNING);
                        alert1.setTitle("Erreur de saisie");
                        alert1.setHeaderText("Erreur de saisie");
                        alert1.setContentText("Ce voyage existe deja");
                        alert1.showAndWait();
                    
                        
                    } else {

                        servicevo.add(voyage);

                        destinatText.setText(null);
                        PrixTexts.setText(null);
                        DateDepartText.setValue(null);
                        DateArriveeText.setValue(null);
                        DateLimiteReservationText.setValue(null);
                        nbrPlacesDisposText.setText(null);
                        nbrePlacesReservesText.setText(null);
                        DescriptionTexttt.setText(null);

                        List<VoyageOrganise> voyagesorg = new ArrayList<VoyageOrganise>();
                        VoyageOrganiseService voyageOrganiseService = new VoyageOrganiseService();

                        System.out.println(voyageOrganiseService.getTableByIdAgence(8).size());
                        voyagesorg = voyageOrganiseService.getTableByIdAgence(8);

                        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                        nbre_dispo.setCellValueFactory(new PropertyValueFactory<>("nbrePlacesDisp"));
                        datedep.setCellValueFactory(new PropertyValueFactory<>("dateDebutVoy"));
                        datearrivee.setCellValueFactory(new PropertyValueFactory<>("dateFinVoy"));
                        destin.setCellValueFactory(new PropertyValueFactory<>("titreVoyage"));
                        dateLimiteReservation12.setCellValueFactory(new PropertyValueFactory<>("dateLimiteRes"));
                        nombre_Reservations9.setCellValueFactory(new PropertyValueFactory<>("nbrePlacesRes"));
                        Descriptionnns.setCellValueFactory(new PropertyValueFactory<>("description"));

                        voyageData.clear();
                        voyageData.addAll(voyagesorg);
                        tabletest.setItems(voyageData);

                        System.out.println(voyagesorg.size());
                        tray.notification.TrayNotification tr = new TrayNotification();
                        tr.setTitle("Terminé");
                        tr.setMessage("Ajout de VOYAGE avec succès");
                        tr.setNotificationType(NotificationType.SUCCESS);
                        tr.setAnimationType(AnimationType.SLIDE);
                        tr.showAndDismiss(Duration.seconds(2));

                    }
                }

            });
        }

    }

    @FXML
    private void modifier(MouseEvent v) {

        //permet de recupurer l'objet sélectionné du tableView
        VoyageOrganise voyage = tabletest.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        int i = voyage.getDateDebutVoy().compareTo(java.sql.Date.valueOf(LocalDate.now()));

        if (voyage == null) {
            alert.setTitle("Aucune Sélection");
            alert.setHeaderText("Aucun Voyage");
            alert.setContentText("Veuillez Sélectionner un Voyage");
            alert.showAndWait();
        } else if (i < 0) {
            alert.setTitle("Voyage passé");
            alert.setHeaderText("voyage passé");
            alert.setContentText("Vous ne pouvez pas Modifier ce voyage");
            alert.showAndWait();
        } else {
            destinatText.setText(voyage.getTitreVoyage());
            DescriptionTexttt.setText(voyage.getDescription());
            DateDepartText.setValue(Instant.ofEpochMilli(voyage.getDateDebutVoy().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
            DateArriveeText.setValue(Instant.ofEpochMilli(voyage.getDateFinVoy().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
            DateLimiteReservationText.setValue(Instant.ofEpochMilli(voyage.getDateLimiteRes().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
            // le prix doit etre convertit en string .
            float p = voyage.getPrix();
            String s1 = Float.toString(p);
            PrixTexts.setText(s1);

            int i1 = voyage.getNbrePlacesDisp();
            String s2 = Integer.toString(i1);
            nbrPlacesDisposText.setText(s2);

            int i2 = voyage.getNbrePlacesRes();
            String s3 = Integer.toString(i2);
            nbrePlacesReservesText.setText(s3);

        }
    }

    @FXML
    private void Valider_Modifict(ActionEvent v) {
        VoyageOrganiseService servicevo = new VoyageOrganiseService();
        VoyageOrganise voyagesel = tabletest.getSelectionModel().getSelectedItem();
        if (voyagesel == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Acune Sélection");
            alert.setHeaderText("Aucun Evenement");
            alert.setContentText("Veuillez Sélectionner un Evenement");
            alert.showAndWait();
        } else {

            System.out.println("entrer a la validation ");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            // alert.initOwner(mainStage);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Modification Voyage");
            alert.setContentText("Voulez vous modifier!");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    System.out.println("boutton ok");
                    //  VoyageOrganise voyage = new VoyageOrganise();
                    System.out.println("modification vorg");

                    voyagesel.setTitreVoyage(destinatText.getText());
                    System.out.println("set destination");

                    voyagesel.setDescription(DescriptionTexttt.getText());
                    System.out.println("set description ");

                    voyagesel.setDateDebutVoy(java.sql.Date.valueOf(DateDepartText.getValue()));
                    System.out.println("date depart");

                    voyagesel.setDateFinVoy(java.sql.Date.valueOf(DateArriveeText.getValue()));
                    System.out.println("date arrivee");

                    voyagesel.setDateLimiteRes(java.sql.Date.valueOf(DateLimiteReservationText.getValue()));
                    System.out.println("date limite");

                    String a = PrixTexts.getText();

                    float b = Float.parseFloat(a);

                    voyagesel.setPrix(b);

                    int nbrd = Integer.parseInt(nbrPlacesDisposText.getText());
                    voyagesel.setNbrePlacesDisp(nbrd);
                    System.out.println("set bnre places dispo");

                    int nbrre = Integer.parseInt(nbrePlacesReservesText.getText());
                    voyagesel.setNbrePlacesRes(nbrre);
                    System.out.println("set places reservés");

                    servicevo.update(voyagesel);

                    destinatText.setText(null);
                    PrixTexts.setText(null);
                    DateDepartText.setValue(null);
                    DateArriveeText.setValue(null);
                    DateLimiteReservationText.setValue(null);
                    nbrPlacesDisposText.setText(null);
                    nbrePlacesReservesText.setText(null);
                    DescriptionTexttt.setText(null);

                    List<VoyageOrganise> voyagesorg = new ArrayList<VoyageOrganise>();
                    VoyageOrganiseService voyageOrganiseService = new VoyageOrganiseService();

                    System.out.println(voyageOrganiseService.getTableByIdAgence(8).size());
                    voyagesorg = voyageOrganiseService.getTableByIdAgence(8);

                    prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                    nbre_dispo.setCellValueFactory(new PropertyValueFactory<>("nbrePlacesDisp"));
                    datedep.setCellValueFactory(new PropertyValueFactory<>("dateDebutVoy"));
                    datearrivee.setCellValueFactory(new PropertyValueFactory<>("dateFinVoy"));
                    destin.setCellValueFactory(new PropertyValueFactory<>("titreVoyage"));
                    dateLimiteReservation12.setCellValueFactory(new PropertyValueFactory<>("dateLimiteRes"));
                    nombre_Reservations9.setCellValueFactory(new PropertyValueFactory<>("nbrePlacesRes"));
                    Descriptionnns.setCellValueFactory(new PropertyValueFactory<>("description"));

                    voyageData.clear();
                    voyageData.addAll(voyagesorg);
                    tabletest.setItems(voyageData);

                    System.out.println(voyagesorg.size());
                    tray.notification.TrayNotification tr = new TrayNotification();
                    tr.setTitle("Terminé");
                    tr.setMessage("cet évènement est modifié");
                    tr.setNotificationType(NotificationType.SUCCESS);
                    tr.setAnimationType(AnimationType.SLIDE);
                    tr.showAndDismiss(Duration.seconds(2));

                }

            });
        }

    }

    @FXML
    private void Supprimerclick(ActionEvent event) {
        VoyageOrganise voyage = tabletest.getSelectionModel().getSelectedItem();

        if (voyage == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Acune Sélection");
            alert.setHeaderText("Aucun Voyage");
            alert.setContentText("Veuillez Sélectionner un Voyage");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Suppression Voyage");
            alert.setContentText("Veuillez Confirmer la Suppression");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {

                    VoyageOrganiseService VOservice = new VoyageOrganiseService();
                    if (voyage.getNbrePlacesRes() != 0) {
                        Alert alert2 = new Alert(Alert.AlertType.WARNING);
                        alert2.setTitle("Veuillez informer vos clients avant de supprimer");
                        alert2.setHeaderText("Nombre de places reservés non nul");
                        alert2.setContentText("Veuillez informer vos clients avant de supprimer");
                        alert2.showAndWait();
                    } else {
                        VOservice.remove(voyage.getId_voyage());
                        List<VoyageOrganise> voyageso = new ArrayList<VoyageOrganise>();
                        voyageso = VOservice.getTableByIdAgence(8);
                        voyageData.clear();
                        voyageData.addAll(voyageso);
                        tabletest.setItems(voyageData);

                        destinatText.setText(null);
                        PrixTexts.setText(null);
                        DateDepartText.setValue(null);
                        DateArriveeText.setValue(null);
                        DateLimiteReservationText.setValue(null);
                        nbrPlacesDisposText.setText(null);
                        nbrePlacesReservesText.setText(null);
                        DescriptionTexttt.setText(null);

                        tray.notification.TrayNotification tr = new TrayNotification();
                        tr.setTitle("Terminé");
                        tr.setMessage("supression avec succés");
                        tr.setNotificationType(NotificationType.NOTICE);
                        tr.setAnimationType(AnimationType.POPUP);
                        tr.showAndDismiss(Duration.seconds(2));
                    }
                }
            });
        }
    }

    public void recherche() {

       /* RechercheDestText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                voyageData.clear();
                voyageData.addAll(voyages
                        .stream()
                        .filter(e
                                -> e.getTitreVoyage().contains(RechercheDestText.getText()))
                        .collect(Collectors.toList())
                );
                tabletest.setItems(voyageData);

            }
        });*/

    }

    @FXML
    private void recherchemouse(MouseEvent event) {
        recherche();
    }

    @FXML
    private void RechercheParDate(ActionEvent event) {
    }

    
  
    

    @FXML
    private void Cancel(ActionEvent event) {
        destinatText.setText(null);
        PrixTexts.setText(null);
        DateDepartText.setValue(null);
        DateArriveeText.setValue(null);
        DateLimiteReservationText.setValue(null);
        nbrPlacesDisposText.setText(null);
        nbrePlacesReservesText.setText(null);
        DescriptionTexttt.setText(null);
    }

    @FXML
    private void retourAccueil(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccueilAgence.fxml"));
            System.out.println("pathgood");

            Parent root = fxmlLoader.load();
            System.out.println("pane");
            AccueilAgenceController cntrl = fxmlLoader.getController();
            Fond1.getScene().setRoot(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TableView<VoyageOrganise> getTabletest() {
        return tabletest;
    }

    public ObservableList<VoyageOrganise> getVoyageData() {
        return voyageData;
    }

    public List<VoyageOrganise> getVoyages() {
        return voyages;
    }

    public TableColumn<VoyageOrganise, Integer> getNbre_dispo() {
        return nbre_dispo;
    }

    public TableColumn<VoyageOrganise, Date> getDatedep() {
        return datedep;
    }

    public TableColumn<VoyageOrganise, Date> getDatearrivee() {
        return datearrivee;
    }

    public TableColumn<VoyageOrganise, String> getDestin() {
        return destin;
    }

    public TableColumn<VoyageOrganise, Date> getDateLimiteReservation12() {
        return dateLimiteReservation12;
    }

    public TableColumn<VoyageOrganise, String> getDescriptionnns() {
        return Descriptionnns;
    }

    public AnchorPane getFond1() {
        return Fond1;
    }

    public void setTabletest(TableView<VoyageOrganise> tabletest) {
        this.tabletest = tabletest;
    }

    public void setVoyages(List<VoyageOrganise> voyages) {
        this.voyages = voyages;
    }

    public void setPrix(TableColumn<VoyageOrganise, Float> prix) {
        this.prix = prix;
    }

    public void setNbre_dispo(TableColumn<VoyageOrganise, Integer> nbre_dispo) {
        this.nbre_dispo = nbre_dispo;
    }

    public void setDatedep(TableColumn<VoyageOrganise, Date> datedep) {
        this.datedep = datedep;
    }

    public void setDatearrivee(TableColumn<VoyageOrganise, Date> datearrivee) {
        this.datearrivee = datearrivee;
    }

    public void setDestin(TableColumn<VoyageOrganise, String> destin) {
        this.destin = destin;
    }

    public void setDateLimiteReservation12(TableColumn<VoyageOrganise, Date> dateLimiteReservation12) {
        this.dateLimiteReservation12 = dateLimiteReservation12;
    }

    public void setNombre_Reservations9(TableColumn<VoyageOrganise, Integer> nombre_Reservations9) {
        this.nombre_Reservations9 = nombre_Reservations9;
    }

    public void setDescriptionnns(TableColumn<VoyageOrganise, String> Descriptionnns) {
        this.Descriptionnns = Descriptionnns;
    }

}
