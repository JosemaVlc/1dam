/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uf12addressapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uf12addressapp.models.Contact;

/**
 * FXML Controller class
 *
 * @author jmore
 */
public class ContactEditDialogController implements Initializable {
    Stage dialogStage = new Stage();
    boolean okClicked = false;
    Contact contacte = new Contact();
    
    //Variables de la vista de detalls
    @FXML
    private TextField text_nom;
    @FXML
    private TextField text_cognoms;
    @FXML
    private TextField text_domicili;
    @FXML
    private TextField text_ciutat;
    @FXML
    private TextField text_codi_postal;
    @FXML
    private TextField text_data_de_naixement;
    
    /**
     * Funcio set per a modificar l'objecte dialogStage
     */
    public void setDialogStage(){
        
    }
    
    /**
     * Funcio get per a obtindre el valor de la variable okClicked
     */
    public void getOkClicked(){
        
    }
    
    /**
     * Obte el contacte a partir del que está seleccionat per l'usuari en la vsita Index.fxml 
     * i omplira tots el TextsFields amb els atributs de contacte.
     * @param contacte 
     */
    public void loadContacte(Contact contacte){
        this.contacte = contacte;
        if(contacte != null){
            this.text_nom.setText(contacte.getNom().get());
            this.text_cognoms.setText(contacte.getCognoms().get());
            this.text_domicili.setText(contacte.getDomicili().get());
            this.text_ciutat.setText(contacte.getCiutat().get());
            this.text_codi_postal.setText(Integer.toString(contacte.getCodi_postal().get()));
            this.text_data_de_naixement.setText(DateUtil.format(contacte.getData_de_naixement().get()));
        }else{
            this.text_nom.setText("");
            this.text_cognoms.setText("");
            this.text_domicili.setText("");
            this.text_ciutat.setText("");
            this.text_codi_postal.setText("");
            this.text_data_de_naixement.setText("");
        }
    }
    
    
    /**
     * Utiliza la variable dialogStage per a tancar el quadre de diàleg
     */
    public void cancel(){
        dialogStage.close();
    }
    
    /**
     * 
     */
    public void ok(){
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
