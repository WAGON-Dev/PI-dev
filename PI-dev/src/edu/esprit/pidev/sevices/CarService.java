/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

//import edu.esprit.pidev.TestRentCar;
import edu.esprit.pidev.techniques.DataSource;
import edu.esprit.pidev.interfaces.ICarService;
import java.util.List;
import java.util.ArrayList;
import edu.esprit.pidev.models.Car;
import edu.esprit.pidev.models.CarRental;
/**
 *
 * @author omarfarouk
 */
public class CarService implements ICarService {
    
    //setting connection
    
    Connection connection;
    
    //setting constructor

    public CarService() {
        connection = DataSource.getInsatance().getConnection();
    }
    
    
    // CRUD methods for car and car Rental services
    
    
    

    @Override
    public void add(Car c) {
        String query =" insert into voiture (model,regNo,duration,rate,type,status) values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement statement =connection.prepareStatement(query);
            statement.setString(1, c.getModel());
            statement.setString(2, c.getRegNo());
            statement.setInt(3, c.getDuration());
            statement.setInt(4, c.getRate());
            statement.setString(5, c.getType());
            statement.setBoolean(6, c.isStatus());
            
            
            int rowinserted =statement.executeUpdate();
            if(rowinserted>0){
            System.out.println("Row added !!!");
                    }
            } catch (SQLException ex) {
            ex.printStackTrace();
        }    

        
    }

    
    //Update method point to the car with the regNo and update the status, duration, 
    
    public void update(Car c, String s) { 
        String query="UPDATE voiture set duration=?, status=? where regNo=?" ;
        try{
            PreparedStatement statement =connection.prepareStatement(query);
            statement.setInt(1,c.getDuration());
            statement.setBoolean(2, c.isStatus());
            statement.setString(3,s);
            int rowupdate =statement.executeUpdate();
            if(rowupdate>0){System.out.println("Row updated");}
            }catch(SQLException ex){
            ex.printStackTrace();
        }


        }

    @Override// delete with regNO
    public void delete(String str) {
      String query="DELETE FROM voiture where regNo=?";
      try{
          PreparedStatement statement = connection.prepareStatement(query);
          statement.setString(1,str);
          int rowD =statement.executeUpdate();
          if(rowD>0){
          System.out.println("A car was deleted successfully!");
          }
          
        } catch(SQLException ex){
            ex.printStackTrace();
      }
          

//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public Car FindByReg(String r) {
        String query="SELECT * from voiture where regNo='"+r+"'";
        Car c = new Car();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
              System.out.println("query set and prepared!");
             System.out.println("parameters are set also!");
             System.out.println(query);
            ResultSet result = statement.executeQuery(query);
            
            System.out.println("we are here");
            while(result.next()){
                 System.out.println("Car found oopppyy!");
            c.setModel(result.getString(1));
            c.setRegNo(result.getString(2));
            c.setDuration(result.getInt(3));
            c.setRate(result.getInt(4));
            c.setType(result.getString(5));
            c.setStatus(result.getBoolean(6));
            }
            
        }catch(SQLException ex){
        ex.printStackTrace();
        }
        
        return c;
    }
    
     public  List<Car> FindByRate(int max, int min) {
        String query="SELECT * from voiture where rate>"+min+" and rate<"+max+""  ;
        Car c = new Car();
         List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
            c = new Car(result.getString(1),result.getString(2),result.getInt(3),result.getInt(4),result.getString(5),result.getBoolean(6));
            carList.add(c);
            }
            
        }catch(SQLException ex){
        ex.printStackTrace();
        }
        
        return carList;
    }

    @Override
    public List<Car> getAll() {
        List<Car> carList = new ArrayList<>();
        String query = "SELECT * FROM voiture";
        try{
             PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
            Car c = new Car(result.getString(1),result.getString(2),result.getInt(3),result.getInt(4),result.getString(5),result.getBoolean(6));
            carList.add(c);
            }
            }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return carList;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

    @Override
    public Car findById(Integer r) {
        // find by car rental service 's id.
    String query="SELECT * from voiture where alv_co_fk='"+r+"'";
        Car c = new Car();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
             // System.out.println("query set and prepared!");
             //System.out.println("parameters are set also!");
             //System.out.println(query);
            ResultSet result = statement.executeQuery(query);
            
            //System.out.println("we are here");
            while(result.next()){
                 //System.out.println("Car found oopppyy!");
            c.setModel(result.getString(1));
            c.setRegNo(result.getString(2));
            c.setDuration(result.getInt(3));
            c.setRate(result.getInt(4));
            c.setType(result.getString(5));
            c.setStatus(result.getBoolean(6));
            }
            
        }catch(SQLException ex){
        ex.printStackTrace();
        }
        
        return c;
    }

    @Override
    public void update(Car t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override// remove with rental car service id.
    public void remove(Integer r) {
    String query="DELETE FROM voiture where alv_vo_fk=?";
      try{
          PreparedStatement statement = connection.prepareStatement(query);
          statement.setInt(1,r);
          int rowD =statement.executeUpdate();
          if(rowD>0){
          System.out.println("A car was deleted successfully!");
          }
          
        } catch(SQLException ex){
            ex.printStackTrace();
      }     
    }

   

   

    
    
    
    
    
}
