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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client findById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
