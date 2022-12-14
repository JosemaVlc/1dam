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
public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Da como entrada tres numeros diferentes.\nEscribe el primer numero: ");
        int num1 = entrada.nextInt();
        System.out.print("Escribe el segundo numero: ");
        int num2 = entrada.nextInt();
        System.out.print("Escribe el tercer numero: ");
        int num3 = entrada.nextInt();
        if (num1>num2 && num1>num3){
            System.out.println("El mayor es "+num1);
        }
        else if(num2>num1&&num2>num3){
            System.out.println("El mayor es "+num2);
        }
        else if(num3>num1&&num3>num2){
            System.out.println("El mayor es "+num3);
        }
        else if(num1==num2||num1==num3||num2==num3){
            System.out.println("Error, al menos hay dos numeros iguales");
        }
    }      
}
