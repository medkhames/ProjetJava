/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit.gui;

import static com.sun.tools.doclint.Entity.prod;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import prod.entity.Produit;
import prod.services.ProduitCRUD;
import prod.utils.MyConnectionProd;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ProduitController implements Initializable {
    MyConnectionProd db = MyConnectionProd.getInstance();
    Connection conn;
    public PreparedStatement st;
    public ResultSet result;
    
    
    
    
    
    @FXML
    private TableColumn<Produit, String> Nom_Produit;
    @FXML
    private TableColumn<Produit, String> Discription;
    @FXML
    private TableColumn<Produit, String> Reference;
    @FXML
    private TableColumn<Produit, Integer> Prix;
    @FXML
    private TableColumn<Produit, String> Categories;
    @FXML
    private TextField fxNP;
    @FXML
    private TextField fxDS;
    @FXML
    private TextField fxRF;
    @FXML
    private TextField fxPR;
    @FXML
    private ComboBox fxCT;
    @FXML
    private TextField fxRC;
    @FXML
    private Button btENR;
    @FXML
    private Button btMOD;
    @FXML
    private Button btSUP;
    @FXML
    private Button btACT;
    @FXML
    private TableView<Produit> tableProduit;
    @FXML
    private TableColumn<Produit, Integer> Id_Prod;
    @FXML
    private TextField fxID;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<Produit> list;
    //int index = -1;
    //Connection cnx = null;
    //ResultSet rs= null;
   // PreparedStatement ps = null;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList<String> list = FXCollections.observableArrayList("Médicament","bébé&Maman","C.Alimentaire");
       fxCT.setItems(list);
       
       Id_Prod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("Id_prod"));
       Nom_Produit.setCellValueFactory(new PropertyValueFactory<Produit, String>("Nom_prod"));
       Discription.setCellValueFactory(new PropertyValueFactory<Produit, String>("Discription"));
       Reference.setCellValueFactory(new PropertyValueFactory<Produit, String>("Reference"));
       Prix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("Prix"));
       Categories.setCellValueFactory(new PropertyValueFactory<Produit, String>("Categories"));
      // listM = MyConnectionProd.getAllProduit();
       //tableProduit.setItems(list);
       refresh_table();
    }    

    @FXML
    private void selectCT(ActionEvent event) {
            String s = fxCT.getSelectionModel().getSelectedItem().toString();
         
         
    }

    @FXML
    private void addP(ActionEvent event) {
        
        Produit p = new Produit(
       /* Integer.parseInt(fxID.getText()),*/
        fxNP.getText(),
        fxDS.getText(),
        fxRF.getText(),
        Integer.parseInt(fxPR.getText()),
       //fxCT.getTypeSelector() );
        
         String.valueOf(fxCT.getValue()));
                
                
       ObservableList<Produit> produits = tableProduit.getItems();
       produits.add(p);
       
            JOptionPane.showMessageDialog(null, "Produit ajouter avec succée");
       tableProduit.setItems(produits);
       //Produit p = new Produit(Nom_produit, Discription, Reference, Prix, Categories);
        ProduitCRUD pc = new ProduitCRUD();
        pc.ajouterProduit2(p);
    }

    @FXML
    private void modP(ActionEvent event) {
    }
    
        
    

    @FXML
    private void supP(ActionEvent event) {
       int id_prod = tableProduit.getSelectionModel().getSelectedIndex();
        tableProduit.getItems().remove(id_prod);
       Produit p = new Produit();
       p.setId_prod(Integer.parseInt(fxID.getText()));
       p.setNom_prod(fxNP.getText());
       p.setDiscription(fxDS.getText());
       p.setReference(fxRF.getText());
       p.setPrix(Integer.parseInt(fxPR.getText()));
       p.setCategories(fxCT.getTypeSelector());
       ProduitCRUD pcd = new ProduitCRUD();
       pcd.deleteProduit(id_prod);
       
    }
       
       
       
                   /* Produit p =this.tableProduit.getSelectionModel().getSelectedItem();
                   try {
                       ProduitCRUD prod =new ProduitCRUD();
                   prod.deleteProduit(0);
                   
                   }
                   catch(Exception e){}
                   }*/
       
       
       
       
       
       
       
       
    
        /*int Id_prod = Integer.parseInt(fxID.getText());
        String Nom_prod = fxNP.getText();
        String Discription = fxDS.getText();
        String Reference = fxRF.getText();
        int Prix = Integer.parseInt(fxPR.getText());
        String Categories = fxCT.getTypeSelector();*/
       /* Produit p = new Produit(
       Integer.parseInt(fxID.getText()),
        fxNP.getText(),
        fxDS.getText(),
        fxRF.getText(),
        Integer.parseInt(fxPR.getText()),
       fxCT.getTypeSelector());*/
        
       /* Produit p = new Produit(Nom_prod, Discription, Reference, Prix, Categories);
        ProduitCRUD pcd = new ProduitCRUD();
        pcd.deleteProduit(id_prod);*/
        
    

    @FXML
    private void actP(ActionEvent event) {
        ProduitCRUD prod =new ProduitCRUD();
          ObservableList<Produit> list = FXCollections.observableArrayList(prod.afficherProduit());   
          this.tableProduit.getItems().clear();
          this.tableProduit.getItems().addAll(list);

       
    }
    
    public void  refresh_table () {
   
             try {
              ProduitCRUD pr =new ProduitCRUD();
          ObservableList<Produit> list = FXCollections.observableArrayList(pr.afficherProduit());   
          this.tableProduit.getItems().clear();
          this.tableProduit.getItems().addAll(list);
          
          
        } catch (Exception e) {
        }
        // TODO
    }

    @FXML
    private void recherche(KeyEvent event) throws SQLException {
        ProduitCRUD Pr =new ProduitCRUD();

          ObservableList<Produit> list = FXCollections.observableArrayList(Pr.afficherProduit());   
        
      FilteredList<Produit> filteredData = new FilteredList<>(list, b -> true);
        // 2. Set the filter Predicate whenever the filter changes.
		fxRC.textProperty().addListener((observable, oldValue, newValue) -> {
                    filteredData.setPredicate(Produit -> {
                        
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					
                                        System.out.println("biennnnnnnnnnn");
                                        return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				/*if (Produit.getNom_prod.toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}*/
                                 if (Produit.getDiscription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				} else if (Produit.getReference().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
                                 else if (Produit.getCategories().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
                             
                                else if (String.valueOf(Produit.getPrix()).indexOf(lowerCaseFilter) != -1) 
					return true; // Filter matches last name.
				
				     //return true;
				     else  
				    	 return false; // Does not match.
			
                       
                        
                    });
			
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Produit> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableProduit.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableProduit.setItems(sortedData);    
    }
    


    @FXML
    private void UpProd(KeyEvent event) {
    }




    

}
