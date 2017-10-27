/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.Iguide;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ghassen
 */
public class GuideService implements Iguide {

    Connection connection;

    public GuideService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(Guide t) {
        String req = "insert into users (nom,Prenom,mdp,email,adresse,numtel,dateNaissence,note,role) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getPrenom());
            preparedStatement.setString(3, t.getMdp());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getAdresse());
            preparedStatement.setInt(6, t.getNumtel());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateDeNaissance().getTime());
            preparedStatement.setDate(7, sqlDate);
            preparedStatement.setInt(8, t.getNote());
            preparedStatement.setString(9, "Guide");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Guide t) {
        String req = "update users set nom = ?,Prenom=?,mdp=?,email=?,adresse=?,numtel=?,dateNaissence=?,note=?,role=? where id_user = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getPrenom());
            preparedStatement.setString(3, t.getMdp());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getAdresse());
            preparedStatement.setInt(6, t.getNumtel());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateDeNaissance().getTime());
            preparedStatement.setDate(7, sqlDate);
            preparedStatement.setInt(8, t.getNote());
            preparedStatement.setString(9, "Guide");
            preparedStatement.setInt(10, t.getId_user());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void update2(Guide t) {
        String req = "update users set nom = ?,Prenom=?,mdp=?,adresse=?,numtel=?,dateNaissence=?,note=?,role=? where email = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getPrenom());
            preparedStatement.setString(3, t.getMdp());
            preparedStatement.setString(4, t.getAdresse());
            preparedStatement.setInt(5, t.getNumtel());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateDeNaissance().getTime());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setInt(7, t.getNote());
            preparedStatement.setString(8, "Guide");
            preparedStatement.setString(9, t.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Integer r) {
        String req = "delete from users where id_user =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Guide findById(Integer r) {
        Guide g = null;
        String req = "select * from users where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

    public Guide findByName(String n, String p) {
        Guide g = null;
        String req = "select * from users where nom=? and prenom=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n);
            preparedStatement.setString(2, p);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

    public Guide findByEmail(String e) {
        Guide g = null;
        String req = "select * from users where email=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, e);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt(2), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

    @Override
    public List<Guide> getAll() {
        List<Guide> guides = new ArrayList<>();
        String req = "select * from users where role = 'Guide'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Guide g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"));
                guides.add(g);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guides;
    }
     public Guide findByName(String r) {
        Guide g = null;
        String req = "select * from users where nom=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

}
