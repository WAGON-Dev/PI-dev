/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IChambre;
import edu.esprit.pidev.models.Chambre;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Chambre;
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
 * @author Ghassen
 */
public class ChambreService implements IChambre{
    
        Connection connection;

    public ChambreService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public List<Chambre> getByHotel(Hotel h) {
        List<Chambre> chambres = new ArrayList<>();
        String req = "select * from chambre where hotel_ch_fk=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, h.getId_user());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Chambre ch = new Chambre(resultSet.getInt("id_chambre"),resultSet.getString("type"), resultSet.getDouble("prix"), new ClientService().findById(resultSet.getInt("hotel_ch_fk")), new HotelService().findById(resultSet.getInt("cliet_ch_fk")));
                chambres.add(ch);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return chambres;
    }

    @Override
    public List<Chambre> getByClient(Client c) {
        List<Chambre> chambres = new ArrayList<>();
        String req = "select * from chambre where hotel_ch_fk=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, c.getId_user());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Chambre ch = new Chambre(resultSet.getInt("id_chambre"),resultSet.getString("type"), resultSet.getDouble("prix"), new ClientService().findById(resultSet.getInt("hotel_ch_fk")), new HotelService().findById(resultSet.getInt("cliet_ch_fk")));
                chambres.add(ch);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return chambres;
    }

    @Override
    public void add(Chambre t) {
        String req = "insert into chambre (type,prix,client_ch_fk,hotel_ch_fk) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getType());
            preparedStatement.setDouble(2, t.getPrix());
            preparedStatement.setInt(3, t.getClient_fk().getId_user());
            preparedStatement.setInt(4, t.getHotel_fk().getId_user());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Chambre t) {
String req = "update chambre set type = ?,prix=?,client_ch_fk=?,hotel_ch_fk=? where id_chambre = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getId());
            preparedStatement.setString(2, t.getType());
            preparedStatement.setDouble(3, t.getPrix());
            preparedStatement.setInt(4, t.getClient_fk().getId_user());
            preparedStatement.setInt(5, t.getHotel_fk().getId_user());
            preparedStatement.executeUpdate();        
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Integer r) {
String req = "delete from chambre where id_chambre =?";
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
    public Chambre findById(Integer r) {
        Chambre g = null;
        String req = "select * from users where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Chambre(resultSet.getInt("id_chambre"),resultSet.getString("type"), resultSet.getDouble("prix"), new ClientService().findById(resultSet.getInt("hotel_ch_fk")), new HotelService().findById(resultSet.getInt("cliet_ch_fk")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }

    @Override
    public List<Chambre> getAll() {
        List<Chambre> chambres = new ArrayList<>();
        String req = "select * from chambre";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Chambre ch = new Chambre(resultSet.getInt("id_chambre"),resultSet.getString("type"), resultSet.getDouble("prix"), new ClientService().findById(resultSet.getInt("hotel_ch_fk")), new HotelService().findById(resultSet.getInt("client_ch_fk")));
                chambres.add(ch);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return chambres;
    }

}

