/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package uf12addressapp;

import uf12addressapp.models.Contact;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
        
        //La funcio initRootLayout inicialitza la Scene principal.
        initRootLayout();
        
        //La funcio showIndex inicialitza la Scene interna.
        showIndex();
    }
        /**Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }   **/
    
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
