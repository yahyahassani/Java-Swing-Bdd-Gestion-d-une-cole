
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
public class Absent {
     private int ide;
  private String nommat;
  private String justifica;//coeficient de la matiere
  private int  nbr_heure;

    public Absent(int ide, String nommat, String justifica, int nbr_heure) {
        this.ide = ide;
        this.nommat = nommat;
        this.justifica = justifica;
        this.nbr_heure = nbr_heure;
    }
   
  public void insertupdatedeletabsent(int ide,String nommat,String justifica,int nbr_heure){
      Connection con=Myconnexion.connectDB();
    PreparedStatement pas;
        try{
            int col = 1;
            pas=con.prepareStatement("INSERT INTO `absent`(`ide`, `namemat`, `justifica`,`nbr_heure`) VALUES (?,?,?,?)");
            pas.setInt(col, ide);
            pas.setString(++col, nommat);
            pas.setString(++col, justifica);
            pas.setInt(++col, nbr_heure);
            if(pas.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "absence marqué");
                        }
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
}
