/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.models;
import java.util.Objects;


public class Agence extends Users {
     int nbr_voyage_organise ;

    public Agence() {
        
    }

    public Agence(String nom) {
        super(nom);
    }

    public Agence(int id_user, String nom) {
        super(id_user, nom);
    }

    public Agence(int id_user, String nom, String email, String mdp, int numtel, String adresse,int nbr_voyage_organise) {
        super(id_user, nom, email, mdp, numtel, adresse);
        this.nbr_voyage_organise = nbr_voyage_organise;
    }

    public Agence( String role, String nom, String email, String mdp, int numtel, String adresse,int nbr_voyage_organise) {
        super(nom, email, mdp, numtel, adresse,role);
        this.nbr_voyage_organise = nbr_voyage_organise;
    }    

    public Agence( String role, int id_user, String nom, String email, String mdp, int numtel, String adresse,int nbr_voyage_organise) {
        super(role, id_user, nom, email, mdp, numtel, adresse);
        this.nbr_voyage_organise = nbr_voyage_organise;
    }

    public Agence( String nom, String email, String mdp,int numtel, String adresse,int nbr_voyage_organise) {
        super( nom, email,mdp, numtel, adresse);
        this.nbr_voyage_organise = nbr_voyage_organise;
    }

    
    public int getNbr_voyage_organise() {
        return nbr_voyage_organise;
    }

    public void setNbr_voyage_organise(int nbr_voyage_organise) {
        this.nbr_voyage_organise = nbr_voyage_organise;
    }
    
    @Override
    public String toString() {
  
      return "{Agence : "+ id_user + " nom " + nom + " email: " +email+ " adresse"+adresse+" nbr voyages org: " +nbr_voyage_organise  + " } " ; 
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
        final Agence other = (Agence) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        return true;
    }
}