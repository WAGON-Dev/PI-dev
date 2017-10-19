package edu.esprit.pidev.sevices;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import edu.esprit.pidev.interfaces.IVolService;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Vol;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nouha
 */
public class VolService implements IVolService {

    Connection connection;
    PreparedStatement ps;

    public VolService() {
        this.connection = DataSource.getInsatance().getConnection();
        System.out.println("etablir de connection....");
    }

    @Override
    public void addVolWithStatement(Vol vol) {
        java.sql.Date d2 = null;
        java.sql.Date d3 = null;
        if (vol.getDate_depart() != null && vol.getDate_arrivee() != null) {
            d2 = new java.sql.Date(vol.getDate_depart().getTime());
            d3 = new java.sql.Date(vol.getDate_arrivee().getTime());
        }

        String req = "insert into vol values ('" + vol.getNumTicket() + "','" + d2 + "','" + d3 + "','" + vol.getPrix_vol() + "','" + vol.getNom_Vol() + "','" + vol.getDepart() + "','" + vol.getArrivee() + "','" + vol.getNom_Compagnie() + "','" + vol.getClient_vol_fk() + "')";
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(req);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("done inserting");
    }

    @Override
    public void add(Vol vol) {
        String req = "insert into vol(date_depart,date_arrivee,prix_vol,nom_vol,depart,arrivee,nom_compagnie,client_vol_fk) values(?,?,?,?,?,?,?,?) ";

        try {
            ps = connection.prepareStatement(req);

            java.sql.Date d2 = new java.sql.Date(vol.getDate_depart().getTime());
            java.sql.Date d3 = new java.sql.Date(vol.getDate_arrivee().getTime());
            ps.setDate(1, d2);
            ps.setDate(2, d3);
            ps.setDouble(3, vol.getPrix_vol());
            ps.setString(4, vol.getNom_Vol());
            ps.setString(5, vol.getDepart());
            ps.setString(6, vol.getArrivee());
            ps.setString(7, vol.getNom_Compagnie());
            ps.setInt(8, vol.getClient_vol_fk());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void remove(Integer numTicket) {
        String req = "delete from vol where numTicket=?";

        try {
            ps = this.connection.prepareStatement(req);
            ps.setInt(1, numTicket);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("done");

    }

    @Override
    public void update(Vol vol) {
        String req = "update vol set date_depart=?,date_arrivee=?,prix_vol=?,nom_vol=?,depart=?,arrivee=?,nom_Compagnie=?,client_vol_fk=? where numTicket=" + vol.getNumTicket();

        try {
            ps = connection.prepareStatement(req);

            java.sql.Date d2 = new java.sql.Date(vol.getDate_depart().getTime());
            java.sql.Date d3 = new java.sql.Date(vol.getDate_arrivee().getTime());

            ps.setDate(1, d2);
            ps.setDate(2, d3);
            ps.setDouble(3, vol.getPrix_vol());
            ps.setString(4, vol.getNom_Vol());
            ps.setString(5, vol.getDepart());
            ps.setString(6, vol.getArrivee());
            ps.setString(7, vol.getNom_Compagnie());
            ps.setInt(8, vol.getClient_vol_fk());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Vol> getAll() {
        List<Vol> vols = new ArrayList<>();
        String req = "select * from vol";
        try {
            ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Vol vol = new Vol(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getInt(9), rs.getString(6), rs.getString(7), rs.getString(8));

                vols.add(vol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (vols == null) {
            return null;
        }
        return vols;

    }

    @Override
    public List<Vol> getByClient(Client c) {
        List<Vol> vols = new ArrayList<>();
        String req = "select * from vol where client_vol_fk=?";

        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, c.getId_user());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //  Client 
                Vol vol = new Vol(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getInt(9), rs.getString(6), rs.getString(7), rs.getString(8));
                vols.add(vol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (vols == null) {
            return null;
        }
        return vols;
    }

    @Override
    public Vol findById(Integer id) {

        Vol vol = null;
        String req = "select *  from vol where numTicket=?";

        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client();
                c.setId_user(rs.getInt(9));
                vol = new Vol(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getInt(9), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vol;
    }

}
