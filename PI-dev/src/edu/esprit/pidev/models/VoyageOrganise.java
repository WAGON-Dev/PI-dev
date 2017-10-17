/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;
import java.sql.Date;
/**
 *
 * @author zakiya
 */
public class VoyageOrganise {
  
  int id_voyage ; 
  String titreVoyage ;
  Date dateDebutVoy;
  Date dateFinVoy ;
  String description ; 
  float prix ;



    public VoyageOrganise() {
    }

    public VoyageOrganise(String titreVoyage, String description) {
        this.titreVoyage = titreVoyage;
        this.description = description;
    }

    public VoyageOrganise(int id_voyage, String titreVoyage, Date dateDebutVoy, Date dateFinVoy, String description, float prix) {
        this.id_voyage = id_voyage;
        this.titreVoyage = titreVoyage;
        this.dateDebutVoy = dateDebutVoy;
        this.dateFinVoy = dateFinVoy;
        this.description = description;
        this.prix = prix;
    }
  
    public VoyageOrganise(int id_voyage, String titreVoyage, Date dateDebutVoy, Date dateFinVoy, String description) {
        this.id_voyage = id_voyage;
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

    public VoyageOrganise(int id_voyage, String titreVoyage, String description) {
        this.id_voyage = id_voyage;
        this.titreVoyage = titreVoyage;
        this.description = description;
    }
    
    public VoyageOrganise( String titreVoyage, Date dateDebutVoy, Date dateFinVoy, String description) {
      
        this.titreVoyage = titreVoyage;
        this.dateDebutVoy = dateDebutVoy;
        this.dateFinVoy = dateFinVoy;
        this.description = description;
   
    
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

@Override
    public String toString() {
   
      return "{voyage : "+ id_voyage+ " Titre " + titreVoyage + " date debut : " +dateDebutVoy+ " date fin "+dateFinVoy+" Description: " +description  + " } " ; 
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
   
  
   
}
