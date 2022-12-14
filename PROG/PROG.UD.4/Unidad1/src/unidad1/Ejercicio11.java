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
public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe el primer numero: ");
        int num1 = entrada.nextInt();
        System.out.print("Escribe el segundo numero: ");
        int num2 = entrada.nextInt();
        if (num1>=num2){
            System.out.println("El mayor es "+num1);
        }
        else if(num1<num2){
            System.out.println("El mayor es "+num2);
        }
    }
}
