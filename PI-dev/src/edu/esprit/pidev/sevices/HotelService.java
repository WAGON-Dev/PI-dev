/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;

import edu.esprit.pidev.interfaces.IHotel;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ahmed
 */
public class HotelService  implements IHotel  {

    Connection connection;

    public HotelService() {
        connection = DataSource.getInsatance().getConnection();
    }
     public Hotel findByName(String Name) {
              Hotel  hotel = null;
        String req = "select * from users where username=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, Name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              hotel= new Hotel(resultSet.getInt("id_user"), resultSet.getString("username"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getString("image"),resultSet.getString("etoile"),resultSet.getInt("nb_chambre"),resultSet.getInt("nb_chambre_reserve"),resultSet.getInt("note"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotel;
    }
    @Override
    public void add(Hotel h) {
        String req = "insert into users (id_user,nom,email,password,numtel,adresse,role,image,etoile,nb_chambre,nb_chambre_reserve) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, h.getId_user());
            preparedStatement.setString(2, h.getNom());
            preparedStatement.setString(3, h.getEmail());
            preparedStatement.setString(4, h.getPassword());
            preparedStatement.setInt(5, h.getNumtel());
            preparedStatement.setString(6, h.getAdresse());
            preparedStatement.setString(7, h.getRole());
            preparedStatement.setString(8, h.getImage());
            preparedStatement.setInt(9, h.getEtoile());
            preparedStatement.setInt(10, h.getNb_chambre());
            preparedStatement.setInt(11, h.getNb_chambre());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

     @Override
    public void update(Hotel h) {
        String req = "update users set nom=?,email=?,password=?,numtel=?,adresse=?,role=?,image=?,etoile=?,nb_chambre=?,nb_chambre_reserve=? where id_user = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
             preparedStatement.setString(1, h.getNom());
            preparedStatement.setString(2, h.getEmail());
            preparedStatement.setString(3, h.getPassword());
            preparedStatement.setInt(4, h.getNumtel());
            preparedStatement.setString(5, h.getAdresse());
            preparedStatement.setString(6, h.getRole());
            preparedStatement.setString(7, h.getImage());
            preparedStatement.setInt(8, h.getEtoile());
            preparedStatement.setInt(9, h.getNb_chambre());
            preparedStatement.setInt(10, h.getNb_chambre_reserve());
            preparedStatement.setInt(11, h.getId_user());
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
    
    public Hotel findById(Integer id_user) {
              Hotel  hotel = null;
        String req = "select * from users where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hotel= new Hotel(resultSet.getInt("id_user"), resultSet.getString("username"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getString("image"),resultSet.getString("etoile"),resultSet.getInt("nb_chambre"),resultSet.getInt("nb_chambre_reserve"),resultSet.getInt("note"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
       List<Hotel> hotels = new ArrayList<>();
        String req = "select * from users";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel(resultSet.getInt("id_user"), resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getString("image"),resultSet.getString("etoile"),resultSet.getInt("nb_chambre"),resultSet.getInt("nb_chambre_reserve"),resultSet.getInt("note"));
                hotels.add(hotel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotels;
    }
    public Hotel findByName_note(String Name) {
              Hotel  hotel = null;
        String req = "select * from users where nom=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, Name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hotel= new Hotel(resultSet.getInt("id_user"), resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getString("image"),resultSet.getString("etoile"),resultSet.getInt("nb_chambre"),resultSet.getInt("nb_chambre_reserve"),resultSet.getInt("note"));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotel;
    }
      public void update_noote(Hotel h) {
        String req = "update users set note=? where id_user = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setInt(1, h.getNote());
            preparedStatement.setInt(2, h.getId_user());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     public List<String> getAll_name(String role) {
       List<String> hotels = new ArrayList<>();
        String req = "select * from users where role= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel(resultSet.getString(3));
                hotels.add(hotel.getNom());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotels;
    }
       public List<Hotel> getByRole() {
 List<Hotel> hotels = new ArrayList<>();
        String req = "select * from users where role='hotel'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                                           //         int id_user,              String nom,             String email,                String password,                int numtel,              String adresse, String role,                            String image,                        int etoile, int nb_chambre, int nb_chambre_reserve
                Hotel hotel = new Hotel(resultSet.getInt("id_user"), resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getString("role"),resultSet.getString("image"),resultSet.getInt("etoile"),resultSet.getInt("nb_chambre"),resultSet.getInt("nb_chambre_reserve"));
                hotels.add(hotel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotels;    }
       
       
        public Hotel findByNomPwd(String nom,String pwd) {
              Hotel  hotel = null;
        String req = "select * from users where nom=? and password=? and role='hotel'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom);
             preparedStatement.setString(2, pwd);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hotel = new Hotel(resultSet.getInt("id_user"), resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getString("role"),resultSet.getString("image"),resultSet.getInt("etoile"),resultSet.getInt("nb_chambre"),resultSet.getInt("nb_chambre_reserve"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotel;
    }
      public int nbrHotel() {
             int i=0;
            String req = "SELECT COUNT(*) AS total FROM users where role='hotel'";
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
      
      
      public Hotel findByemail(String  r) {
        Hotel client = null;
        String req = "select * from users where email=? and roles='a:1:{i:0;s:10:\"ROLE_HOTEL\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client = new Hotel(resultSet.getInt("id_user"), resultSet.getString("username"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getString("roles"),resultSet.getString("image"),resultSet.getInt("etoile"),resultSet.getInt("nb_chambre"),resultSet.getInt("nb_chambre_reserve"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }
}
