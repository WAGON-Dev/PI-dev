/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IAdminService;
import edu.esprit.pidev.models.Admin;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nouha
 */
public class AdminService implements IAdminService{

    Connection connection;

    public AdminService() {
      this.connection=DataSource.getInsatance().getConnection();
              }
    
    
    
  @Override
    public void add(Admin t) {
        String req = "insert into users (nom,prenom,email,mdp,numTel,adresse,cin,dateNaissence,role,image) values (?,?,?,?,?,?,?,?,?,?)";
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
            java.sql.Date sqlDate = new java.sql.Date(t.getDateNaissence().getTime());
            preparedStatement.setDate(8, sqlDate);
            preparedStatement.setString(8, t.getRole());
            preparedStatement.setString(9, t.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Admin t) {
        String req = "update users set nom=?,prenom=?,email=?,mdp=?,numtel=?,adresse=?,cin=?,dateNaissence=?,role=?,image=? where nom = ? and prenom = ? ";
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
            java.sql.Date sqlDate = new java.sql.Date(t.getDateNaissence().getTime());
            preparedStatement.setDate(8, sqlDate);
            preparedStatement.setString(9, t.getRole());
            preparedStatement.setString(10, t.getImage());
            preparedStatement.setString(11, t.getNom());
            preparedStatement.setString(12, t.getPrenom());
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
    public Admin findById(Integer r) {
        Admin  admin = null;
        String req = "select * from users where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                admin = new Admin(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("mdp"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("role"), resultSet.getString("image"),resultSet.getString("prenom"),resultSet.getString("cin"),resultSet.getDate("dateNaissence"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return admin;   
    }

   
    

    @Override
    public void addAdminWithStatement(Admin e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Admin> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    

