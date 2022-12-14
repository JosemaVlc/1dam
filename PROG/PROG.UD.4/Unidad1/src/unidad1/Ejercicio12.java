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
public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe el primer numero: ");
        int num1 = entrada.nextInt();
        if (num1>=0){
            System.out.println("El numero "+num1+" es positivo");
        }
        else if(num1<0){
            System.out.println("El numero "+num1+" es negativo");
        }
    }    
}
