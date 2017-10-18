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
import java.sql.ResultSet;
import java.util.ArrayList;
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
       PreparedStatement statement= connection.prepareStatement(query);
       statement.setString(1, t.getNom());
       statement.setString(2, t.getEmail());
       statement.setString(3, t.getMdp());
       statement.setInt(4,t.getNumtel());
       statement.setString(5, t.getAdresse());
       statement.setString(6, t.getRole());
       statement.setString(7, t.getImage());
       statement.setInt(8, t.getStars());
       statement.setInt(9, t.getCarNbre());
       statement.setInt(10, t.getId_user());
       int  rowUp = statement.executeUpdate();
       if(rowUp>0){System.out.println("row updated");}
       }catch(SQLException ex){ex.printStackTrace();}
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void update(CarRental t, String z) {
        String query = "UPDATE users set nom=?,email=?,mdp=?,numtel=?,adresse=?,role=?,image=?,etoile=?,nbr_voiture=? where nom = ?";
       try{
       PreparedStatement statement= connection.prepareStatement(query);
       statement.setString(1, t.getNom());
       statement.setString(2, t.getEmail());
       statement.setString(3, t.getMdp());
       statement.setInt(4,t.getNumtel());
       statement.setString(5, t.getAdresse());
       statement.setString(6, t.getRole());
       statement.setString(7, t.getImage());
       statement.setInt(8, t.getStars());
       statement.setInt(9, t.getCarNbre());
       statement.setString(10, z);
       int  rowUp = statement.executeUpdate();
       if(rowUp>0){System.out.println("row updated");}
       }catch(SQLException ex){ex.printStackTrace();}
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer r) {
        String query="DELETE FROM users where id=?";
        try{
        PreparedStatement statement=connection.prepareStatement(query);
        statement.setInt(1, r);
        int rowD= statement.executeUpdate();
        if(rowD>0)System.out.println("Deletion done!");
        
        }catch(SQLException ex){
        ex.printStackTrace();
        }

    }


    @Override
    public CarRental findById(Integer r) {
        String query= "Select * from users where id=?";
        CarRental cr= new CarRental();
        
        try{
        PreparedStatement statement= connection.prepareStatement(query);
        ResultSet res= statement.executeQuery(query);
        while(res.next()){
        cr.setRole(res.getString(1));
        cr.setId_user(res.getInt(2));
        cr.setNom(res.getString(3));
        cr.setEmail(res.getString(4));
        cr.setMdp(res.getString(5));
        cr.setNumtel(res.getInt(6));
        cr.setAdresse(res.getString(7));
        cr.setImage(res.getString(8));
        cr.setStars(res.getInt(9));
        cr.setCarNbre(res.getInt(17));
        
        
        }
        }catch(SQLException ex)
        {   ex.printStackTrace();}
        return cr;
    }

    
    public CarRental FindByReg(String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarRental> getAll() {
        List<CarRental> list = new ArrayList<>();
        String query = "select * from users where role='agencV'";
        try{
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet res= statement.executeQuery(query);
        while(res.next()){
        CarRental cr= new CarRental();
        cr.setRole(res.getString(1));
        cr.setId_user(res.getInt(2));
        cr.setNom(res.getString(3));
        cr.setEmail(res.getString(4));
        cr.setMdp(res.getString(5));
        cr.setNumtel(res.getInt(6));
        cr.setAdresse(res.getString(7));
        cr.setImage(res.getString(8));
        cr.setStars(res.getInt(9));
        cr.setCarNbre(res.getInt(17));
        
        list.add(cr);
        }
        }catch(SQLException ex){
        ex.printStackTrace();
        }
        return list;
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    }