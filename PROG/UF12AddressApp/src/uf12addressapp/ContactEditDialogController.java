/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uf12addressapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uf12addressapp.models.Contact;

/**
 * FXML Controller class
 *
 * @author jmore
 */
public class ContactEditDialogController implements Initializable {
    
    //Variables de la vista de detalls
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_cognoms;
    @FXML
    private TextField txt_domicili;
    @FXML
    private TextField txt_ciutat;
    @FXML
    private TextField txt_codi_postal;
    @FXML
    private TextField txt_data_de_naixement;
    
    
    Stage dialogStage = new Stage();
    boolean okClicked = false;
    Contact contacte = new Contact();
    
    /**
     * Funcio set per a modificar l'objecte dialogStage
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    /**
     * Funcio get per a obtindre el valor de la variable okClicked
     * @return 
     */
    public boolean getOkClicked(){
        return this.okClicked;
    }
    
    /**
     * Obte el contacte a partir del que está seleccionat per l'usuari a la vista Index.fxml 
     * i omplira tots el TextsFields amb els atributs de contacte.
     * @param contacte 
     */
    public void loadContacte(Contact contacte){
        this.contacte = contacte;

        this.txt_nom.setText(contacte.getNom().get());
        this.txt_cognoms.setText(contacte.getCognoms().get());
        this.txt_domicili.setText(contacte.getDomicili().get());
        this.txt_ciutat.setText(contacte.getCiutat().get());
        this.txt_codi_postal.setText(Integer.toString(contacte.getCodi_postal().get()));
        this.txt_data_de_naixement.setText(DateUtil.format(contacte.getData_de_naixement().get()));
    }
    
    
    /**
     * Utiliza la variable dialogStage per a tancar el quadre de diàleg.
     */
    @FXML
    public void cancel(){
        dialogStage.close();
    }
    
    /**
     * Valida l'entrada de l'usuari mitjançant l'execució del mètode 
     * areFormInputsValid() que retornarà un valor boolean. Si la funció 
     * areFormInputsValid() retorna true, la funció ok() modificarà els 
     * valors dels atributs de contacte amb el text que existeix en els 
     * TextFields, despres canviarà el valor de okClicked a verdader i 
     * tancarà el quadre de diàleg.
     * 
     */
    @FXML
    public void ok(){
        if(areFormInputsValid()){
           this.contacte.getNom().set(txt_nom.getText());
           this.contacte.getCognoms().set(txt_cognoms.getText());
           this.contacte.getDomicili().set(txt_domicili.getText());
           this.contacte.getCiutat().set(txt_ciutat.getText());
           this.contacte.getCodi_postal().set(Integer.parseInt(txt_codi_postal.getText()));
           this.contacte.getData_de_naixement().set(DateUtil.parse(txt_data_de_naixement.getText()));
           this.okClicked = true;
           this.dialogStage.close();
        }
    }
    
    /**
     * Crea una variable anomenada missatge que anirà incrementanse amb un
     * missatge d'error en cada camp sols quan es complisquen alguna de les
     * següents condicions:
     * 
     * - Comprovarà que el text de cada TextField siga null.
     * - Comprovarà que el nombre de caràcters siga 0.
     * - En cas de ser un valor diferent de cadena s'haurà de validar que el
     *   tipus de valor siga correcte.
     * 
     * En cas que el missatge continga algun error, la funció,
     * retorna false y mostrarà un quadre de diàleg que informarà dels errors.
     * 
     * En cas que el missatge siga buit, retornarà true
     * 
     * @return valid true si no conté errors y false, si conté errors
     */
    public boolean areFormInputsValid(){
        Alert alert;
        boolean valid = false;
        String missatge = "";
        
        if (txt_nom.getText() == null || "".equals(txt_nom.getText())){
            missatge += "Nom no vàlid.\n";
        }
        if (txt_cognoms.getText() == null || "".equals(txt_cognoms.getText())){
            missatge += "Cognoms no vàlids.\n";
        }
        if (txt_domicili.getText() == null || "".equals(txt_domicili.getText())){
            missatge += "Domicili no vàlids.\n";
        }
        if (txt_ciutat.getText() == null || "".equals(txt_ciutat.getText())){
            missatge += "Ciutat no vàlida.\n";
        }
        if (txt_codi_postal.getText() == null || "".equals(txt_codi_postal.getText())){
            missatge += "Codi Postal no vàlid.\n";
        }
        if (!DateUtil.validDate(txt_data_de_naixement.getText())){
            missatge += "Data de Naixement no vàlida.\n";
        }
        
        if ("".equals(missatge)){
            valid = true;
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Camps incorrectes");
            alert.setContentText(missatge);
            alert.showAndWait();
        }
        
        return valid;
    }
    
    
    /**
     * Initializes the controller class.
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
