/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uf12addressapp;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author jmore
 */
public class RootLayoutController implements Initializable {
    private UF12AddressApp address_app;
    
    /**
     * S'obte, desde la clase principal
     * @param address_app
     */
    public void setAddressApp(UF12AddressApp address_app){
        this.address_app = address_app;
    }
    
    /**
     * Tanca la aplicació
     * 
     */
    @FXML
    public void exit(){
        System.exit(0);
    }
    
    /**
     * Es carrega el observableList desde l'arxiu.
     * 
     */
    @FXML
    public void openFile(){
        File arxiu = this.mostraDialeg("open");
        //Si s'ha obtingut el nom de un arxiu
        if (arxiu != null){
            this.address_app.loadContactDataFromFile(arxiu);
        }
    }
    
    /**
     * Es guarda en l'arxiu l'observableList que existeix o crida a saveAsFile()
     * 
     */
    @FXML
    public void saveFile(){
        File arxiu = this.address_app.getContactFilePath();
        if(arxiu != null){
            this.address_app.saveContactDataToFile(arxiu);
        }else{
            this.saveAsFile();
        }            
    }
    
    /**
     * Es mostra l'explorador per a posar-li nom a l'arxiu el guarda.
     * 
     */
    @FXML
    public void saveAsFile(){
        File arxiu = this.mostraDialeg("save");
        //Si s'ha obtingut el nom i ruta d'un arxiu
        if (!arxiu.getPath().endsWith(".txt")){
            // Creem el arxiu amb la extensió ".txt"
            arxiu = new File (arxiu.getPath()+".txt");
        }
        this.address_app.saveContactDataToFile(arxiu);
    }
    
    private File mostraDialeg(String tipus){
        File arxiu;
        //Classe per a poder seleccionar el arxiu desde el explorador
        FileChooser seleccionador = new FileChooser();
        //Filtre per a pevitar que se seleccionen arxius d'extension no permeses
        FileChooser.ExtensionFilter extensio = new FileChooser.ExtensionFilter("Archivos de Texto","*.txt");
        
        //Afegim al seleccionador la restricció de l'extensió
        seleccionador.getExtensionFilters().add(extensio);
        //Mostrem el explorador amb un dialog que apareixera sobre primary_stage
        if(tipus.equals("save")){
            //Si el tipus es "save" obri l'explorador per a guardar
            return arxiu = seleccionador.showSaveDialog(address_app.getPrimaryStage());
        }else{
            /* Si el tipus es diferent a "save" obri l'explorador per a seleccionar l'arxiu.*/
            return arxiu = seleccionador.showOpenDialog(address_app.getPrimaryStage());
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
