/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1;

import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        System.out.print("Introduce lados del cuadrado: ");
        int l = entrada.nextInt();
        int area2 = l*l;
        System.out.println("El area de un cuadrado que cada uno de sus lados mide "+l+" es igual a "+area2);
    }
}
