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
public class Demande {
    
     
    private VoyagePersonalise id_vp ;
    private Guide id_guide ;
    private  Client id_client ;

    public Demande() {
    }

 
    
    public Demande(VoyagePersonalise id_vp, Guide id_guide, Client id_client) {
        this.id_vp = id_vp;
        this.id_guide = id_guide;
        this.id_client = id_client;
    }

    public VoyagePersonalise getId_vp() {
        return id_vp;
    }

    public void setId_vp(VoyagePersonalise id_vp) {
        this.id_vp = id_vp;
    }

    public Guide getId_guide() {
        return id_guide;
    }

    public void setId_guide(Guide id_guide) {
        this.id_guide = id_guide;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Demande{" + "id_vp=" + id_vp + ", id_guide=" + id_guide + ", id_client=" + id_client + '}';
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
        final Demande other = (Demande) obj;
        if (!Objects.equals(this.id_vp, other.id_vp)) {
            return false;
        }
        if (!Objects.equals(this.id_guide, other.id_guide)) {
            return false;
        }
        if (!Objects.equals(this.id_client, other.id_client)) {
            return false;
        }
        return true;
    }

    

  
}
