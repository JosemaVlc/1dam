/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author jmore
 * 
 * Implementa un programa que cree un vector tipus double de grandària 5 i després, utilitzant
un bucle, demane cinc valors per teclat i els introduïsca en el vector. Hauràs de manejar
la/les possibles excepcions i continuar demanant valors fins a emplenar completament el
vector.
 * 
 */
public class Ejercicio03 {
    public static void main(String[] args){
        
        Scanner entrada = new Scanner(System.in);
        double vector[] = new double[5];
        int i = 0;
        while (i < vector.length) {
            try{
                System.out.printf("Introdueix valor per enmagatzenar en la posicio %d del array\n->",i);
                vector[i] = entrada.nextDouble();
                i++;
            }
            catch (InputMismatchException a){
                System.out.println("Intentes asignar un valor incompatible.");
                a.printStackTrace();
                entrada.nextLine();
            }
        }
        for (int j = 0; j < vector.length; j++) {
            System.out.printf("\nLa posicio %d del array, te enmagatzenat el valor %.2f",j, vector[j]);
        }
    }
}