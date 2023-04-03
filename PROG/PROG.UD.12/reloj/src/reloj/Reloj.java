/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package reloj;

import java.util.Calendar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jmore
 */
public class Reloj extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    private int hora;
    private int minuto;
    private int segundo;
        
        // Constructor
        public Reloj() {
            this.hora = 0;
            this.minuto = 0;
            this.segundo = 0;
        }
        
        // Mètodes per a mostrar hora, minuts y segons
        public int getHora() {
            return this.hora;
        }
        
        public int getMinuto() {
            return this.minuto;
        }
        
        public int getSegundo() {
            return this.segundo;
        }

        // Mètodes per a canviar hora, minuts y segons
        public void avanzarHora() {
            if (this.hora<23){
                this.hora++;
            } else {
                this.hora=0;
            }
        }

        public void retrocederHora() {
            if (this.hora>0){
                this.hora--;
            } else {
                this.hora=23;
            }
        }
        
        public void avanzarMinuto() {
            if (this.minuto<59){
                this.minuto++;
            } else {
                this.minuto=0;
                avanzarHora();
            }
        }

        public void retrocederMinuto() {
            if (this.minuto>0){
                this.minuto--;
            } else {
                this.minuto=59;
                retrocederHora();
            }
        }
        
        public void avanzarSegundo() {
            if (this.segundo<59){
                this.segundo++;
            } else {
                this.segundo=0;
                avanzarMinuto();
            }
        }

        public void retrocederSegundo() {
            if (this.segundo>0){
                this.segundo--;
            } else {
                this.segundo=59;
                retrocederMinuto();
            }
        }
        
        public void avanzarAuto() {
            Calendar calendario = Calendar.getInstance();
            this.hora =calendario.get(Calendar.HOUR_OF_DAY);
            this.minuto = calendario.get(Calendar.MINUTE);
            this.segundo = calendario.get(Calendar.SECOND);
        }
    
        /**
        * @param args the command line arguments
        */
        public static void main(String[] args) {
            launch(args);
        }
    }
