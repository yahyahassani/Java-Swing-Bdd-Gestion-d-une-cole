

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YAHYA
 */
public class Filiere {
    private String Name;
    private Vector<Matiere> listofmatiers;
    private Vector<Etudiant> listofstudents;

    public Filiere(String Name, Vector<Matiere> listofmatiers, Vector<Etudiant> listofstudents) {
        this.Name = Name;
        this.listofmatiers = listofmatiers;
        this.listofstudents = listofstudents;
    }
//    public void insertfiliere(){
//        Connection con=Myconnexion.connectDB();
//        PreparedStatement pas;
////        pas=con.prepareStatement("insert into filiere ")
//        
//        
//    }
public void ajouterEtudiant(Etudiant etu){
    listofstudents.add(etu);
}
public void supEtudiant(Etudiant etu){
    listofstudents.remove(etu);
}
public void ajouterMatiere(Matiere mat){
    listofmatiers.add(mat);
}
public void supMatiere(Matiere mat){
    listofmatiers.remove(mat);
}
   public double moyGen(){
    Matiere m;
    double moyenne=0;
    int size=listofmatiers.size(),coef=0;
    for(int i=0;i<size;i++){
      m=(Matiere)listofmatiers.elementAt(i);
      moyenne+=m.moy()*m.getCoef();
      coef+=m.getCoef();
    }
    return moyenne/coef;
  }

    public Vector<Matiere> getListofmatiers() {
        return listofmatiers;
    }

    public Vector<Etudiant> getListofstudents() {
        return listofstudents;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
  
    
}
