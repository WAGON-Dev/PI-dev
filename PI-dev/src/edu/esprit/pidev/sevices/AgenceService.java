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
import edu.esprit.pidev.models.Guide;

import edu.esprit.pidev.techniques.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String req = "insert into users (username,username_canonical,email,email_canonical,enabled,password,numTel,adresse,roles,image,nbr_voyage_organise) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(9, a.getRole());
            //  preparedStatement.setInt(2, a.getId_user());
             preparedStatement.setString(1, a.getNom());
            preparedStatement.setString(2, a.getNom());
            preparedStatement.setString(3, a.getEmail());
            preparedStatement.setString(4, a.getEmail());
            preparedStatement.setInt(5, 1);
            preparedStatement.setString(6, a.getPassword());
            preparedStatement.setInt(7, a.getNumtel());
            preparedStatement.setString(8, a.getAdresse());
            preparedStatement.setString(10, "");
            preparedStatement.setInt(11, a.getNbr_voyage_organise());

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
        String req = "update users set nom=? , email=? , password=? ,numTel=?,adresse=?  where id_user = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, a.getNom());
            preparedStatement.setString(2, a.getEmail());
            preparedStatement.setString(3, a.getPassword());
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
                Agence agence = new Agence(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getInt("nbr_voyage_organise"));
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
                agence = new Agence(resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numTel"), resultSet.getString("adresse"), resultSet.getInt("nbr_voyage_organise"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agence;

    }
      public List<String> getAllname(String role) {
        List<String> agences = new ArrayList<>();
        String req = "select * from users where roles = ?";
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
       public Agence findByName(String n) {
        Agence g = null;
        String req = "select * from users where nom=? and roles='a:1:{i:0;s:11:\"ROLE_AGENCE\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, n);
           
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                g = new Agence( resultSet.getInt("note"), resultSet.getInt("id_user"), resultSet.getString("nom"), resultSet.getString("email"),resultSet.getString("password"),  resultSet.getInt("numTel"), resultSet.getString("adresse"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return g;
    }
        public void update_noote(Agence g) {
        String req = "update users set note=? where id_user = ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setInt(1, g.getNote());
            preparedStatement.setInt(2, g.getId_user());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
         public Agence findByNomPwd(String nom,String pwd) {
        Agence agence = null;
        String req = "select * from users where nom=? and password=? and roles='a:1:{i:0;s:11:\"ROLE_AGENCE\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,pwd);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                agence = new Agence(resultSet.getInt("id_user"), resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getInt("nbr_voyage_organise"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agence;
     
}
         
          public List<Agence> getByRole() {
         List<Agence> agences = new ArrayList<>();
        String req = "select * from users where roles='a:1:{i:0;s:11:\"ROLE_AGENCE\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               //                                        String role,               String nom,                   String email,                 String password,               int numtel,              String adresse,             int nbr_voyage_organise
                Agence agence = new Agence(resultSet.getString("roles"),resultSet.getInt("id_user"), resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getInt("nbr_voyage_organise"));
                agences.add(agence);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agences;
    }
          
          public int nbrAV() {
             int i=0;
            String req = "SELECT COUNT(*) AS total FROM users where roles='a:1:{i:0;s:11:\"ROLE_AGENCE\";}'";
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
          
          
           public Agence findByEmail(String e) {
               Agence g = null;
        String req = "select * from users where email=? and roles='a:1:{i:0;s:11:\"ROLE_AGENCE\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, e);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //String role, String nom,                                         String email, String password, int numtel,                           String adresse,int nbr_voyage_organise
                   g=new Agence(resultSet.getString("roles"), resultSet.getString("nom"),resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("numtel"), resultSet.getString("adresse"), resultSet.getInt("nbr_voyage_organise"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
          
        }
        System.out.println("agence:"+g);
        return g;
    }
      

         
      /*   public List<Agence> getByRole() {
         List<Agence> agences = new ArrayList<>();
        String req = "select * from users where role='agence de voyage'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               //                                        String role,               String nom,                   String email,                 String password,               int numtel,              String adresse,             int nbr_voyage_organise
                Agence agence = new Agence(resultSet.getString("role"),resultSet.getInt("id_user"), resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("numTel"),resultSet.getString("adresse"),resultSet.getInt("nbr_voyage_organise"));
                agences.add(agence);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agences;
    }*/
          
       /*   public int nbrAV() {
             int i=0;
            String req = "SELECT COUNT(*) AS total FROM users where role='agence de voyage'";
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
}*/
      
}
