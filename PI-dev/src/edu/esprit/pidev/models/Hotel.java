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
public class Hotel {
    
    private int id ;
    private String nom ;
    private String addresse ;
    private int etoile ;
    

    public Hotel(int id, String nom, String addresse, int etoile) {
        this.id = id;
        this.nom = nom;
        this.addresse = addresse;
        this.etoile = etoile;
    }

    public Hotel() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public int getEtoile() {
        return etoile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public void setEtoile(int etoile) {
        this.etoile = etoile;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", nom=" + nom + ", addresse=" + addresse + ", etoile=" + etoile + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Hotel other = (Hotel) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.etoile != other.etoile) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.addresse, other.addresse)) {
            return false;
        }
        return true;
    }
    
    
    
}
