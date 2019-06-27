
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
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
public class Note {

    public Note(float ds, float tp, float DM) {
        this.ds = ds;
        this.tp = tp;
        this.DM = DM;
    }

    
     private float ds,tp,DM;
    public double moy() {
        if(tp>0) return tp*0.4+0.6*(DM*2+ds)/3; //si la matiere a un tp
    else return (DM*2+ds)/3;
    }
    
    
    public void insertupdatedeletnote(int ideEtudiant,String Nommatiere,float ds,float tp,float DM,Integer coef,Double M){
    Connection con=Myconnexion.connectDB();
    PreparedStatement pas;
  
        try{
            int col = 1;
            pas=con.prepareStatement("INSERT INTO `note`(`ideEtudiant`, `Nommatiere`, `ds`,`tp`,`DM`,`coef`,`Moy`) VALUES (?,?,?,?,?,?,?)");
            //note(ideEtudiant ,Nommatiere,ds,tp,DM,coef)  select ide from Etudiant * select nommatiere,ds,tp,DM,coef//trop de shit im gonna just create anothere table 
            pas.setInt(col, ideEtudiant);
            pas.setString(++col, Nommatiere);
            pas.setFloat(++col, ds);
            pas.setFloat(++col,tp );
            pas.setFloat(++col,DM );
            pas.setFloat(++col,coef );
            pas.setDouble(++col,M);
            if(pas.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "note enregistré");
                        }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Matiere.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    
      
  }
    
}
