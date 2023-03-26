package reloj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLDocumentController {
    // Definim una instància privada de la classe Rellotge
    private Reloj reloj;

    @FXML
    private Button btnAuto;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAvaHora;

    @FXML
    private Button btnAvaMinut;

    @FXML
    private Button btnAvaSegon;

    @FXML
    private Button btnRetHora;

    @FXML
    private Button btnRetMinut;

    @FXML
    private Button btnRetSegon;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtMinut;

    @FXML
    private TextField txtSegon;
    
    @FXML
    void avanzaAuto(ActionEvent event) {
        reloj.avanzarAuto();
        actualitzarVista();
    }
    
    @FXML
    void avanzarHora(ActionEvent event) {
        reloj.avanzarHora();
        actualitzarVista();
    }

    @FXML
    void avanzarMinuto(ActionEvent event) {
        reloj.avanzarMinuto();
        actualitzarVista();

    }

    @FXML
    void avanzarSegundo(ActionEvent event) {
        reloj.avanzarSegundo();
        actualitzarVista();

    }

    @FXML
    void retrocederHora(ActionEvent event) {
        reloj.retrocederHora();
        actualitzarVista();
    }

    @FXML
    void retrocederMinuto(ActionEvent event) {
        reloj.retrocederMinuto();
        actualitzarVista();

    }

    @FXML
    void retrocederSegundo(ActionEvent event) {
        reloj.retrocederSegundo();
        actualitzarVista();

    }
    // Mètode per a actualitzar la vista
    private void actualitzarVista(){
    String hores= String.valueOf(reloj.getHora());
    String minuts= String.valueOf(reloj.getMinuto());
    String segons= String.valueOf(reloj.getSegundo());
    txtHora.setText(hores);
    txtMinut.setText(minuts);
    txtSegon.setText(segons);
    }
    @FXML
    void initialize() {
        assert btnAvaHora != null : "fx:id=\"btnAvaHora\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnAvaMinut != null : "fx:id=\"btnAvaMinut\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnAvaSegon != null : "fx:id=\"btnAvaSegon\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnRetHora != null : "fx:id=\"btnRetHora\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnRetMinut != null : "fx:id=\"btnRetMinut\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnRetSegon != null : "fx:id=\"btnRetSegon\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert txtHora != null : "fx:id=\"txtHora\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert txtMinut != null : "fx:id=\"txtMinut\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert txtSegon != null : "fx:id=\"txtSegon\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        // Crear la instància de la classe Rellotge
        reloj = new Reloj();
        actualitzarVista();
    }
}
