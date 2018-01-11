/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.Iguide;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        /*String req = "insert into users (nom,prenom,password,email,adresse,numtel,dateNaissence,roles) values (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getPrenom());
            preparedStatement.setString(3, t.getPassword());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getAdresse());
            preparedStatement.setInt(6, t.getNumtel());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateDeNaissance().getTime());
            preparedStatement.setDate(7, sqlDate);
            preparedStatement.setString(8,"a:1:{i:0;s:11:\"ROLE_GUIDE\";}");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
        String req = "insert into users (username,username_canonical,prenom,email,email_canonical,enabled,password,numTel,adresse,cin,dateNaissence,roles,image) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getNom());
            preparedStatement.setString(3, t.getPrenom());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getEmail());
            preparedStatement.setInt(6, 1);
            preparedStatement.setString(7, t.getPassword());
            preparedStatement.setInt(8, t.getNumtel());
            preparedStatement.setString(9, t.getAdresse());
            preparedStatement.setString(10, t.getCIN());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateDeNaissance().getTime());
            preparedStatement.setDate(11, sqlDate);
            preparedStatement.setString(12, "a:1:{i:0;s:11:\"ROLE_GUIDE\";}");
            preparedStatement.setString(13, "Standard.png");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }

    @Override
    public void update(Guide t) {
        String req = "update users set nom = ?,prenom=?,password=?,email=?,adresse=?,numtel=?,dateNaissence=?,note=?,roles=? where id_user = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getPrenom());
            preparedStatement.setString(3, t.getPassword());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getAdresse());
            preparedStatement.setInt(6, t.getNumtel());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateDeNaissance().getTime());
            preparedStatement.setDate(7, sqlDate);
            preparedStatement.setInt(8, t.getNote());
            preparedStatement.setString(9, "a:1:{i:0;s:11:\"ROLE_GUIDE\";}");
            preparedStatement.setInt(10, t.getId_user());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update2(Guide t) {
        String req = "update users set nom = ?,prenom=?,password=?,adresse=?,numtel=?,dateNaissence=?,note=?,roles=? where email = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getPrenom());
            preparedStatement.setString(3, t.getPassword());
            preparedStatement.setString(4, t.getAdresse());
            preparedStatement.setInt(5, t.getNumtel());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateDeNaissance().getTime());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setInt(7, t.getNote());
            preparedStatement.setString(8, "a:1:{i:0;s:11:\"ROLE_GUIDE\";}");
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
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));
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
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

    public Guide findByName(String n) {
        Guide g = null;
        String req = "select * from users where nom=? and roles like '%ROLE_GUIDE%'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

    public Guide findByEmail(String e) {
        Guide g = null;
        String req = "select * from users where email=? and roles like '%ROLE_GUIDE%'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, e);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt(1), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

    @Override
    public List<Guide> getAll() {
        List<Guide> guides = new ArrayList<>();
        String req = "select * from users where roles like '%ROLE_GUIDE%'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Guide g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));
                guides.add(g);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guides;
    }

    public List<String> getAllname(String role) {
        List<String> guides = new ArrayList<>();
        String req = "select * from users where roles like %?% ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Guide g = new Guide(resultSet.getString("nom"));
                guides.add(g.getNom());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guides;
    }

    public void update_noote(Guide g) {
        String req = "update users set note=? where id_user = ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setInt(1, g.getNote());
            preparedStatement.setInt(2, g.getId_user());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Guide> getByRole() {
        List<Guide> guides = new ArrayList<>();
        String req = "select * from users where roles like '%ROLE_GUIDE%'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //                                  String prenom,               String CIN,                 Date dateDeNaissance,               int nbrNote,                  int Note,                    int id_user,                 String nom,                  String email,            String password,                int numtel,                  String adresse,                  String role,                 String image
                Guide g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));
                guides.add(g);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guides;
    }

    public Guide findByNomPwd(String nom, String pwd) {
        Guide g = null;
        String req = "select * from users where nom=? and password=? and roles like '%ROLE_GUIDE%'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, pwd);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Guide(resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"), resultSet.getInt("nbr_note"), resultSet.getInt("note"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("ROLE_GUIDE");
        return g;
    }

    public int nbrGuide() {
        int i = 0;
        String req = "SELECT COUNT(*) AS total FROM users where roles like '%ROLE_GUIDE%'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            i = resultSet.getInt("total");
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
