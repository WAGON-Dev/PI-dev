/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IEvenementService;
import edu.esprit.pidev.models.Evenement;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.VoyagePersonalise;
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

  
    

    public EvenementService() {
        connection = DataSource.getInsatance().getConnection();
    }

     public Evenement findByName(String Name) {
        Evenement evenement = null;
        String req = "select * from evenement where activite=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, Name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                evenement = new Evenement(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evenement;
    }
    @Override
    public void add(Evenement t) {
        String req = "insert into evenement (id_evenement,activite,date_activite,emplacement) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getId_evenement());
            preparedStatement.setString(2, t.getActivite());
            java.sql.Date sqlDate = new java.sql.Date(t.getDate_activite().getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, t.getEmplacement());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Evenement t) {
        String req = "update evenement set activite=?,date_activite=?,emplacement=? where id_evenement = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setString(1, t.getActivite());
            java.sql.Date sqlDate = new java.sql.Date(t.getDate_activite().getTime());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setString(3, t.getEmplacement());
            preparedStatement.setInt(4, t.getId_evenement());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
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

    @Override
    public Evenement findById(Integer r) {
        Evenement  evenement = null;
        String req = "select * from evenement where id_evenement=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                evenement = new Evenement(resultSet.getInt(1), resultSet.getString(2),resultSet.getDate(3),resultSet.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evenement;
    }

    @Override
    public List<Evenement> getAll() {
        List<Evenement> evenements = new ArrayList<>();
        String req = "select * from evenement";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Evenement evenement = new Evenement(resultSet.getInt(1), resultSet.getString(2),resultSet.getDate(3),resultSet.getString(4));
                evenements.add(evenement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evenements;
        
    }
     public List<Evenement> getAll_vp(VoyagePersonalise vp) {
        List<Evenement> evenements = new ArrayList<>();
        String req = "select * from evenement WHERE  date_activite between ? and ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            java.sql.Date sqlDate = new java.sql.Date(vp.getDate_depart().getTime());
            preparedStatement.setDate(1, sqlDate);
            java.sql.Date sqlDate2 = new java.sql.Date(vp.getDate_arrive().getTime());
            preparedStatement.setDate(2, sqlDate2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Evenement evenement = new Evenement(resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4));
                evenements.add(evenement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evenements;

    }
}