/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.tests;
import static java.awt.PageAttributes.MediaType.A;
import prod.entity.Achat;
import prod.entity.Produit;
import prod.services.AchatCRUD;
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
        //pcd.deleteProduit(5);        
       //Produit P = new Produit (5,"hrabch" , "douleur", "MF823", 1530, "medicament");
        //pcd.modifierProduit(P);       
        //System.out.println(pcd.RechercherByNom("rouge"));
        //System.out.println(pcd.RechercherByDiscription("red color"));
        //System.out.println(pcd.RechercherByCategories("medicament"));
        
        AchatCRUD acd = new AchatCRUD();
        //Achat a = new Achat("Doliprane",2,5000,2500,"10-10-2022");
        //acd.ajouterAchat(a);
        //System.out.println(acd.afficherAchat());
        //acd.deleteAchat(1);
        acd.UpdateQuantité(2, 9, 1000);
        
        
        
        
        
        //PanierCRUD ppcd = new PanierCRUD();
        //Panier p = new Panier(2,5,2);
        //ppcd.ajouterPanier(p);
        //Panier P = new Panier(8);
        //ppcd.modifierPanier(P, 4);
        //ppcd.deletePanier(5);
       //System.out.println(ppcd.afficherPanier(2).toString());
       // System.out.println(ppcd.afficherPanier1());
        //System.out.println(ppcd.afficherPanier2());
        
    }
    
}
