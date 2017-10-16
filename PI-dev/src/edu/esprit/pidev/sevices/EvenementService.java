/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IEvenementService;
import edu.esprit.pidev.models.Evenement;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class EvenementService implements IEvenementService {

    Connection connection;

    public EvenementService(Connection connection) {
        connection = DataSource.getInsatance().getConnection();
    }

    public void add(Evenement t) {
        String req = "insert into evene;ent (id_evenement,activite,date_activite,emplacement) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getId_evenement());
            preparedStatement.setString(2, t.getActivite());
            preparedStatement.setString(3, t.getDate_activite());
            preparedStatement.setString(4, t.getEmplacement());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Evenement t) {
        String req = "update evenement set id_evenement=?,activite=?,date_activite=?,emplacement=? where id_evenement = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
             preparedStatement.setInt(1, t.getId_evenement());
            preparedStatement.setString(2, t.getActivite());
            preparedStatement.setString(3, t.getDate_activite());
            preparedStatement.setString(4, t.getEmplacement());
            preparedStatement.setInt(5, t.getId_evenement());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void remove(Integer r) {
        String req = "delete from evenement where id_evenement =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Evenement findById(Integer r) {
        Evenement  evenement = null;
        String req = "select * from evenement where id_evenement=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                evenement = new Evenement(resultSet.getInt("id_evenement"), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evenement;
    }

    public List<Evenement> getAll() {
        List<Evenement> evenements = new ArrayList<>();
        String req = "select * from evenement";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Evenement evenement = new Evenement(resultSet.getInt("id_evenement"), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                evenements.add(evenement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evenements;
        
    }
}