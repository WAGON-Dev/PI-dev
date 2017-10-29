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
public class Reservation {
    private Client id_client;
    private String type_reservation;
    private int id_reservation ;
    private double prix ;

    public Reservation(Client id_client, String type_reservation, int id_reservation, double prix) {
        this.id_client = id_client;
        this.type_reservation = type_reservation;
        this.id_reservation = id_reservation;
        this.prix = prix;
    }


    public Reservation() {
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    public String getType_reservation() {
        return type_reservation;
    }

    public void setType_reservation(String type_reservation) {
        this.type_reservation = type_reservation;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id_client);
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
        final Reservation other = (Reservation) obj;
        if (this.id_reservation != other.id_reservation) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.type_reservation, other.type_reservation)) {
            return false;
        }
        if (!Objects.equals(this.id_client, other.id_client)) {
            return false;
        }
        return true;
    }

    

    

    @Override
    public String toString() {
        return "Reservation{" + "id_client=" + id_client + ", type_reservation=" + type_reservation + ", id_reservation=" + id_reservation + ", prix=" + prix + '}';
    }
    
    
}
