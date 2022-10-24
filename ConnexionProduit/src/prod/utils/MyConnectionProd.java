/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import prod.entity.Produit;

/**
 *
 * @author asus
 */
public class MyConnectionProd {

    
     public String url="jdbc:mysql://localhost:3306/tabibi";
    public String login="root";
     public String pwd="";
     
     Connection cnx;
     public static MyConnectionProd instance;
     
     public MyConnectionProd(){
         try {
            cnx = DriverManager.getConnection(url, login, pwd);
                    System.out.println("Connexion etablie!");
                    } catch (SQLException ex) {
                         System.err.println(ex.getMessage());
                     }
     }
    
     public Connection getCnx(){
         return cnx;
     }
       public static MyConnectionProd getInstance(){
     if(instance == null){
     instance = new MyConnectionProd();
     }
     return instance;
     }
  
      /* public static ObservableList<Produit> getDataProduits(){
           MyConnectionProd cnx = instance;
           ObservableList<Produit> list =FXCollections.observableArrayList();
           try {
               PreparedStatement ps =cnx.prepareStatement("select * from produit");
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
                   list.add(new produit(Integer.parseInt(rs.getInt("id_prod")),rs.getString("nom_prod"),rs.getString("discription"),rs.getString("reference"), Integer.parseInt(rs.getInt("prix")), rs.getString("categories"));
           
               }
           } catch (Exception e) {
           }
           return list;
       }

    private PreparedStatement prepareStatement(String select__from_produit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
       
       
       
}
