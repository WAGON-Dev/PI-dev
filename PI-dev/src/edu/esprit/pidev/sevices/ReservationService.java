/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IReservation;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Reservation;
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
public class ReservationService implements IReservation {

    Connection connection;

    public ReservationService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(Reservation t) {
        String req = "insert into reservation (id_client,type_reservation,id_reservation,prix) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getId_client().getEmail());
            preparedStatement.setString(2, t.getType_reservation());
            preparedStatement.setString(3, String.valueOf(t.getId_reservation()));
            preparedStatement.setString(4, String.valueOf(t.getPrix()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addCar(Reservation t) {
        String req = "insert into reservation (id_client,type_reservation,id_reservation,prix) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getId_client().getEmail());
            preparedStatement.setString(2, "voiture");
            preparedStatement.setString(3, String.valueOf(t.getId_reservation()));
            preparedStatement.setString(4, String.valueOf(t.getPrix()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addVO(Reservation t) {
        String req = "insert into reservation (id_client,type_reservation,id_reservation,prix) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getId_client().getEmail());
            preparedStatement.setString(2, "voyage organisé");
            preparedStatement.setString(3, String.valueOf(t.getId_reservation()));
            preparedStatement.setString(4, String.valueOf(t.getPrix()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addChambre(Reservation t) {
        String req = "insert into reservation (id_client,type_reservation,id_reservation,prix) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getId_client().getEmail());
            preparedStatement.setString(2, "chambre");
            preparedStatement.setString(3, String.valueOf(t.getId_reservation()));
            preparedStatement.setString(4, String.valueOf(t.getPrix()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addVol(Reservation t) {
        String req = "insert into reservation (id_client,type_reservation,id_reservation,prix) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getId_client().getEmail());
            preparedStatement.setString(2, "vol");
            preparedStatement.setString(3, String.valueOf(t.getId_reservation()));
            preparedStatement.setString(4, String.valueOf(t.getPrix()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Reservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer r) {
        String req = "delete from reservation where id_reservation =?";
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
    public Reservation findById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Reservation findByIdCond(Integer r , String s) {
         Reservation g= null ;
        String req = "select * from reservation where id_reservation=? and id_client=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.setString(2, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Reservation(new ClientService().findByemail(resultSet.getString("id_client")), resultSet.getString("type_reservation"), resultSet.getInt("id_reservation"), resultSet.getDouble("prix"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }


    @Override
    public List<Reservation> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Reservation> getAllByClient(String s) {
        List<Reservation> guides = new ArrayList<>();
        String req = "select * from reservation where id_client = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reservation g = new Reservation(new ClientService().findByemail(resultSet.getString("id_client")), resultSet.getString("type_reservation"), resultSet.getInt("id_reservation"), resultSet.getDouble("prix"));
                guides.add(g);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return guides;
    }

}
