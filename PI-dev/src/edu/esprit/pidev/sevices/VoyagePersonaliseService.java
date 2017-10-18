/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IVoyagePersonalise;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.techniques.DataSource;
import edu.esprit.pidev.models.Client;
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
public class VoyagePersonaliseService implements IVoyagePersonalise {

    Connection connection;

    public VoyagePersonaliseService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(VoyagePersonalise vp) {
        String req = "insert into voyagepersonalise (id_vp,nom,ville_depart,Ville_arrive,date_depart,date_arrive,nbr_participant,client_vp_fk,hotel_fk,event1_fk,event2_fk,event3_fk) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, vp.getId_vp());
            preparedStatement.setString(2, vp.getNom());
            preparedStatement.setString(3, vp.getVille_depart());
            preparedStatement.setString(4, vp.getVille_arrive());
            preparedStatement.setString(5, vp.getDate_depart());
            preparedStatement.setString(6, vp.getDate_arrive());
            preparedStatement.setInt(7, vp.getNbr_participant());

            preparedStatement.setInt(8, vp.getClient().getId_user());
            preparedStatement.setInt(9, vp.getHotel().getId_user());
            preparedStatement.setInt(10, vp.getEvent1().getId_evenement());
            preparedStatement.setInt(11, vp.getEvent2().getId_evenement());
            preparedStatement.setInt(12, vp.getEvent3().getId_evenement());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


     public void add2(VoyagePersonalise vp) {
        String req = "insert into voyagepersonalise (id_vp,nom,ville_depart,Ville_arrive,date_depart,date_arrive,nbr_participant,client_vp_fk,hotel_fk,event1_fk,event2_fk) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, vp.getId_vp());
            preparedStatement.setString(2, vp.getNom());
            preparedStatement.setString(3, vp.getVille_depart());
            preparedStatement.setString(4, vp.getVille_arrive());
            preparedStatement.setString(5, vp.getDate_depart());
            preparedStatement.setString(6, vp.getDate_arrive());
            preparedStatement.setInt(7, vp.getNbr_participant());

            preparedStatement.setInt(8, vp.getClient().getId_user());
            preparedStatement.setInt(9, vp.getHotel().getId_user());
            preparedStatement.setInt(10, vp.getEvent1().getId_evenement());
            preparedStatement.setInt(11, vp.getEvent2().getId_evenement());
          

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
      public void add3(VoyagePersonalise vp) {
        String req = "insert into voyagepersonalise (id_vp,nom,ville_depart,Ville_arrive,date_depart,date_arrive,nbr_participant,client_vp_fk,hotel_fk,event1_fk) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, vp.getId_vp());
            preparedStatement.setString(2, vp.getNom());
            preparedStatement.setString(3, vp.getVille_depart());
            preparedStatement.setString(4, vp.getVille_arrive());
            preparedStatement.setString(5, vp.getDate_depart());
            preparedStatement.setString(6, vp.getDate_arrive());
            preparedStatement.setInt(7, vp.getNbr_participant());

            preparedStatement.setInt(8, vp.getClient().getId_user());
            preparedStatement.setInt(9, vp.getHotel().getId_user());
            preparedStatement.setInt(10, vp.getEvent1().getId_evenement());
     

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

   


    @Override
    public void update(VoyagePersonalise vp) {
        String req = "update voyagepersonalise set nom=?,ville_depart=?,ville_arrive=?,date_depart=?,date_arrive=?,nbr_participant=?,client_vp_fk=?,hotel_fk=?,event1_fk=?,event2_fk=?,event3_fk=? where id_vp = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setString(1, vp.getNom());
            preparedStatement.setString(2, vp.getVille_depart());
            preparedStatement.setString(3, vp.getVille_arrive());
            preparedStatement.setString(4, vp.getDate_depart());
            preparedStatement.setString(5, vp.getDate_arrive());
            preparedStatement.setInt(6, vp.getNbr_participant());
            preparedStatement.setInt(7, vp.getClient().getId_user());
            preparedStatement.setInt(8, vp.getHotel().getId_user());
            preparedStatement.setInt(9, vp.getEvent1().getId_evenement());
            preparedStatement.setInt(10, vp.getEvent2().getId_evenement());
            preparedStatement.setInt(11, vp.getEvent3().getId_evenement());
            preparedStatement.setInt(12, vp.getId_vp());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id) {
        String req = "delete from voyagepersonalise where id_vp =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public VoyagePersonalise findById(Integer id) {
        VoyagePersonalise voyagePersonalise = null;
        String req = "select * from voyagepersonalise where id_vp =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                voyagePersonalise = new VoyagePersonalise(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), new HotelService().findById(resultSet.getInt(9)), new ClientService().findById(resultSet.getInt(8)), new EvenementService().findById(resultSet.getInt(10)), new EvenementService().findById(resultSet.getInt(11)), new EvenementService().findById(resultSet.getInt(12)));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voyagePersonalise;
    }

    @Override
    public List<VoyagePersonalise> getAll() {
        List<VoyagePersonalise> voyages = new ArrayList<>();
        String req = "select * from voyagepersonalise";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VoyagePersonalise voyagePersonalise = new VoyagePersonalise(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7), new HotelService().findById(resultSet.getInt(9)), new ClientService().findById(resultSet.getInt(8)), new EvenementService().findById(resultSet.getInt(10)), new EvenementService().findById(resultSet.getInt(11)), new EvenementService().findById(resultSet.getInt(12)));

                voyages.add(voyagePersonalise);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voyages;

    }
}
