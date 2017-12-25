/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.sevices;
import edu.esprit.pidev.interfaces.IServiceForum;
import edu.esprit.pidev.models.Car;
import edu.esprit.pidev.models.Forum;
import edu.esprit.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author omarfarouk
 */
public class ForumService implements IServiceForum{

     //setting connection
    
    Connection connection;
    
    //setting constructor

    public ForumService() {
        connection = DataSource.getInsatance().getConnection();
    }
    
    
    // CRUD methods Forum
    

    @Override
    public void post(Forum f) {
        //insert method    
       String query =" insert into t_voiture (user_id,post_id,image,title,content,topic,date) values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement statement =connection.prepareStatement(query); 
            statement.setInt(1, f.getUserId());
            statement.setInt(2, f.getPostId());
            statement.setString(3, f.getImage());
            statement.setString(4, f.getTitle());
            statement.setString(5, f.getContent());
            statement.setString(6, f.getTopic());
            statement.setDate(7, f.getDate());
            
            int postadd=statement.executeUpdate();
            if(postadd>0){System.out.println("post added");}
            
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();}
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer z) {
       
           String query="DELETE FROM t_voiture where post_id=?";
      try{
          PreparedStatement statement = connection.prepareStatement(query);
          statement.setInt(1,z);
          int rowD =statement.executeUpdate();
          if(rowD>0){
          System.out.println("A car was deleted successfully!");
          }
          
        } catch(SQLException ex){
            ex.printStackTrace();
      }
    }

    @Override
    public List<Forum> getAll() {
      List<Forum> topicList = new ArrayList<>();
        String query = "SELECT * FROM t_voiture";
        try{
             PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                
            Forum F = new Forum();
                F.setContent(result.getString(4));
                F.setTopic(result.getString(6));
                F.setDate(result.getDate(7));
            System.out.println(F);
            topicList.add(F);
            }
            }catch(SQLException ex){
            ex.printStackTrace();
        }
        System.out.println(topicList);
        return topicList;
    
    }
     
    public void start(Stage stage)throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("edu/esprit/pidev/gui/FXMLReserverHotel.fxml"));
//        Parent roote = FXMLLoader.load(getClass().getResource(""))
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
}
