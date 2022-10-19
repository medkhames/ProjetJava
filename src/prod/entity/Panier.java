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
public class Panier {
     private int id_panier;
    private int id_produit;
    private int quantite;
    private int id_patient;
    private Patient pat;
    private Produit pr;
    
     public Panier(){
        
    }

    public Panier(int quantite) {
        this.quantite = quantite;
    }

    public Panier(int id_panier, int id_produit, int quantite, int id_patient, Patient pat, Produit pr) {
        this.id_panier = id_panier;
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.id_patient = id_patient;
        this.pat = pat;
        this.pr = pr;
    }

    public Panier(int id_produit, int quantite, int id_patient, Patient pat, Produit pr) {
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.id_patient = id_patient;
        this.pat = pat;
        this.pr = pr;
    }

    public Panier(int id_produit, int quantite, int id_patient) {
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.id_patient = id_patient;
    }
    

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }

    public Produit getPr() {
        return pr;
    }

    public void setPr(Produit pr) {
        this.pr = pr;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", id_produit=" + id_produit + ", quantite=" + quantite + ", id_patient=" + id_patient + ", pat=" + pat + ", pr=" + pr + '}';
    }
     

   
     

}