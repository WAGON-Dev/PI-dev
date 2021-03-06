/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Asus
 */

public class Client extends Users {

    String prenom;
    String cin;
    Date dateNaissence;
    
    public Client(String prenom, String cin, Date dateNaissence) {
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
    }

    public Client(int id_user, String nom, String email, String mdp, int numtel, String adresse, String role, String image,String prenom, String cin, Date dateNaissence) {
        super(id_user, nom, email, mdp, numtel, adresse, role, image);
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
    }

    public Client(String prenom, String cin, Date dateNaissence, String nom, String email, String mdp, int numtel, String adresse, String role, String image) {
        super(nom, email, mdp, numtel, adresse, role, image);
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
    }

    public Client() {

    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateNaissence() {
        return dateNaissence;
    }

    public void setDateNaissence(Date dateNaissence) {
        this.dateNaissence = dateNaissence;
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" +super.toString()+ "prenom=" + prenom + ", cin=" + cin + ", dateNaissence=" + dateNaissence + '}';
    }
    
}
