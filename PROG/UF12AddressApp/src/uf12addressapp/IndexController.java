 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uf12addressapp;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import uf12addressapp.models.Contact;

/**
 *
 * @author jmore
 */
public class IndexController implements Initializable {
    //Variables de la tabla
    @FXML
    private TableView<Contact> contact_table;
    @FXML
    private TableColumn<Contact, String> nom_column;
    @FXML
    private TableColumn<Contact, String> cognoms_column;
    //Variables de la vista de detalls
    @FXML
    private Label nom_label;
    @FXML
    private Label cognoms_label;
    @FXML
    private Label domicili_label;
    @FXML
    private Label ciutat_label;
    @FXML
    private Label codi_postal_label;
    @FXML
    private Label data_de_naixement_label;
    
    //Variable per a la clase principal
    private UF12AddressApp address_app;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom_column.setCellValueFactory(cellData->cellData.getValue().getNom());
        cognoms_column.setCellValueFactory(cellData->cellData.getValue().getCognoms());
        
        //Al carregar la vista esborrem les dades 
        showContactDetails(null);
        
        /* Creem un escoltador per a la taula que quan es seleccione un element
        de la mateixa, cride a la funcio showContactDetails() passant-li el nou
        contacte */
        contact_table.getSelectionModel().selectedItemProperty().addListener(
                (observable, old_value, new_value) -> showContactDetails(new_value)
        );
    }
    
    /**
     * Crea una instància de contact de un contacte temporal.
     * 
     * Assigna el valor de la variable interna amb el nom okClicked utilitzant 
     * el mètode showContactEditDialog() de address_app i li dona contacte 
     * temporal com a argument.
     * 
     * Despres comprova si okCliked es true o false, i si es true, introduirá
     * el contacte temporal a la ObservableList.
     * 
     */
    public void newContact(){
        Contact tempContact = new Contact();
        
        boolean okClicked = this.address_app.showContactEditDialog(tempContact);
        
        if (okClicked == true){
            this.address_app.getContactes().add(tempContact);
        }   
    }
    
    /**
     * Crea un objecte tipus Contact que obtindrà els seus parametres 
     * mitjançant el mètode getSelectionModel().getSelectedItem() de 
     * contact_table.
     * 
     * Comprova que selectedContact no es nul·la asignara els valors de
     * la variable interna amb el nom okClicked utilitzant la instancia de
     * address_app, per a cridar al metode showContactEditDialog() a la que li
     * passarà la instància de contacte seleccionat anteriorment com a argument.
     * 
     * Comprova que okClicked té el valor true. Si es així cridarà a la finció 
     * showContactDetalls() passant-li el contacte, perquè mostre els detalls
     * del contacte.
     * 
     * A més, si es comprova que selectedContact és nul·la, es mostrarà un 
     * missatge d'error amb un cuadre de diàleg.
     * 
     */
    public void editContact(){
        Alert alert;
        Contact selectedContact = this.contact_table.getSelectionModel().getSelectedItem();
                
        if (selectedContact != null){
            boolean okClicked = this.address_app.showContactEditDialog(selectedContact);
            if (okClicked == true){
                showContactDetails(selectedContact);
            }              
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No hi ha cap element seleccionat");
            alert.setContentText("Has de seleccionar un contacte abans d'editar");
            alert.showAndWait();
        }
    }
    
    /**
     * S'obte, desde la clase principal
     * @param address_app 
     * 
     */
    public void setAddressApp(UF12AddressApp address_app){
        this.address_app = address_app;
        contact_table.setItems(address_app.getContactes());
    }
    /**
     * Modificarà els valors dels TextFields amb els valors del contacte.
     * 
     * Si el contacte es null modificara els valors dels TextFields a buit.
     * @param contacte 
     * 
     */
    public void showContactDetails(Contact contacte){
        if(contacte != null){
            this.nom_label.setText(contacte.getNom().get());
            this.cognoms_label.setText(contacte.getCognoms().get());
            this.domicili_label.setText(contacte.getDomicili().get());
            this.ciutat_label.setText(contacte.getCiutat().get());
            this.codi_postal_label.setText(Integer.toString(contacte.getCodi_postal().get()));
            this.data_de_naixement_label.setText(DateUtil.format(contacte.getData_de_naixement().get()));
        }else{
            this.nom_label.setText("");
            this.cognoms_label.setText("");
            this.domicili_label.setText("");
            this.ciutat_label.setText("");
            this.codi_postal_label.setText("");
            this.data_de_naixement_label.setText("");
        }
    }
    /**
     * Crea un objecte tipus Contact que obtindrà els seus parametres mitjançant 
     * el mètode getSelectionModel().getSelectedIndex() de contact_table
     * 
     * Comprova que selected_index no siga -1 i que contact_table no siga buit, 
     * i si es així mostrará un dialeg tipus confirmació en un avis de que 
     * l'acció es irreversible una vegada confiramada. En cas de confirmar 
     * borrará el contacte de ObservableLlist.
     * 
     * En cas de que selected_index siga -1 i contact_table siga buit es
     * mostrara un dialeg tipus error en un avis de que te que seleccionar un
     * dels contactes abans d'esborrar. 
     * 
     */
    @FXML
    public void deleteContact(){
        Alert alert;
        int selected_index = contact_table.getSelectionModel().getSelectedIndex();
                
        if(!contact_table.getItems().isEmpty() && selected_index != -1){
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar l'esborrat");
            alert.setHeaderText("Aquesta acció és irreversible");
            alert.setContentText("Estàs segur que vols esborrar aquest contacte?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                contact_table.getItems().remove(selected_index);
            }
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No hi ha cap element seleccionat");
            alert.setContentText("Has de seleccionar un contacte abans d'esborrar");
            alert.showAndWait();
        }
    }    
}
