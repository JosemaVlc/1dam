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
public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.print("Escribe un radio: ");
        Scanner entrada = new Scanner(System.in);
        int r = entrada.nextInt();
        double l = 2*Math.PI*r;
        double a = Math.PI*(r*r);
        double v = (4/3)*Math.PI*(r*r*r);
        System.out.println("Con radio "+r+" se calculan los siguientes valores:\nLongitud "+l+"\nArea "+a+"\nVolumen "+v);
    }    
}
