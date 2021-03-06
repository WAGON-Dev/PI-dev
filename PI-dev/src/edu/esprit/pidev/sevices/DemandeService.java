/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IDemandeService;

import edu.esprit.pidev.models.Demande;
import edu.esprit.pidev.models.Guide;
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
public class DemandeService implements IDemandeService {

    Connection connection;

    public DemandeService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override

    public void add(Demande t) {
        String req = "insert into demande (id_vp_fk,id_client_fk,id_guide_fk) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getId_vp().getId_vp());
            preparedStatement.setInt(2, t.getId_client().getId_user());
            preparedStatement.setInt(3, t.getId_guide().getId_user());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Demande t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer id) {
        String req = "delete from demande where id_vp_fk =?";
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
    public Demande findById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Demande findGuideEmail2(Integer r, Integer x) {
        Demande d = null;
        String req = "select * from demande where id_guide_fk=? and id_vp_fk=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.setInt(2, x);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                d = new Demande(new VoyagePersonaliseService().findById(resultSet.getInt("id_vp_fk")), new ClientService().findById(resultSet.getInt("id_client_fk")), new GuideService().findById(resultSet.getInt("id_guide_fk")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;
    }

    public Demande findGuideEmail(String r) {
        Demande d = null;
        String req = "select * from demande where id_guide_fk=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                d = new Demande(new VoyagePersonaliseService().findById(resultSet.getInt("id_vp_fk")),new ClientService().findById(resultSet.getInt("id_client_fk")), new GuideService().findByEmail(resultSet.getString("id_guide_fk")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;
    }

    @Override
    public List<Demande> getAll() {
        List<Demande> demandes = new ArrayList<>();
        String req = "select * from demande";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Demande demande = new Demande(new VoyagePersonaliseService().findById(resultSet.getInt(1)), new ClientService().findById(resultSet.getInt(2)), new GuideService().findById(resultSet.getInt("id_guide_fk")));
                demandes.add(demande);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return demandes;
    }

}
