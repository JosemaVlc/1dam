/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author jmore
 */
public class Article {
    String nom;
    double preu;
    double iva = 1.21;
    int cuantsQueden;     
    
    public Article(String nom, double preu, double iva, int enStock){
        this.nom = nom;
        if (preu > 0){ //preu deu ser major a 0€
            this.preu = preu;
        }else{
            System.out.println("El preu no pot ser negatiu ni de 0€");
        }
        if (iva == 4 || iva == 10 || iva == 21){ //el iva pot ser super reduit 4%, reduit 10% o general 21%
            this.iva = (iva/100)+1;
        }else{
            System.out.println("El iva no correspon al normalitzat a Espanya, se aplicará el 21%");
        }
        if (enStock >= 0){ //no pot ser stock negatiu
            this.cuantsQueden = enStock;
        }else{
            System.out.println("El stock mai pot ser menor a 0");
        }
    }
}
