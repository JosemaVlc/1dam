/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg5;
import java.util.*;
/**
 *
 * @author jmore
 */
public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.print("Escribe cnatidad en euros: ");
        int cantidad=entrada.nextInt();
        int n=500;
        while(cantidad>0){
            int nBil=cantidad/n;
            cantidad=cantidad%n;
            System.out.println(nBil+" billetes de "+n);
            switch(n){
                case 500 -> {
                    n=200;
                    break;
                }
                case 200 -> {
                    n=100;
                    break;
                }
                case 100 -> {
                    n=50;
                    break;
                }
                case 50 -> {
                    n=20;
                    break;
                }
                case 20 -> {
                    n=10;
                    break;
                }
                case 10 -> {
                    n=5;
                    break;
                }
            }
        }
        
    }
}
