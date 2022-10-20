/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit.gui;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import prod.entity.Produit;
import prod.services.ProduitCRUD;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ProduitController implements Initializable {

    @FXML
    private TextField gpNom;
    @FXML
    private TextField gpDisc;
    @FXML
    private TextField gpRef;
    @FXML
    private TextField gpPrix;
    @FXML
    private TextField gpCat;
    @FXML
    private Button btAjt;
     @FXML
    private TableColumn<Produit, String> trCat;

    @FXML
    private TableColumn<Produit, String> trDisc;

    @FXML
    private TableColumn<Produit, String> trNom;

    @FXML
    private TableColumn<Produit, String> trPrix;

    @FXML
    private TableColumn<Produit, String> trRef;

    @FXML
    private TableView<?> trView;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addProd(ActionEvent event) {
        String nom_prod = gpNom.getText();
        String discription = gpDisc.getText();
        String reference = gpRef.getText();
        int prix = Integer.parseInt(gpPrix.getText());
        String categories = gpCat.getText();
        
        Produit p = new Produit(nom_prod, discription, reference, prix, categories);
        ProduitCRUD pcd = new ProduitCRUD();
        pcd.ajouterProduit2(p);
    }
    
   
}
