/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import java.util.Date;



/**
 *
 * @author nouha
 */
public class Admin extends Users{
    private String prenom;
     private String cin;
    private Date dateNaissence;

    public Admin(String prenom, String cin, Date dateNaissence) {
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
    }

    public Admin(int id_user, String nom, String email, String mdp, int numtel, String adresse, String role, String image,String prenom, String cin, Date dateNaissence) {
        super(id_user, nom, email, mdp, numtel, adresse, role, image);
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
    }

    public Admin(String prenom, String cin, Date dateNaissence, String nom, String email, String mdp, int numtel, String adresse, String role, String image) {
        super(nom, email, mdp, numtel, adresse, role, image);
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissence = dateNaissence;
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
    public String toString() {
        return "Admin{"+super.toString()+ " ,prenom=" + prenom + ", cin=" + cin + ", dateNaissence=" + dateNaissence + '}';
    }
     
    
    
    
   
    
    
    
    
    
    
}
