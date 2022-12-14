/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1;
import java.util.Random;
/**
 *
 * @author jmore
 */
public class Ejercicio7 {
    public static void main(String[] args) {
        Random r = new Random();
        int d = r.nextInt(100)+1;
        double Valor_Milla = 1.852;
        double metros = d*Valor_Milla;
        System.out.println("La distancia de "+d+" millas nauticas corresponden a "+metros+" metros");
    }
}
