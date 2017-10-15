/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import java.util.logging.Logger;

/**
 *
 * @author Ahmed
 */
public class VoyagePersonalise  {
    
    private int id_vp ;
    private String nom ;
    private String ville_depart ;
    private String Ville_arrive ;
    private String date_depart ;
    private String date_arrive ;
    private int nbr_participant ;
    private Hotel hotel ;
    private Client client ;

    public VoyagePersonalise() {
    }

    public VoyagePersonalise(int id_vp, String nom, String ville_depart, String Ville_arrive, String date_depart, String date_arrive, int nbr_participant, Client client,Hotel hotel) {
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
  /*
    public VoyagePersonalise(int i, String nomff, String ville_departfff, String ville_arriveff, String date_departf, String fdate_arrive, int i0, Client c2, Hotel h1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
/*
    public VoyagePersonalise(int aInt, String string, String string0, String string1, String string2, String string3, Client findById, Hotel findById0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

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

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getDate_arrive() {
        return date_arrive;
    }

    public void setDate_arrive(String date_arrive) {
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

    @Override
    public String toString() {
        return "VoyagePersonalise{" + "id_vp=" + id_vp + ", nom=" + nom + ", ville_depart=" + ville_depart + ", Ville_arrive=" + Ville_arrive + 
                ", date_depart=" + date_depart + ", date_arrive=" + date_arrive + ", nbr_participant=" + nbr_participant + 
                ", \n client=" + client + "\n , hotel=" + hotel+ '}';
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

   
}
