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
public class ejercicio03 {
    public static int minimo(int a, int b){
        int min = Math.min(a, b);
        return min;
    }
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un numero entero: ");
        int a = entrada.nextInt();
        System.out.print("Introduce otro numero entero: ");
        int b = entrada.nextInt();
        System.out.println("El de valor mas bajo es: "+minimo(a,b));
    }
}
