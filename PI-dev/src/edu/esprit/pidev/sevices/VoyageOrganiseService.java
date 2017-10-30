/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.esprit.pidev.sevices;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.List;
import edu.esprit.pidev.interfaces.IVOService;
import edu.esprit.pidev.models.VoyageOrganise;
import edu.esprit.pidev.techniques.DataSource; 
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zakiya
 */
public class VoyageOrganiseService implements IVOService{
    
    Connection connection;

    public VoyageOrganiseService() {
        connection = DataSource.getInsatance().getConnection();
    }
 

   @Override
    public void add(VoyageOrganise v) { 

//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    //   Date d1= v.getDateDebutVoy();
      
        String req = "insert into voyageorganise (titreVoyage,DateDebutVoy,DateFinVoy,description,prix) values (?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
       
            preparedStatement.setString(1, v.getTitreVoyage());
           preparedStatement.setDate(2, v.getDateDebutVoy());
           preparedStatement.setDate(3,  v.getDateFinVoy());
            preparedStatement.setString(4, v.getDescription());
           preparedStatement.setFloat(4, v.getPrix());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
@Override
    public void remove(Integer id) {
        String req = "delete from voyageorganise where id_voyage=?";
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
    public void update(VoyageOrganise v) {
        String req = "update voyageorganise  set titreVoyage= ?,set dateDebutVoy=?,set dateFinVoy=? ,set description= ? ,set prix= ?  where id_voyage = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setString(2, v.getTitreVoyage());
            preparedStatement.setDate(3, (Date) v.getDateDebutVoy());
            preparedStatement.setDate(4, (Date) v.getDateFinVoy());
            preparedStatement.setString(5, v.getDescription());
            preparedStatement.setFloat(2, v.getPrix());

      
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


}

@Override


    public List<VoyageOrganise> getAll() {
        List<VoyageOrganise> voyages = new ArrayList<>();
        String req = "select * from voyageorganise";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VoyageOrganise voyage = new VoyageOrganise(resultSet.getInt("id_voyage"), resultSet.getString("titreVoyage"),(Date)resultSet.getDate("dateDebutVoy"),(Date) resultSet.getDate("datFinVoy"),resultSet.getString("description"),resultSet.getFloat("prix"));
                voyages.add(voyage);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voyages;
    }

     @Override
    public VoyageOrganise findById(Integer id) {
        VoyageOrganise voyage = null;
        String req = "select * from voyageorganise where id_voyage=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
             voyage = new VoyageOrganise(resultSet.getInt("id_voyage"), resultSet.getString("titreVoyage"),(Date)resultSet.getDate("dateDebutVoy"),(Date) resultSet.getDate("dateFinVoy"),resultSet.getString("description"),resultSet.getFloat("prix"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voyage;
     
}
    public List<VoyageOrganise> getAllcondition(Date d1,Date d2,float prix) {
        List<VoyageOrganise> voyages = new ArrayList<>();
        String req = "select * from voyageorganise where prix < ? and dateDebutVoy > ? and dateFinVoy < ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setFloat(1, prix);
            preparedStatement.setDate(2, d1);
            preparedStatement.setDate(3, d2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VoyageOrganise voyage = new VoyageOrganise(resultSet.getInt("id_voyage"), resultSet.getString("titreVoyage"),(Date)resultSet.getDate("dateDebutVoy"),(Date) resultSet.getDate("dateFinVoy"),resultSet.getString("description"),resultSet.getFloat("prix"));
                voyages.add(voyage);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voyages;
    }

      @Override
    public int nouveauVoyageId() {
        int id = 0;
        try {
            String req = "SELECT max(id_voyage) as id FROM evenements ";
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");

            }
        } catch (SQLException ex) {
            Logger.getLogger(VoyageOrganiseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (id + 1);
    }
    // getall by idagence 

    @Override

    public List<VoyageOrganise> getAllByIdAgence(int id) {
        List<VoyageOrganise> voyages = new ArrayList<>();
        String req = "select * from voyageorganise where id_agence= ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                VoyageOrganise voyage = new VoyageOrganise(resultSet.getInt("id_voyage"), resultSet.getString("titreVoyage"), resultSet.getDate("dateDebutVoy"), resultSet.getDate("dateFinVoy"), resultSet.getString("description"), resultSet.getFloat("prix"), resultSet.getDate("dateLimiteRes"), resultSet.getInt("nbrePlacesDisp"), resultSet.getInt("nbrePlacesRes"), new AgenceService().findById(resultSet.getInt("id_agence")));
                voyages.add(voyage);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voyages;
    }

    public List<VoyageOrganise> getTableByIdAgence(int id) {
        List<VoyageOrganise> voyages = new ArrayList<>();
        String req = "select *  from voyageorganise where id_agence= ? ";
        //AND dateDebutVoy > DATE(NOW()
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                VoyageOrganise voyage = new VoyageOrganise(resultSet.getInt("id_voyage"), resultSet.getString("titreVoyage"), resultSet.getDate("dateDebutVoy"), resultSet.getDate("dateFinVoy"), resultSet.getString("description"), resultSet.getFloat("prix"), resultSet.getDate("dateLimiteRes"), resultSet.getInt("nbrePlacesDisp"), resultSet.getInt("nbrePlacesRes"), new AgenceService().findById(resultSet.getInt("id_agence")));
                voyages.add(voyage);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voyages;
    }

    public VoyageOrganise AjoutCond(VoyageOrganise v ) {
        VoyageOrganise voyage = null ; 
        String req = "select *  from voyageorganise where titreVoyage = ? AND dateDebutVoy = ? AND dateFinVoy=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
             preparedStatement.setString(1, v.getTitreVoyage());
            preparedStatement.setDate(2, v.getDateDebutVoy());
            preparedStatement.setDate(3, v.getDateFinVoy());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                voyage = new VoyageOrganise(resultSet.getInt("id_voyage"), resultSet.getString("titreVoyage"), resultSet.getDate("dateDebutVoy"), (Date) resultSet.getDate("dateFinVoy"), resultSet.getString("description"), resultSet.getFloat("prix"), resultSet.getDate("dateLimiteRes"), resultSet.getInt("nbrePlacesDisp"), resultSet.getInt("nbrePlacesRes"), new AgenceService().findById(resultSet.getInt("id_agence")));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voyage;

    }
}
