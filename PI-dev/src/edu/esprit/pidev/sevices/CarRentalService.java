/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;
import edu.esprit.pidev.interfaces.ICarRentalService;
import edu.esprit.pidev.models.CarRental;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author omarfarouk
 */
public class CarRentalService implements ICarRentalService{
    
    Connection connection;
    
    public CarRentalService(){
    connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(CarRental cr) {
        String query="insert into users (id_user,nom,email,mdp,numtel,adresse,role,image,etoile,nbr_voiture) values (?,?,?,?,?,?,?,?,?,?)";
        try{
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, cr.getId_user());
        statement.setString(2, cr.getNom());
        statement.setString(3, cr.getEmail());
        statement.setString(4, cr.getMdp());
        statement.setInt(5, cr.getNumtel());
        statement.setString(6, cr.getAdresse());
        statement.setString(7, cr.getRole());
        statement.setString(8, cr.getImage());
        statement.setInt(9, cr.getStars());
        statement.setInt(10, cr.getCarNbre());
        
        int rowIns= statement.executeUpdate();
        if(rowIns>0){System.out.println("row inserted");}
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CarRental t) {
       String query = "UPDATE users set nom=?,email=?,mdp=?,numtel=?,adresse=?,role=?,image=?,etoile=?,nbr_voiture=? where id_user = ?";
       try{
       PreparedStatement statment= connection.prepareStatement(query);
       
       }catch(SQLException ex){ex.printStackTrace();}
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void update(CarRental t, String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CarRental findById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public CarRental FindByReg(String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarRental> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    }