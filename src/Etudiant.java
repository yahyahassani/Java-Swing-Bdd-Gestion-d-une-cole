

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import sun.util.logging.PlatformLogger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YAHYA
 */
public class Etudiant {
    
    
// private int idEtud; //numero de la carte d'etudiant de l'eleve distribué automatiquement
    private Integer idEtud;
  private String nom,adresse, prenom, sexe,nomtitulaire,prenomtitulaire,professiontitulaire,contact;
//  private Date dn; //date de naissance
  private String dn;
//  private Filiere grade; //la num du class  contient nom de la classe et liste des matieres avec notes
 private String grade;
//
//    Etudiant() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
     Connection con=Myconnexion.connectDB();
public void insertupdatedeletetudiant(Integer idEtud,String sexe,String nom,String prenom,String dn,String grade,String adresse,String nomtitulaire,String prenomtitulaire,String professiontitulaire,String contact){
//    Connection con=Myconnexion.connectDB();
    PreparedStatement pas;
//    if (operation=='i'){
        try{
            int col = 1;
     pas=con.prepareStatement("INSERT INTO etudiant(ide, sexe, nom, prenom, date_nassaince, grade, adresse, npapa, ppapa, propapa, contact) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
//pas=con.prepareStatement("INSERT INTO etudiant( ide,sexe, nom, prenom, date_nassaince, grade, adresse, npapa, ppapa, propapa, contact) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pas.setInt(col, idEtud);
            pas.setString(++col, sexe);
            pas.setString(++col, nom);
            pas.setString(++col, prenom);
            pas.setString(++col, dn);
            pas.setString(++col,grade);
            pas.setString(++col, adresse);
            pas.setString(++col, nomtitulaire);
            pas.setString(++col, prenomtitulaire);
            pas.setString(++col, professiontitulaire);
            pas.setString(++col, contact);
//            ResultSet okk=pas.executeQuery();
            if(pas.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "new student is added");
            }
           
         
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "IDE already used");
            java.util.logging.Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
            
        }
      
        
//    }
      
  }
public void remplirtableau(JTable table1){
//    Connection con =Myconnexion.connectDB();
    PreparedStatement pas;
        try {
            pas=con.prepareStatement("SELECT ide,nom,prenom,grade FROM `etudiant");
            ResultSet resultat=pas.executeQuery();
//            pas.setString(1, valuetosearch);
            ResultSet rs=pas.executeQuery();
            DefaultTableModel model=(DefaultTableModel) table1.getModel();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
//            Object[] row;
//            while(rs.next()){
//                row=new Object[11];
//                row[0]=rs.getString(1);
//                row[1]=rs.getString(3);
//                row[2]=rs.getString(4);
//                row[3]=rs.getString(6);
//row[4]=rs.getString(2);
//row[5]=rs.getString(5);
//row[6]=rs.getString(7);
//row[7]=rs.getString(8);
//row[8]=rs.getString(9);
//row[9]=rs.getString(9);
//row[10]=rs.getString(10);
//
//                model.addRow(row);
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
}
//public static int count(String Tablename){
//    int s=0;
//  
//    
//    try{
//        Statement st=con.createStatement();
//        ResultSet rs=st.executeQuery("SELECT count (*) AS 's' FROM "+Tablename);
//        while(rs.next()){
//            s=rs.getInt(1);
//        }
//    }
//    catch(SQLException ex){
//        java.util.logging.Logger.getLogger(espaceEtu.class.getName()).log(Level.SEVERE,null,ex);
//    }
//    return s;
//}
public void cherchetable(JTable table1,String valuetosearch){
    PreparedStatement pas;
    
        try {
            pas=con.prepareStatement("select ide,nom,prenom,grade from etudiant where concat(ide,nom,prenom,grade)like '%"+valuetosearch+"%'");
            ResultSet rs=pas.executeQuery();
             DefaultTableModel model=(DefaultTableModel) table1.getModel();
            table1.setModel(DbUtils.resultSetToTableModel(rs));

                    } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


  //constructeur de la classe etudiant
//  public Etudiant(int ce, String n, String p, Date d, String s, Filiere g) {
//    idEtud = ce;
//    nom = n;
//    prenom = p;
//    dn = d;
//    sexe = s;
//    grade = g;
//  }

//  public Etudiant(String idEtud, String nom, String prenom, String sexe, String prenomtitulaire, String nomtitulaire , String professiontitulaire, String contact, String dn, String grade) {
//        this.idEtud = idEtud;
//        this.nom = nom;
//        this.prenom = prenom;
//        this.sexe = sexe;
//        this.nomtitulaire = nomtitulaire;
//        this.prenomtitulaire = prenomtitulaire;
//        this.professiontitulaire = professiontitulaire;
//        this.contact = contact;
//        this.dn = dn;
//        this.grade = grade;
//  }

    public Etudiant( Integer idEtud,String nom, String adresse, String prenom, String sexe, String nomtitulaire, String prenomtitulaire, String professiontitulaire, String contact, String dn, String grade) {
        this.idEtud = idEtud;
        this.nom = nom;
        this.adresse = adresse;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nomtitulaire = nomtitulaire;
        this.prenomtitulaire = prenomtitulaire;
        this.professiontitulaire = professiontitulaire;
        this.contact = contact;
        this.dn = dn;
        this.grade = grade;
    }

    public String getDn() {
        return dn;
    }

    public String getGrade() {
        return grade;
    }



  public Integer getIdEtud() {
    return idEtud;
  }


  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public String getSexe() {
    return sexe;
  }
  public void setDn(String dn) {
    this.dn = dn;
  }

    public void setGrade(String grade) {
        this.grade = grade;
    }
 
  public void setNom(String nom) {
    this.nom = nom;
  }
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
  public void setSexe(String sexe) {
    this.sexe = sexe;
  }
  
}
