
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
public class Prof {
     private Integer idp;
  private String nom,prenom;

    public Prof(Integer idp, String nom, String prenom) {
        this.idp = idp;
        this.nom = nom;
        this.prenom = prenom;
    }
  public void insertupdatedeletprof(Integer idp,String prenom, String nom ){
    Connection con=Myconnexion.connectDB();
    PreparedStatement pas;
        try{
            int col = 1;
     pas=con.prepareStatement("INSERT INTO `prof`(`idp`, `fnamep`, `lnamep`) VALUES (?,?,?)");
            pas.setInt(col, idp);
            pas.setString(++col,prenom );
            pas.setString(++col, nom);
            if(pas.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "new prof is added");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "THIS IDE IS ALREADY USED ! \n TRY TO CHANGE IT !! ","Attention",JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog()
            java.util.logging.Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public void remplirtableau(JTable table1){
    Connection con =Myconnexion.connectDB();
    PreparedStatement pas;
        try {
            pas=con.prepareStatement("SELECT * from`prof");
            ResultSet resultat=pas.executeQuery();
            ResultSet rs=pas.executeQuery();
            DefaultTableModel model=(DefaultTableModel) table1.getModel();
            table1.setModel(DbUtils.resultSetToTableModel(rs));   
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Prof.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
