/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

/**
 *
 * @author omarfarouk
 */
public class CarRental extends Users  {
    private int stars;// for rating the car rental Service etoile in database
    private int carNbre;// How many cars does a carRental have nbr_voiture in database
    
    public CarRental() {
    }

    public CarRental(int stars, int carNbre, int id_user, String nom, String email, String mdp, int numtel, String adresse, String role, String image) {
        super(id_user, nom, email, mdp, numtel, adresse, role, image);
        this.stars = stars;
        this.carNbre = carNbre;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getCarNbre() {
        return carNbre;
    }

    public void setCarNbre(int carNbre) {
        this.carNbre = carNbre;
    }

    

    @Override
    public String toString() {
        return "CarRental{"+super.toString()+ + '}';
    }
    
    
    
}
