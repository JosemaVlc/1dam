/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg07;

import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejercicio02 {
    public static boolean esMayorEdad(int a){
        boolean mayorEdad = false;
        if (a>=18){
            mayorEdad = true;
        }
        return mayorEdad;
    }
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Dime tu edad: ");
        int edad = entrada.nextInt();
        boolean mayor = esMayorEdad(edad);
        System.out.println("Eres mayor de edad? "+mayor);
    }
}
