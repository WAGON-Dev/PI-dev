/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

/**
 *
 * @author Ahmed
 */
public class Demande {
    
    private int id_vp ;
    private int id_guide ;
    private  int id_client ;

    public Demande(int id_vp, int id_client, int id_guide) {
        this.id_vp = id_vp;
        this.id_guide = id_guide;
        this.id_client = id_client;
    }

    public Demande() {
    }

    public int getId_vp() {
        return id_vp;
    }

    public void setId_vp(int id_vp) {
        this.id_vp = id_vp;
    }

    public int getId_guide() {
        return id_guide;
    }

    public void setId_guide(int id_guide) {
        this.id_guide = id_guide;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Demande{" + "id_vp=" + id_vp + ", id_guide=" + id_guide + ", id_client=" + id_client + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        if (this.id_vp != other.id_vp) {
            return false;
        }
        return true;
    }
    
    
    
    
}
