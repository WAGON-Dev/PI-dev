/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Evenement {
    int id_evenement;
    String activite;
    Date date_activite;
    String emplacement;

    public Evenement() {
    }

    public Evenement(int id_evenement, String activite, Date date_activite, String emplacement) {
        this.id_evenement = id_evenement;
        this.activite = activite;
        this.date_activite = date_activite;
        this.emplacement = emplacement;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public Date getDate_activite() {
        return date_activite;
    }

    public void setDate_activite(Date date_depart) {
        this.date_activite = date_depart;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_evenement=" + id_evenement + ", activite=" + activite + ", date_depart=" + date_activite + ", emplacement=" + emplacement + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id_evenement;
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
        final Evenement other = (Evenement) obj;
        if (this.id_evenement != other.id_evenement) {
            return false;
        }
        return true;
    }
    
    
    
}
