/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.tests;

import prod.entity.Panier;
import prod.entity.Produit;
import prod.services.PanierCRUD;
import prod.services.ProduitCRUD;
import prod.utils.MyConnectionProd;

/**
 *
 * @author asus
 */
public class MainCnxProd {
    public static void main(String[] args){
        MyConnectionProd mcp =new MyConnectionProd();
        //Produit p = new Produit("sirout","gorge","hdh546",500,"medicament");
          
        ProduitCRUD pcd = new ProduitCRUD();
        
        //pcd.ajouterProduit2(p);
        //System.out.println(pcd.afficherProduit());
        //pcd.deleteProduit(1);        
        //Produit P = new Produit (2,"rouge" , "red color", "MF452", 15000, "makup");
        //pcd.modifierProduit(P);       
        //System.out.println(pcd.RechercherByNom("rouge"));
        //System.out.println(pcd.RechercherByDiscription("red color"));
        //System.out.println(pcd.RechercherByCategories("medicament"));
        
        PanierCRUD ppcd = new PanierCRUD();
        //Panier p = new Panier(2,5,2);
        //ppcd.ajouterPanier(p);
        //Panier P = new Panier(8);
        //ppcd.modifierPanier(P, 4);
        //ppcd.deletePanier(5);
       System.out.println(ppcd.afficherPanier(2).toString());
       // System.out.println(ppcd.afficherPanier1());
        //System.out.println(ppcd.afficherPanier2());
        
    }
    
}
