/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package edu.esprit.pidev.models;

import java.util.Objects;

/**
 *
 * @author Ahmed
 */
public class Hotel extends Users{
    
    
    
    
    private int etoile ;
    private int nb_chambre ;
    private int nb_chambre_reserve ;
    

    public Hotel( int id_user, String nom, String email, String mdp, int numtel, String adresse, String role, String image,int etoile, int nb_chambre, int nb_chambre_reserve) {
        super(id_user, nom, email, mdp, numtel, adresse, role, image);
        this.etoile = etoile;
        this.nb_chambre = nb_chambre;
        this.nb_chambre_reserve = nb_chambre_reserve;
    }

    public void setNb_chambre_reserve(int nb_chambre_reserve) {
        this.nb_chambre_reserve = nb_chambre_reserve;
    }

    public int getNb_chambre_reserve() {
        return nb_chambre_reserve;
    }

    public Hotel() {
    }

    
    public int getEtoile() {
        return etoile;
    }

    public void setEtoile(int etoile) {
        this.etoile = etoile;
    }

    public int getNb_chambre() {
        return nb_chambre;
    }

    public void setNb_chambre(int nb_chambre) {
        this.nb_chambre = nb_chambre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return super.toString()+"Hotel{" + "etoile=" + etoile + ", nb_chambre=" + nb_chambre + ", nb_chambre_reserve=" + nb_chambre_reserve + '}';
    }

    

    
   

    

    
    
}