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
/**
 *
 * @author Asus
 */
public class ClientService implements IserviceClient{
Connection connection ;
    public ClientService() {
       connection = DataSource.getInsatance().getConnection();
    }
    
   @Override
    public void add(Client t) {
        String req = "insert into users (nom,prenom,email,mdp,numTel,adresse,cin,role,image) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
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
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Client t) {
        String req = "update users set nom=?,prenom=?,email=?,mdp=?,numtel=?,adresse=?,cin=?,role=?,image=? where nom = ? and prenom = ? ";
        PreparedStatement preparedStatement = null ;
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
        }    }

    @Override
    public void remove(Integer r) {
        String req = "delete from users where id_user =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,r );
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Client findById(Integer r) {
        Client  client = null;
        String req = "select * from users where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client = new Client(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"),resultSet.getString("prenom"),resultSet.getString("cin"),resultSet.getString("dateNaissence"));
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
                client = new Client(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"),resultSet.getString("prenom"),resultSet.getString("cin"),resultSet.getString("dateNaissence"));
                clients.add(client);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;    }
    
}
