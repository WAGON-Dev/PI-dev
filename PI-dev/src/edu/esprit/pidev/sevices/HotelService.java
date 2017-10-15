/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IHotel;
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
 * @author Ahmed
 */
public class HotelService  implements IHotel  {

    Connection connection;

    public HotelService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(Hotel h) {
        String req = "insert into hotel (id_user,nom,email,mdp,numtel,adresse,role,image,etoile,nb_chambre,nb_chambre_reserve) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, h.getId_user());
            preparedStatement.setString(2, h.getNom());
            preparedStatement.setString(3, h.getEmail());
            preparedStatement.setString(4, h.getMdp());
            preparedStatement.setInt(5, h.getNumtel());
            preparedStatement.setString(6, h.getAdresse());
            preparedStatement.setString(7, h.getRole());
            preparedStatement.setString(8, h.getImage());
            preparedStatement.setInt(9, h.getEtoile());
            preparedStatement.setInt(10, h.getNb_chambre());
            preparedStatement.setInt(11, h.getNb_chambre());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

     @Override
    public void update(Hotel h) {
        String req = "update hotel set nom=?,email=?,mdp=?,numtel=?,adresse=?,role=?,image=?,etoile=?,nb_chambre=?,nb_chambre_reserve=? where id_user = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
             preparedStatement.setString(1, h.getNom());
            preparedStatement.setString(2, h.getEmail());
            preparedStatement.setString(3, h.getMdp());
            preparedStatement.setInt(4, h.getNumtel());
            preparedStatement.setString(5, h.getAdresse());
            preparedStatement.setString(6, h.getRole());
            preparedStatement.setString(7, h.getImage());
            preparedStatement.setInt(8, h.getEtoile());
            preparedStatement.setInt(9, h.getNb_chambre());
            preparedStatement.setInt(10, h.getNb_chambre_reserve());
            preparedStatement.setInt(11, h.getId_user());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id_user) {
        String req = "delete from hotel where id_user =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_user);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Hotel findById(Integer id_user) {
              Hotel  hotel = null;
        String req = "select * from hotel where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hotel= new Hotel(resultSet.getInt("id_user"), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getInt(10));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
       List<Hotel> hotels = new ArrayList<>();
        String req = "select * from hotel";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel(resultSet.getInt("id_user"), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getInt(10));
                hotels.add(hotel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotels;
    }

    

}
