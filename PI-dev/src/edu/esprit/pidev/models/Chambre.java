/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import java.util.Objects;

/**
 *
 * @author Ghassen
 */
public class Chambre {
    
    int id;
    String Type;
    double prix;
    Client Client_fk;
    Hotel Hotel_fk;

    public Chambre(){
    }
    
    public Chambre(int id, String Type, double prix, Client Client_fk, Hotel Hotel_fk) {
        this.id = id;
        this.Type = Type;
        this.prix = prix;
        this.Client_fk = Client_fk;
        this.Hotel_fk = Hotel_fk;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return Type;
    }

    public double getPrix() {
        return prix;
    }

    public Client getClient_fk() {
        return Client_fk;
    }

    public Hotel getHotel_fk() {
        return Hotel_fk;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setClient_fk(Client Client_fk) {
        this.Client_fk = Client_fk;
    }

    public void setHotel_fk(Hotel Hotel_fk) {
        this.Hotel_fk = Hotel_fk;
    }

    @Override
    public String toString() {
        return "Chambre{" + "id=" + id + ", Type=" + Type + ", prix=" + prix + ", Client_fk=" + Client_fk + ", Hotel_fk=" + Hotel_fk + '}';
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
        final Chambre other = (Chambre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.Type, other.Type)) {
            return false;
        }
        if (!Objects.equals(this.Client_fk, other.Client_fk)) {
            return false;
        }
        if (!Objects.equals(this.Hotel_fk, other.Hotel_fk)) {
            return false;
        }
        return true;
    }
    
    
}
