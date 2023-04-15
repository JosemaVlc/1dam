/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package uf12addressapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import uf12addressapp.models.Contact;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author jmore
 */
public class UF12AddressApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<Contact> contactes = FXCollections.observableArrayList();
    
    public UF12AddressApp() {
        this.contactes.add(new Contact("Guillermo","Garrido Portes","C/Albacete", 
                "Valencia", 47001,11,01,1995));
        this.contactes.add(new Contact("Maria","Gómez Gil","C/Alzira",
                "Alacant",47002,21,02,2000));
        this.contactes.add(new Contact("Diego","Gonzalez Cuenca","C/Manises",
                "Castello",47003,31,03,2005));
        this.contactes.add(new Contact("Laura","Galiana Gutiérrez","C/Xativa",
                "Barcelona",47004,01,04,2010));
        this.contactes.add(new Contact("Silvia","Gandia Garcia","Plaza la Reina",
                "Valencia",47005,12,05,2015));
    }
    
    public ObservableList<Contact> getContactes(){
        return this.contactes;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        //Asignem el primaryStage al stage inicial
        this.primaryStage = stage;
        //Canviem el titol.
        this.primaryStage.setTitle("Activitat Avaluable 2 - JMMoreno");
        
        Image icona = new Image("resources/images/contacts.png");
        this.primaryStage.getIcons().add(icona);
                
        //La funcio initRootLayout inicialitza la Scene principal.
        initRootLayout();
        
        //La funcio showIndex inicialitza la Scene interna.
        showIndex();
    }
    
    private void initRootLayout(){
        try {
            //Carreguem el FXML
            FXMLLoader loader = new FXMLLoader (
                    getClass().getResource("views/RootLayout.fxml"));
            this.rootLayout = loader.load();
            //Creem una Scena amb el arxiu FXML.
            Scene scene = new Scene(this.rootLayout);
            //Assignem l'escena a l Stage.
            this.primaryStage.setScene(scene);
            /* Creem el controlador per a poder assignar´li una instància de AddressApp */
            RootLayoutController controller = loader.getController();
            controller.setAddressApp(this);
            //Mostrem el Stage
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void showIndex(){
        try {
            //Carreguem el FXML
            FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("views/Index.fxml"));
            AnchorPane index = (AnchorPane) loader.load();
            this.rootLayout.setCenter(index);
            
            IndexController controller = loader.getController();
            controller.setAddressApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setContactFilePath(File arxiu){
        Preferences prefs = Preferences.userNodeForPackage(getClass());
        if(arxiu != null){
            prefs.put("ruta_arxiu", arxiu.getPath());
        }else{
            prefs.remove("ruta_arxiu");
        }
    }
    
    public File getContactFilePath(){
        Preferences prefs = Preferences.userNodeForPackage(getClass());
        String ruta_arxiu = prefs.get("ruta_arxiu", null);
        if(ruta_arxiu != null){
            return new File(ruta_arxiu);
        }else{
            return null;
        }
    }
    
    public Window getPrimaryStage(){
        return this.primaryStage;
    }
    
    public void saveContactDataToFile(File arxiu){
        try {
            FileWriter fitxer = new FileWriter(arxiu);
            fitxer.write("");
            fitxer.close();
            fitxer = new FileWriter(arxiu,true);
            for (Contact contact : this.contactes){
                String str = contact.getNom().get() + ","
                        + contact.getCognoms().get() + ","
                        + contact.getDomicili().get() + ","
                        + contact.getCiutat().get() + ","
                        + String.valueOf(contact.getCodi_postal().get()) + ","
                        + DateUtil.format(contact.getData_de_naixement().get());
                fitxer.write(str);
                fitxer.write(System.lineSeparator());
            }
            fitxer.close();
            this.setContactFilePath(arxiu);
        } catch (Exception ex) {
            System.err.println("Error al guardar els contactes en l'arxiu: " + arxiu.getName());
        }
    }
    
    public void loadContactDataFromFile(File arxiu){
        this.contactes.clear();
        try {
            FileReader fr = new FileReader(arxiu);
            BufferedReader br = new BufferedReader(fr);
            // Lectura del fitxer
            String linea;
            while((linea = br.readLine())!= null){
                String[] contacte = linea.split("\\.");
                String[] fecha = contacte[5].split("\\.");
                this.contactes.add(new Contact (
                                    contacte[0],
                                    contacte[1],
                                    contacte[2],
                                    contacte[3],
                                    Integer.parseInt(contacte[4]),
                                    Integer.parseInt(fecha[0]),
                                    Integer.parseInt(fecha[1]),
                                    Integer.parseInt(fecha[2])));
            }
            fr.close();
            this.setContactFilePath(arxiu);
        } catch (Exception ex) {
            System.err.println("No s'ha trobal l'arxiu: " + arxiu.getName());
        }
    }
    
    /**
     * Carrega la vista i crea un nou Stage.
     * 
     * Comprova si el nom del contacte rebut buit i en cas de serlo posará el titol
     * de "Nou contacte" mentres que si no es buit posara el titol de "Editar" 
     * seguit del nom i cognoms del contacte.
     * 
     * Utilizant les funsions initModality(Modality.WINDOW_MODAL) e initOwner(primaryStage)
     * del nou Stage indica que tipus de quadre i l'enlaza en el Stage primari.
     * 
     * Crea la nova escena a la qual li passa el AnchorPane de la vista.
     * 
     * Utiliza el metode setScenne() per a passar-li l'escena que s'ha creat.
     * 
     * Crea una instancia de ContactEditDialogController amb el loader.getControlloer()
     * i li passa al controller el dialogStage en el metode setDialogStage i el contacte
     * en el metode loadContacte().
     * 
     * Obri i espera la vista
     * 
     * Per ultim retorna el valor booleà que obté en la funció getOkClicked() 
     * del controllador
     * 
     * @param contacte
     * @return 
     */
    public boolean showContactEditDialog(Contact contacte){
        boolean okClicked = false;
        
        try {
            //Carreguem el FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("views/ContactEditDialog.fxml"));
            Stage dialogStage = new Stage();
            
            if (!"".equals(contacte.getNom().get())){
                dialogStage.setTitle("Editar "+contacte.getNom().get()+" "+contacte.getCognoms().get());
            }else{
                dialogStage.setTitle("Nou contacte");
            }
            
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            
            AnchorPane contactEditDialog = (AnchorPane) loader.load();
            
            Scene scene = new Scene(contactEditDialog);
            
            dialogStage.setScene(scene);
                        
            ContactEditDialogController controller = loader.getController();
            
            controller.setDialogStage(dialogStage);
            controller.loadContacte(contacte);
            
            dialogStage.showAndWait();
            
            okClicked = controller.getOkClicked();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }        
        
        return okClicked;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
