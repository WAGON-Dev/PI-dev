/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IserviceClient;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ClientService implements IserviceClient {

    Connection connection;
    public static Client loggedUser;

    public ClientService() {
        connection = DataSource.getInsatance().getConnection();
    }

    public boolean existeUtilisateur(String username) {

        PreparedStatement preparedStatement;
        String req = "select * from users WHERE email=?";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                loggedUser = new Client();
                loggedUser.setId_user(resultSet.getInt("id_user"));
                loggedUser.setNom(resultSet.getString("username"));
                loggedUser.setMdp(resultSet.getString("password"));
                loggedUser.setEmail(resultSet.getString("email"));
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
/////////////////////////////////////////////////////////////j'ai modifier pour le sign up /////////////////////////////////////////////////
    @Override
    public void add(Client t) {
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
            preparedStatement.setString(7, t.getMdp());
            preparedStatement.setInt(8, t.getNumtel());
            preparedStatement.setString(9, t.getAdresse());
            preparedStatement.setString(10, t.getCin());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateNaissence().getTime());
            preparedStatement.setDate(11, sqlDate);
            preparedStatement.setString(12, t.getRole());
            preparedStatement.setString(13, t.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Client t) {
        String req = "update users set nom=?,prenom=?,email=?,mdp=?,numtel=?,adresse=?,cin=?,dateNaissence=?,role=?,image=? where nom = ? and prenom = ? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getPrenom());
            preparedStatement.setString(3, t.getEmail());
            preparedStatement.setString(4, t.getMdp());
            preparedStatement.setInt(5, t.getNumtel());
            preparedStatement.setString(6, t.getAdresse());
            preparedStatement.setString(7, t.getCin());
            java.sql.Date sqlDate = new java.sql.Date(t.getDateNaissence().getTime());
            preparedStatement.setDate(8, sqlDate);
            preparedStatement.setString(9, t.getRole());
            preparedStatement.setString(10, t.getImage());
            preparedStatement.setString(11, t.getNom());
            preparedStatement.setString(12, t.getPrenom());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatecompte(Client t) {
        String req = "update users set nom=?,prenom=?,email=?,mdp=?,numtel=?,adresse=?,cin=?,role=?,image=? where nom = ? and prenom = ? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getNom());
            preparedStatement.setString(2, t.getPrenom());
            preparedStatement.setString(3, t.getEmail());
            preparedStatement.setString(4, t.getMdp());
            preparedStatement.setInt(5, t.getNumtel());
            preparedStatement.setString(6, t.getAdresse());
            preparedStatement.setString(7, t.getCin());
            preparedStatement.setString(8, t.getRole());
            preparedStatement.setString(9, t.getImage());
            preparedStatement.setString(10, t.getNom());
            preparedStatement.setString(11, t.getPrenom());
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
    public Client findById(Integer r) {
        Client client = null;
        String req = "select * from users where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client = new Client(resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"), resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    public Client findByemail(String r) {
        Client client = null;
        String req = "select * from users where email=? and roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client = new Client(resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"), resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        String req = "select * from users";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client;
                client = new Client(resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"), resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"));
                clients.add(client);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;
    }

    public List<Client> getByClient() {
        List<Client> clients = new ArrayList<>();
        String req = "select * from users where role='a:1:{i:0;s:11:\"ROLE_CLIENT\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client;
                client = new Client(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"), resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"));
                clients.add(client);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;
    }

    public Client findByNomPwd(String nom, String pwd) {
        Client client = null;
        String req = "select * from users where nom=? and mdp=? and role='a:1:{i:0;s:11:\"ROLE_CLIENT\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, pwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client = new Client(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"), resultSet.getString("prenom"), resultSet.getString("cin"), resultSet.getDate("dateNaissence"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    public int nbrClient() {
        int i = 0;
        String req = "SELECT COUNT(*) AS total FROM users where role='a:1:{i:0;s:11:\"ROLE_CLIENT\";}'";
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
