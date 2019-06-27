
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YAHYA
 */
public class Myconnexion {
    
    
    
    
     public static Connection connectDB(){
    
    
    String mydriver="com.mysql.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/app";
   
    
        try {
            Class.forName(mydriver);///: Charger le pilote pour la base MYSQL avec cette ligne de code : 
               Connection con=DriverManager.getConnection(url, "root", "");//Etablir une connexion est d’avoir le pilote approprié 
                                                                            
                Statement stmt = con.createStatement();
                
               JOptionPane.showMessageDialog(null,"Connected");
               return con;
              
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Not connected");
          
        }
         return null;
 
    
}

}