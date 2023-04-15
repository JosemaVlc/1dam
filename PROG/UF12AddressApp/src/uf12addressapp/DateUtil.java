/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uf12addressapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;

/**
 *
 * @author jmore
 */
public class DateUtil {
    private static final String PATRO_DATA = "dd.MM.yyyy";
    private static final DateTimeFormatter FORMATEJADOR_DATA = DateTimeFormatter.ofPattern(PATRO_DATA);
    
    /**
     * Torna la data en format de cadena o null en cas de no existir
     * @param data
     * @return 
     */
    public static String format(LocalDate data){
        
        if (data == null) {
            return null;
        }
        return FORMATEJADOR_DATA.format(data);
    }
    
    /**
     * Torna la data en forma de LocalDate o null en cas de no existir
     * 
     * Si es erronea o no existeis torna un avis de que s'ha guardat sense el
     * camp Data de Naixement (no es a la practica)
     * 
     * @param data
     * @return 
     */
    public static LocalDate parse(String data){
        Alert alert;
        
        //En cas de que la variable no siga una data valida
        try {
            return FORMATEJADOR_DATA.parse(data, LocalDate::from);
        } catch (Exception e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("La data de naiximent ha de ser format DD.MM.YYYY");
            alert.setContentText("La data no es valida, el contacte s'ha guardat sense data pero seria convenient modificar el camp Data de Naixement a un valor valid.");
            alert.showAndWait();
            return null;
        }
    }
    
    /**
     * comproba que es valida la data
     * @param data
     * @return 
     */
    public static boolean validDate(String data){
        //En cas de que la variable no siga una data valida
        return DateUtil.parse(data) != null;
    }
    
}
