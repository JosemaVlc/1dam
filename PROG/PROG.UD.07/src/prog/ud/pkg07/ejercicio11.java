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
public class ejercicio11 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int n = 0;
        System.out.print("Introduix nombre enter: ");
        if (entrada.hasNextInt()){
            n = entrada.nextInt();
        }
        taulaMultiplicar(n);
    }
    public static void taulaMultiplicar(int n){
        int producte;
        for(int i=1; i<11; i++){
            producte = n * i;
            System.out.println(n+" * "+i+" = "+producte);
        }
    }
}
