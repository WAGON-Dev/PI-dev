/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;

import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author zakiya
 */
public class VoyageOrganise {
    // nbreplaces .. // fk agence  // tri // Date 

    private int id_voyage;
    private String titreVoyage;
    private Date dateDebutVoy;
    private Date dateFinVoy;
    private String description;
    private float prix;
    private Date dateLimiteRes;
    private int nbrePlacesDisp;
    private int nbrePlacesRes;
    private Agence agence;

    public VoyageOrganise() {
    }

    public VoyageOrganise(String titreVoyage,float prix, Date dateDebutVoy, Date dateFinVoy, Date dateLimiteRes, int nbrePlacesDisp, int nbrePlacesRes,String description) {
        this.titreVoyage = titreVoyage;
        this.prix = prix;
        this.dateDebutVoy = dateDebutVoy;
        this.dateFinVoy = dateFinVoy;
        this.dateLimiteRes = dateLimiteRes;
        this.nbrePlacesDisp = nbrePlacesDisp;
        this.nbrePlacesRes = nbrePlacesRes;
          this.description = description;
    } 
    
    public VoyageOrganise(String titreVoyage, Date dateDebutVoy, Date dateFinVoy, String description, float prix, Date dateLimiteRes, int nbrePlacesDisp, int nbrePlacesRes, Agence agence) {
        this.titreVoyage = titreVoyage;
        this.dateDebutVoy = dateDebutVoy;
        this.dateFinVoy = dateFinVoy;
        this.description = description;
        this.prix = prix;
        this.dateLimiteRes = dateLimiteRes;
        this.nbrePlacesDisp = nbrePlacesDisp;
        this.nbrePlacesRes = nbrePlacesRes;
        this.agence = agence;
    }


    public VoyageOrganise(int id_voyage, String titreVoyage, Date dateDebutVoy, Date dateFinVoy, String description, float prix, Date dateLimiteRes, int nbrePlacesDisp, int nbrePlacesRes, Agence agence) {
        this.id_voyage = id_voyage;
        this.titreVoyage = titreVoyage;
        this.dateDebutVoy = dateDebutVoy;
        this.dateFinVoy = dateFinVoy;
        this.description = description;
        this.prix = prix;
        this.dateLimiteRes = dateLimiteRes;
        this.nbrePlacesDisp = nbrePlacesDisp;
        this.nbrePlacesRes = nbrePlacesRes;
        this.agence = agence;
    }


    public VoyageOrganise(int id_voyage, String titreVoyage, Date dateDebutVoy, Date dateFinVoy, String description, float prix) {
        this.id_voyage = id_voyage;
        this.titreVoyage = titreVoyage;
        this.dateDebutVoy = dateDebutVoy;
        this.dateFinVoy = dateFinVoy;
        this.description = description;
        this.prix = prix;
    }

    public VoyageOrganise(String titreVoyage, String description) {
        this.titreVoyage = titreVoyage;
        this.description = description;
    }

    public VoyageOrganise(int id_voyage, String titreVoyage, Date dateDebutVoy, Date dateFinVoy, String description) {
        this.id_voyage = id_voyage;
        this.titreVoyage = titreVoyage;
        this.dateDebutVoy = dateDebutVoy;
        this.dateFinVoy = dateFinVoy;
        this.description = description;

    }

    public VoyageOrganise(int id_voyage, String titreVoyage, String description) {
        this.id_voyage = id_voyage;
        this.titreVoyage = titreVoyage;
        this.description = description;
    }

    public VoyageOrganise(String titreVoyage, Date dateDebutVoy, Date dateFinVoy, String description) {

        this.titreVoyage = titreVoyage;
        this.dateDebutVoy = dateDebutVoy;
        this.dateFinVoy = dateFinVoy;
        this.description = description;

    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_voyage() {
        return id_voyage;
    }

    public String getTitreVoyage() {
        return titreVoyage;
    }

    public Date getDateDebutVoy() {
        return dateDebutVoy;
    }

    public Date getDateFinVoy() {
        return dateFinVoy;
    }

    public String getDescription() {
        return description;
    }

    public void setId_voyage(int id_voyage) {
        this.id_voyage = id_voyage;
    }

    public void setTitreVoyage(String titreVoyage) {
        this.titreVoyage = titreVoyage;
    }

    public void setDateDebutVoy(Date dateDebutVoy) {
        this.dateDebutVoy = dateDebutVoy;
    }

    public void setDateFinVoy(Date dateFinVoy) {
        this.dateFinVoy = dateFinVoy;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateLimiteRes() {
        return dateLimiteRes;
    }

    public int getNbrePlacesDisp() {
        return nbrePlacesDisp;
    }

    public int getNbrePlacesRes() {
        return nbrePlacesRes;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setDateLimiteRes(Date dateLimiteRes) {
        this.dateLimiteRes = dateLimiteRes;
    }

    public void setNbrePlacesDisp(int nbrePlacesDisp) {
        this.nbrePlacesDisp = nbrePlacesDisp;
    }

    public void setNbrePlacesRes(int nbrePlacesRes) {
        this.nbrePlacesRes = nbrePlacesRes;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
    
    @Override
    public String toString() {
        return "VoyageOrganise{" + "id_voyage=" + id_voyage + ", agence=" + agence + ", titreVoyage=" + titreVoyage + ", dateDebutVoy=" + dateDebutVoy + ", dateFinVoy=" + dateFinVoy + ", description=" + description + ", prix=" + prix + ", dateLimiteRes=" + dateLimiteRes + ", nbrePlacesDisp=" + nbrePlacesDisp + ", nbrePlacesRes=" + nbrePlacesRes + '}';
    }

    public String toStringmodif() {
        return  " Destination: " + titreVoyage + " Prix : " + prix + "  Date de départ " + dateDebutVoy + " Date d'arrivée : " + dateFinVoy + "Date Limite de resevation" + dateLimiteRes+ 
                " \nNbrePlacesDispo "  + nbrePlacesDisp + " nbrePlacesReservées" + nbrePlacesRes  ;
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
        final VoyageOrganise other = (VoyageOrganise) obj;
        if (this.id_voyage != other.id_voyage) {
            return false;
        }
        return true;
    }
   
        public boolean equalsvoy(VoyageOrganise voy) {

           return (this.titreVoyage == voy.titreVoyage) &&(this.dateDebutVoy==voy.dateDebutVoy)&&(this.dateFinVoy==voy.dateFinVoy);




}
}
