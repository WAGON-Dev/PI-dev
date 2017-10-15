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
public class Users {
    String id_user ;
    String nom ; 
    String email ;
    String mdp ;
    Number numtel ;
    String adresse ;
    String role ;
    String image;

    public Users() {
    }

    public Users(String id_user, String nom, String email, String mdp, Number numtel, String adresse, String role, String image) {
        this.id_user = id_user;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.numtel = numtel;
        this.adresse = adresse;
        this.role = role;
        this.image = image;
    }

    public Users(String nom, String email, String mdp, Number numtel, String adresse, String role, String image) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.numtel = numtel;
        this.adresse = adresse;
        this.role = role;
        this.image = image;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Number getNumtel() {
        return numtel;
    }

    public void setNumtel(Number numtel) {
        this.numtel = numtel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Users{" + "id_user=" + id_user + ", nom=" + nom + ", email=" + email + ", mdp=" + mdp + ", numtel=" + numtel + ", adresse=" + adresse + ", role=" + role + ", image=" + image + '}';
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
        final Users other = (Users) obj;
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }

        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    
    
}
