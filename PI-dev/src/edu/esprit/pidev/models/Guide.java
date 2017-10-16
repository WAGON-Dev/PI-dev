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
public class Guide extends Users{

    String prenom;
    String CIN;
    String dateDeNaissance;
    int nbrNote;
    int Note;

    public Guide(String prenom, String CIN, String dateDeNaissance, int nbrNote, int Note) {
        this.prenom = prenom;
        this.CIN = CIN;
        this.dateDeNaissance = dateDeNaissance;
        this.nbrNote = nbrNote;
        this.Note = Note;
    }

    public Guide(String prenom, String CIN, String dateDeNaissance, int nbrNote, int Note, int id_user, String nom, String email, String mdp, int numtel, String adresse, String role, String image) {
        super(id_user, nom, email, mdp, numtel, adresse, role, image);
        this.prenom = prenom;
        this.CIN = CIN;
        this.dateDeNaissance = dateDeNaissance;
        this.nbrNote = nbrNote;
        this.Note = Note;
    }

    public Guide(String prenom, String CIN, String dateDeNaissance, int nbrNote, int Note, String nom, String email, String mdp, int numtel, String adresse, String role, String image) {
        super(nom, email, mdp, numtel, adresse, role, image);
        this.prenom = prenom;
        this.CIN = CIN;
        this.dateDeNaissance = dateDeNaissance;
        this.nbrNote = nbrNote;
        this.Note = Note;
    }

    public Guide(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public int getNbrNote() {
        return nbrNote;
    }

    public int getNote() {
        return Note;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setNbrNote(int nbrNote) {
        this.nbrNote = nbrNote;
    }

    public void setNote(int Note) {
        this.Note = Note;
    }

    @Override
    public String toString() {
        super.toString();
        return "Guide{" + "prenom=" + prenom + ", CIN=" + CIN + ", dateDeNaissance=" + dateDeNaissance + ", nbrNote=" + nbrNote + ", Note=" + Note + '}';
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
        final Guide other = (Guide) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        return true;
    }
    
}
