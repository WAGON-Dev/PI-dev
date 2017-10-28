/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.esprit.pidev.interfaces.IAgenceService;
import edu.esprit.pidev.models.Agence;

import edu.esprit.pidev.techniques.DataSource;

/*
 */

/**
 *
 * @author zakiya
 */
public class AgenceService implements IAgenceService {

    Connection connection;

    public AgenceService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(Agence a) {
        String req = "insert into users (role,nom,email,mdp,numTel,adresse,nbr_voyage_organise) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, a.getRole());
            //  preparedStatement.setInt(2, a.getId_user());
            preparedStatement.setString(2, a.getNom());
            preparedStatement.setString(3, a.getEmail());
            preparedStatement.setString(4, a.getMdp());
            preparedStatement.setInt(5, a.getNumtel());
            preparedStatement.setString(6, a.getAdresse());
            preparedStatement.setInt(7, a.getNbr_voyage_organise());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id_user) {
        String req = "delete from users where id_user =?";
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
    public void update(Agence a) {
        String req = "update users set nom=? , email=? , mdp=? ,numTel=?,adresse=?  where id_user = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, a.getNom());
            preparedStatement.setString(2, a.getEmail());
            preparedStatement.setString(3, a.getMdp());
            preparedStatement.setInt(4, a.getNumtel());
            preparedStatement.setString(5, a.getAdresse());
            preparedStatement.setInt(6, a.getId_user());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override

    public List<Agence> getAll() {
        List<Agence> agences = new ArrayList<>();
        String req = "select * from users";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Agence agence = new Agence(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getInt("nbr_voyage_organise"));
                agences.add(agence);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agences;
    }

    @Override
    public Agence findById(Integer id) {
        Agence agence = null;
        String req = "select * from users where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                agence = new Agence(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getInt("nbr_voyage_organise"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agence;

    }
      public List<String> getAllname(String role) {
        List<String> agences = new ArrayList<>();
        String req = "select * from users where role = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
              preparedStatement.setString(1, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Agence agence = new Agence(resultSet.getString("nom"));
                agences.add(agence.getNom());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agences;
    }
}
