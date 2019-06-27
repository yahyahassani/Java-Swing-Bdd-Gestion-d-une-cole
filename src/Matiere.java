
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YAHYA
 */
public class Matiere {
    private int nbr_heures;
  private String nom;
  private float ds,tp,DM;
  private int coef;//coeficient de la matiere

    public Matiere(int nbr_heures, String nom, int coef) {
        this.nbr_heures = nbr_heures;
        this.nom = nom;
        this.coef = coef;
    }


  
  public float getDs() {
    return ds;
  }
  public float getDM() {
    return DM;
  }
  public String getNom() {
    return nom;
  }
  public float getTp() {
    return tp;
  }
  //calcul du moyenne d'une matiere
  public double moy() {
     if(tp>0) return tp*0.4+0.6*(DM*2+ds)/3; //si la matiere a un tp
    else return (DM*2+ds)/3;
  }
  
  
  public int getCoef() {
    return coef;
  }
  public void setDs(float ds) {
    this.ds = ds;
  }
  public void setDM(float DM) {
    this.DM = DM;
  }
  public void setTp(float tp) {
    this.tp = tp;
  }
  public void insertupdatedeletmatiere(String name,Integer coef,Integer nbr_heure,Boolean Tp,int ideprof){
    Connection con=Myconnexion.connectDB();
    PreparedStatement pas;
        try{
            int col = 1;
            pas=con.prepareStatement("INSERT INTO `matiere`(`Nom`, `coef`, `nbr_heure`,`Tp`, `idprof`) VALUES (?,?,?,?,?)");
            pas.setString(col, name);
            pas.setInt(++col, coef);
            pas.setInt(++col, nbr_heure);
            pas.setBoolean(++col,Tp );
            pas.setInt(++col,ideprof );
            if(pas.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "new matiere is added");
                        }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
      
  

//public void remplirtab(JTable tableau){
//    Connection con =Myconnexion.connectDB();
//    PreparedStatement pas;
//        try {
//            pas=con.prepareStatement("SELECT * FROM matiere");
//            ResultSet resultat=pas.executeQuery();
////            pas.setString(1, valuetosearch);
//            ResultSet rs=pas.executeQuery();
//            DefaultTableModel model=(DefaultTableModel) tableau.getModel();
//            tableau.setModel(DbUtils.resultSetToTableModel(rs));
//            } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    
//}
    
    
    
    
}
