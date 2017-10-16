/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import edu.esprit.pidev.models.Client;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author nouha
 */
public class Vol {
    private int numTicket;
    private Date date_depart;
    private Date date_arrivee;
    private Double prix_vol;
    private String nom_Vol;
    private Client client;
    private String depart;
    private String arrivee;
    private String nom_Compagnie;
    
    
    public Vol() {
    }

    public Vol(int numTicket, String num_Vol) {
        this.numTicket = numTicket;
        this.nom_Vol = num_Vol;
        
    }
    

    public Vol(int numTicket, Date date_depart, Date date_arrivee, Double prix_vol) {
        this.numTicket = numTicket;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.prix_vol = prix_vol;
    }

   

    public Vol(Date date_depart, Date date_arrivee, Double prix_vol, String nom_Vol, Client client, String depart, String arrivee, String nom_Compagnie) {
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.prix_vol = prix_vol;
        this.nom_Vol = nom_Vol;
        this.client = client;
        this.depart = depart;
        this.arrivee = arrivee;
        this.nom_Compagnie = nom_Compagnie;
    }

    
    public Vol(int numTicket, Date date_depart, Date date_arrivee, Double prix_vol, String nom_Vol, Client client, String depart, String arrivee, String nom_Compagnie) {
        this.numTicket = numTicket;
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.prix_vol = prix_vol;
        this.nom_Vol = nom_Vol;
        this.client = client;
        this.depart = depart;
        this.arrivee = arrivee;
        this.nom_Compagnie = nom_Compagnie;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public Double getPrix_vol() {
        return prix_vol;
    }

    public void setPrix_vol(Double prix_vol) {
        this.prix_vol = prix_vol;
    }

    public String getNom_Vol() {
        return nom_Vol;
    }

    public void setNom_Vol(String nom_Vol) {
        this.nom_Vol = nom_Vol;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public String getNom_Compagnie() {
        return nom_Compagnie;
    }

    public void setNom_Compagnie(String nom_Compagnie) {
        this.nom_Compagnie = nom_Compagnie;
    }

    @Override
    public String toString() {
        return "Vol{" + "numTicket=" + numTicket + ", date_depart=" + date_depart + ", date_arrivee=" + date_arrivee + ", prix_vol=" + prix_vol + ", nom_Vol=" + nom_Vol + ", client=" + client.toString() + ", depart=" + depart + ", arrivee=" + arrivee + ", nom_Compagnie=" + nom_Compagnie + '}';
    }

    /**
     *
     * @param obj
     * @return
     */
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
        final Vol other = (Vol) obj;
        if (!Objects.equals(this.numTicket, other.numTicket)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.numTicket);
        hash = 89 * hash + Objects.hashCode(this.date_depart);
        hash = 89 * hash + Objects.hashCode(this.date_arrivee);
        hash = 89 * hash + Objects.hashCode(this.prix_vol);
        hash = 89 * hash + Objects.hashCode(this.nom_Vol);
        hash = 89 * hash + Objects.hashCode(this.client);
        hash = 89 * hash + Objects.hashCode(this.depart);
        hash = 89 * hash + Objects.hashCode(this.arrivee);
        hash = 89 * hash + Objects.hashCode(this.nom_Compagnie);
        return hash;
    }
    
    

    
    
    
    
    
}
