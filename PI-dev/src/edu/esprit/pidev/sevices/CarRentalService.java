/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;
import edu.esprit.pidev.interfaces.ICarRentalService;
import edu.esprit.pidev.models.CarRental;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String query="insert into users (username,username_canonical,email,email_canonical,enabled,password,numTel,adresse,roles,image,etoile,nbr_voiture) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cr.getNom());
        statement.setString(2, cr.getNom());
        statement.setString(3, cr.getEmail());
        statement.setString(4, cr.getEmail());
        statement.setInt(5, 1);
        statement.setString(6, cr.getPassword());
        statement.setInt(7, cr.getNumtel());
        statement.setString(8, cr.getAdresse());
        statement.setString(9, cr.getRole());
        statement.setString(10, cr.getImage());
        statement.setInt(11, cr.getStars());
        statement.setInt(12, cr.getCarNbre());
        
        int rowIns= statement.executeUpdate();
        if(rowIns>0){System.out.println("row inserted");}
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CarRental t) {
          String query = "UPDATE users set nom=?,email=?,password=?,numtel=?,adresse=?,role=?,image=?,etoile=?,nbr_voiture=? where id_user = ?";
       try{
       PreparedStatement statement= connection.prepareStatement(query);
       statement.setString(1, t.getNom());
       statement.setString(2, t.getEmail());
       statement.setString(3, t.getPassword());
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
        String query = "UPDATE users set nom=?,email=?,password=?,numtel=?,adresse=?,role=?,image=?,etoile=?,nbr_voiture=? where nom = ?";
       try{
       PreparedStatement statement= connection.prepareStatement(query);
       statement.setString(1, t.getNom());
       statement.setString(2, t.getEmail());
       statement.setString(3, t.getPassword());
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
        String query="DELETE FROM users where id_user=?";
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
        String query= "Select * from users where id_user="+r+"";
        CarRental cr= new CarRental();
        
        try{
        PreparedStatement statement= connection.prepareStatement(query);
        ResultSet res= statement.executeQuery(query);
        while(res.next()){
        cr.setRole(res.getString(1));
        cr.setId_user(res.getInt(2));
        cr.setNom(res.getString(3));
        cr.setEmail(res.getString(4));
        cr.setPassword(res.getString(5));
        cr.setNumtel(res.getInt(6));
        cr.setAdresse(res.getString(7));
        cr.setImage(res.getString(8));
        cr.setStars(res.getInt("note"));
        cr.setCarNbre(res.getInt(17));
        
        
        }
        }catch(SQLException ex)
        {   ex.printStackTrace();}
        return cr;
    }

    public CarRental findByAdresse(String add) {
        String query= "Select * from users where adresse='"+add+"'";
        CarRental cr= new CarRental();
        try{
        PreparedStatement statement= connection.prepareStatement(query);
        ResultSet res= statement.executeQuery(query);
        while(res.next()){
        cr.setRole(res.getString(1));
        cr.setId_user(res.getInt(2));
        cr.setNom(res.getString(3));
        cr.setEmail(res.getString(4));
        cr.setPassword(res.getString(5));
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
        String query = "select * from users where roles='a:1:{i:0;s:19:\"ROLE_AGENCE_VOITURE\";}'";
        try{
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet res= statement.executeQuery(query);
        while(res.next()){
        CarRental cr= new CarRental();
        cr.setRole(res.getString(1));
        cr.setId_user(res.getInt(2));
        cr.setNom(res.getString(3));
        cr.setEmail(res.getString(4));
        cr.setPassword(res.getString(5));
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
    
    
     public CarRental findByNomPwd(String nom,String pwd) {
        CarRental car = null;
        String req = "select * from users where nom=? and password=? and roles='a:1:{i:0;s:19:\"ROLE_AGENCE_VOITURE\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,pwd);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //              int stars,                           int carNbre,                      int id_user,               String nom,                 String email, String password, int numtel, String adresse, String role, String image
      car=new CarRental(resultSet.getInt("etoile"),resultSet.getInt("nbr_voiture"), resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return car;
     
    }
    public List<CarRental> getByRole() {
List<CarRental> list = new ArrayList<>();
        String query = "select * from users where roles='a:1:{i:0;s:19:\"ROLE_AGENCE_VOITURE\";}'";
        try{
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet res= statement.executeQuery(query);
        while(res.next()){
        CarRental cr= new CarRental();
        cr.setRole(res.getString("roles"));
        cr.setId_user(res.getInt("id_user"));
        cr.setNom(res.getString("username"));
        cr.setEmail(res.getString("email"));
        cr.setPassword(res.getString("password"));
        cr.setNumtel(res.getInt("numTel"));
        cr.setAdresse(res.getString("adresse"));
        //cr.setImage(res.getString("image"));
        //cr.setStars(res.getInt(9));
        //cr.setCarNbre(res.getInt(17));
        cr.setImage("-");
        cr.setStars(0);
        cr.setCarNbre(500);
        
        list.add(cr);
            }
        }catch(SQLException ex){
        ex.printStackTrace();
       }
        return list;   
    }
    
     public int nbrALV() {
             int i=0;
            String req = "SELECT COUNT(*) AS total FROM users where roles='a:1:{i:0;s:19:\"ROLE_AGENCE_VOITURE\";}'";
            PreparedStatement preparedStatement;
          try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            i=resultSet.getInt("total");
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
return i;
}
        
    
      public CarRental findByEmail(String e) {
        CarRental g = null;
        String req = "select * from users where email=? and roles='a:1:{i:0;s:19:\"ROLE_AGENCE_VOITURE\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, e);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              g=new CarRental(resultSet.getInt("etoile"),resultSet.getInt("nbr_voiture"), resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getString("roles"), resultSet.getString("image"));               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }  
    }
