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
public class ejercicio01 {
    public static double multiplica(double a, double b){
        double multi = a*b;
        return multi;
    }
    public static void main(String[] args){
        Scanner entrada= new Scanner(System.in);
        System.out.print("Primer factor: ");
        double a = entrada.nextDouble();
        System.out.print("Segundo factor factor: ");
        double b = entrada.nextDouble();
        double multi = multiplica(a,b);
        System.out.println("El producto es: "+multi);
    }
}
