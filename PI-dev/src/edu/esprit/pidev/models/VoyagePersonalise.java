/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed
 */
public class VoyagePersonalise  {
    
    private int id_vp;
    private String nom;
    private String ville_depart;
    private String Ville_arrive;
    private Date date_depart;
    private Date date_arrive;
    private int nbr_participant;
    private Hotel hotel;
    private Client client;
    private Evenement event1;
    private Evenement event2;
    private Evenement event3;
    private String nom_hotel ;

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public VoyagePersonalise(int id_vp, String nom, String ville_depart, String Ville_arrive, Date date_depart, Date date_arrive, int nbr_participant, String nom_hotel, Client client, Evenement event1, Evenement event2, Evenement event3) {
        this.id_vp = id_vp;
        this.nom = nom;
        this.ville_depart = ville_depart;
        this.Ville_arrive = Ville_arrive;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.nbr_participant = nbr_participant;
        this.client = client;
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
        this.nom_hotel = nom_hotel;
    }
    
    

    public VoyagePersonalise() {
    }

    /*public VoyagePersonalise(int id_vp, String nom, String ville_depart, String Ville_arrive, Date date_depart, Date date_arrive, int nbr_participant, int id_hotel, Client client, Evenement event1, Evenement event2, Evenement event3) {
        this.id_vp = id_vp;
        this.nom = nom;
        this.ville_depart = ville_depart;
        this.Ville_arrive = Ville_arrive;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.nbr_participant = nbr_participant;
        this.client = client;
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
        this.id_hotel = id_hotel;
    }*/

    public VoyagePersonalise(int id_vp, String nom, String ville_depart, String Ville_arrive, Date date_depart, Date date_arrive, int nbr_participant, Hotel hotel, Client client) {
        this.id_vp = id_vp;
        this.nom = nom;
        this.ville_depart = ville_depart;
        this.Ville_arrive = Ville_arrive;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.nbr_participant = nbr_participant;
        this.hotel = hotel;
        this.client = client;
    }

    public VoyagePersonalise(int id_vp, String nom, String ville_depart, String Ville_arrive, Date date_depart, Date date_arrive, int nbr_participant, Hotel hotel, Client client, Evenement event1) {
        this.id_vp = id_vp;
        this.nom = nom;
        this.ville_depart = ville_depart;
        this.Ville_arrive = Ville_arrive;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.nbr_participant = nbr_participant;
        this.hotel = hotel;
        this.client = client;
        this.event1 = event1;
    }

    public VoyagePersonalise(int id_vp, String nom, String ville_depart, String Ville_arrive, Date date_depart, Date date_arrive, int nbr_participant, Hotel hotel, Client client, Evenement event1, Evenement event2) {
        this.id_vp = id_vp;
        this.nom = nom;
        this.ville_depart = ville_depart;
        this.Ville_arrive = Ville_arrive;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.nbr_participant = nbr_participant;
        this.hotel = hotel;
        this.client = client;
        this.event1 = event1;
        this.event2 = event2;
    }

    public VoyagePersonalise(int id_vp, String nom, String ville_depart, String Ville_arrive, Date date_depart, Date date_arrive, int nbr_participant, Hotel hotel, Client client, Evenement event1, Evenement event2, Evenement event3) {
        this.id_vp = id_vp;
        this.nom = nom;
        this.ville_depart = ville_depart;
        this.Ville_arrive = Ville_arrive;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.nbr_participant = nbr_participant;
        this.hotel = hotel;
        this.client = client;
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
    }

    public int getId_vp() {
        return id_vp;
    }

    public void setId_vp(int id_vp) {
        this.id_vp = id_vp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getVille_arrive() {
        return Ville_arrive;
    }

    public void setVille_arrive(String Ville_arrive) {
        this.Ville_arrive = Ville_arrive;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arrive() {
        return date_arrive;
    }

    public void setDate_arrive(Date date_arrive) {
        this.date_arrive = date_arrive;
    }

    public int getNbr_participant() {
        return nbr_participant;
    }

    public void setNbr_participant(int nbr_participant) {
        this.nbr_participant = nbr_participant;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Evenement getEvent1() {
        return event1;
    }

    public void setEvent1(Evenement event1) {
        this.event1 = event1;
    }

    public Evenement getEvent2() {
        return event2;
    }

    public void setEvent2(Evenement event2) {
        this.event2 = event2;
    }

    public Evenement getEvent3() {
        return event3;
    }

    public void setEvent3(Evenement event3) {
        this.event3 = event3;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VoyagePersonalise other = (VoyagePersonalise) obj;
        if (this.id_vp != other.id_vp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VoyagePersonalise{" + "id_vp=" + id_vp + ", nom=" + nom + ", ville_depart=" + ville_depart + ", Ville_arrive=" + Ville_arrive + ", date_depart=" + date_depart + ", date_arrive=" + date_arrive + ", nbr_participant=" + nbr_participant + ", hotel=" + hotel + ", client=" + client + ", event1=" + event1.toString() + ", event2=" + event2.toString() + ", event3=" + event3.toString() + '}';
    }
    /* public java.sql.Date convert (String date) throws ParseException{
   
      
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
     
    java.util.Date date1 = sdf1.parse(date);
    
    
    
    java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
   
    
    return sqlDate ;  
    } */


   
   
}
