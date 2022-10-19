/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.services;

import prod.entity.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import prod.entity.Panier;
import prod.entity.Produit;
import prod.utils.MyConnectionProd;

/**
 *
 * @author asus
 */
public class PanierCRUD {
    
     Connection cnx2;
    public PanierCRUD(){
        cnx2 = MyConnectionProd.getInstance().getCnx();
        
    }
 public void ajouterPanier(Panier p ){
        try {
            String requete1 = "INSERT INTO panier (id_produit,quantite,id_patient) VALUES(?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete1);
          
            pst.setInt(1,p.getId_produit());
            pst.setInt(2,p.getQuantite());
            pst.setInt(3,p.getId_patient());
           
            pst.executeUpdate();
            System.out.println("Produit est ajoutée au painer avec succée!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
             
        }
           
    }
  public void modifierPanier(Panier P, int id){
        try {
            String requete2= "UPDATE panier SET quantite=? WHERE id_panier= '" +id+ "'";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
          
            pst.setInt(1, P.getQuantite());
           
            pst.executeUpdate();
            System.out.println("Produit est modifie avec  succeé!");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
    }
  
   public void deletePanier(int id_panier){
       
         PreparedStatement pst = null;
        try {
            String requete3 = "DELETE FROM panier WHERE id_panier=? ";
            pst = new MyConnectionProd().getCnx().prepareStatement(requete3);
            pst.setInt(1, id_panier);
            pst.execute();
            System.out.println("Produit supprimer avec succés!");

        } catch (SQLException ex) {
               System.err.println(ex.getMessage());
        }
              
     }
   
   
   
  /* public List<Panier> afficherPanier(){
                    List<Panier> myList = new ArrayList<>();

        try {
            String requete4 = "SELECT nom_prod, discription, reference, categories FROM Produit, Panier WHERE Produit.id_prod=Panier.id_produit ";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete4);
           
            while(rs.next()){
                Panier p = new Panier();
                Produit pr = new Produit();
                p.setId_panier(rs.getInt(1));
                p.setId_produit(rs.getInt(2));
                p.setQuantite(rs.getInt(3));
                p.setId_patient(rs.getInt(4));
                
                //pr.setId_prod(rs.getInt(1));
                pr.setNom_prod(rs.getString("nom_prod"));
                pr.setDiscription(rs.getString("discription"));
                pr.setReference(rs.getString("reference"));
                pr.setPrix(rs.getInt(4));
                pr.setCategories(rs.getString("categories"));
           
                myList.add(p);
            }
           
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());

        }
        return myList;
        
    }*/
   
   
   private ResultSet rs;
   public List<Panier> afficherPanier(int id){
   
    List<Panier> list = new ArrayList<>();
         String req = "SELECT `nom_prod`, `discription`,`reference`,`prix`, `categories`,`Nom_patient`, `Prénom_patient`, `quantite`"
                
                 + " FROM`Panier` JOIN `patient` ON panier.id_panier=patient.id_patient JOIN `produit`"
                 + "ON panier.id_panier=produit.Id_prod WHERE panier.id_patient = "+id+"   ";
       

        try {
            Statement st = cnx2.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()) {
               
                Panier p = new Panier();
                Produit pr = new Produit();
                Patient pat = new Patient();
                
                //p.setId_panier(rs.getInt("id_panier"));
                //p.setId_prod(rs.getInt("id_prod"));
                p.setQuantite(rs.getInt("quantite"));
                //p.setId_patient(rs.getInt("id_patient"));
                
                pat.setNom_patient(rs.getString("Nom_patient"));
                pat.setPrénom_patient(rs.getString("Prénom_patient"));
                
                //pr.setId_prod(rs.getInt("id_prod"));
                pr.setNom_prod(rs.getString("nom_prod"));
                pr.setDiscription(rs.getString("discription"));
                pr.setReference(rs.getString("reference"));
                pr.setPrix(rs.getInt("prix"));
                pr.setCategories(rs.getString("categories"));
                
                p.setPat(pat);
                p.setPr(pr);
                list.add(p);
                
            }
            System.out.println("panier est afficher avec succée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     return list;
    }
   
   
   /*/////////////////////////*****************///////////////////////////////*/
   
    /*public List<Panier> afficherPanier1(){
                    List<Panier> myList = new ArrayList<>();

        try {
            String reqA = "SELECT * FROM panier";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(reqA);
            while(rs.next()){
                Panier p = new Panier();
                p.setId_panier(rs.getInt(1));
                p.setId_produit(rs.getInt(2));
                p.setQuantite(rs.getInt(3));
                p.setId_patient(rs.getInt(4));
   
             
                myList.add(p);
            }
           
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());

        }
        return myList;
        
    }*/
   
   
   
  /* public List<Panier> afficherPanier2(){
                    List<Panier> myList = new ArrayList<>();

        try {
            String reqA = "SELECT `Nom_patient`,`Prénom_patient`,panier.id_panier,id_patient FROM patient INNER JOIN panier ON patient.id_patient=panier.id_patient";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(reqA);
            while(rs.next()){
                Panier p = new Panier();
                //Produit pr = new Produit();
                Patient pat = new Patient();
                p.setId_panier(rs.getInt(1));
                p.setId_produit(rs.getInt(1));
                p.setQuantite(rs.getInt(2));
                p.setId_patient(rs.getInt(3));
                
                pat.setNom_patient(rs.getString("Nom_patient"));
                pat.setPrénom_patient(rs.getString("Prénom_patient"));
                
                //pr.setId_prod(rs.getInt(1));
                //pr.setNom_prod(rs.getString("nom_prod"));
                //pr.setDiscription(rs.getString("discription"));
                //pr.setReference(rs.getString("reference"));
                //pr.setPrix(rs.getInt(4));
                //pr.setCategories(rs.getString("categories"));
                
               // p.setPr(pr);
               p.setPat(pat);
                myList.add(p);
            }
           
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());

        }
        return myList;
   }
    */
   
}
    

