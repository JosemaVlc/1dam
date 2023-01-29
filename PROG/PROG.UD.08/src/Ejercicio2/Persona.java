/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;
import java.util.Arrays;

/**
 *
 * @author jmore
 */
public class Persona {
    private String nom, cognoms;
    private int edad;
    final String dni;
    final static int majoriaEdad = 18;
    
    static boolean validarDNI(String dni){
        boolean validacio = false;
        
        if (dni.length() == 9 && Character.isLetter(dni.charAt(8)) == true){
            if (dni.substring(0,7).matches("[0-9]*")){
                validacio = true;
            }else{
                System.out.println("DNI incorrecte");
            }
        }else{
            System.out.println("DNI incorrecte");
        }
        return validacio;
    }
    
    public Persona(String dni, String nom, String cognoms, int edad){
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.edad = edad;                
    }
    
    public void imprimeix(){
        System.out.printf("\n%s %s amb DNI %s y %d anys de edat \n", this.nom, this.cognoms, this.dni, this.edad);
    }
    
    public boolean esMajorEdat(){
        boolean major = false;
        if (this.edad >= Persona.majoriaEdad){
            major = true;
        }
        return major;
    }
    
    public boolean esJubilat(){
        boolean jubilat = false;
        if (this.edad >= 65){
            jubilat = true;
        }
        return jubilat;
    }
    
    public int diferenciaEdat(Persona p){
        int diferencia = this.edad - p.getEdad();
        return diferencia;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setCognoms(String cognoms){
        this.cognoms = cognoms;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public String getDNI(){
        return dni;
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getCognoms(){
        return cognoms;
    }
    
    public int getEdad(){
        return edad;
    }
}
