/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prod.entity;

/**
 *
 * @author asus
 */
public class Achat {
     public int	id_achat;
    public String nom_produit;
    public  int quantité ;	
    public float prix_total ;	 
    public float prix_unitaire ;
     public   String date_achat;
     
      public Achat(){
        
    }

    public Achat(int id_achat, String nom_produit, int quantité, float prix_total, float prix_unitaire, String date_achat) {
        this.id_achat = id_achat;
        this.nom_produit = nom_produit;
        this.quantité = quantité;
        this.prix_total = prix_total;
        this.prix_unitaire = prix_unitaire;
        this.date_achat = date_achat;
    }

    public Achat(String nom_produit, int quantité, float prix_total, float prix_unitaire, String date_achat) {
        this.nom_produit = nom_produit;
        this.quantité = quantité;
        this.prix_total = prix_total;
        this.prix_unitaire = prix_unitaire;
        this.date_achat = date_achat;
    }
    

    public int getId_achat() {
        return id_achat;
    }

    public void setId_achat(int id_achat) {
        this.id_achat = id_achat;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }

    @Override
    public String toString() {
        return "Achat{" + "id_achat=" + id_achat + ", nom_produit=" + nom_produit + ", quantit\u00e9=" + quantité + ", prix_total=" + prix_total + ", prix_unitaire=" + prix_unitaire + ", date_achat=" + date_achat + '}';
    }
     
     
    
}
