/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nouha
 */
public class DataSource {
    String url="jdbc:mysql://localhost:3306/govoyagedb";
    String login="root";
    String password="";
    private Connection connection;
    private static DataSource instance;

    private DataSource() {
        
        try {
            connection= DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return this.connection;
    }

    public static DataSource getInstance() {
        
        if(instance == null)
            instance=new DataSource();
        return instance;
    }

    
    
    
    
    
    
}
