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
public class ejercicio08 {
    public static void main(String[] args){
        int n=0, suma, producte;
        double intermedi;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduix un nombre enter; ");
        if(entrada.hasNextInt()){
            n = entrada.nextInt();
        }
        suma = suma1aN(n);
        producte = producte1aN(n);
        intermedi = intermedi1aN(n);
        System.out.println("de la cantitat "+n+" obtenim els seguents resultats: \nSuma: "+suma+"\nProducte: "+producte+"\nIntermedi: "+intermedi);
        
    }
    public static int suma1aN(int n){
        int suma=0;
        for(int i=n;i>0;i--){
            suma = suma + i;
        }
        return suma;
    }
    public static int producte1aN(int n){
        int producte=1;
        for(int i=n; i>0; i--){
            producte = producte * i;
        }
        return producte;
    }
    public static double intermedi1aN(int n){
        double intermedi=(double)n/2;
        System.out.println(intermedi);
        return intermedi;
    }
}
