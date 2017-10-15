/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Client extends Users {

    String prenom;
    String cin;
    String dateNaissence;

    public Client(String prenom, String cin, String dateNaissence) {
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
    }

    public Client(int id_user, String nom, String email, String mdp, int numtel, String adresse, String role, String image,String prenom, String cin, String dateNaissence) {
        super(id_user, nom, email, mdp, numtel, adresse, role, image);
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
    }

    public Client(String prenom, String cin, String dateNaissence, String nom, String email, String mdp, int numtel, String adresse, String role, String image) {
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

    public String getDateNaissence() {
        return dateNaissence;
    }

    public void setDateNaissence(String dateNaissence) {
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
}
