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
public class ejercicio16 {
    public static void main (String[] args){
        int grandaria=0;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduix nombre de valors: ");
        if (entrada.hasNextInt()){
            grandaria = entrada.nextInt();
        }
        int valors[]=new int[grandaria];
        valors_aleatoris(valors);
        for (int i=0; i<valors.length; i++){
            System.out.println(valors[i]);
        }
    }
    public static void valors_aleatoris(int[] valors){
        for (int i=0; i<valors.length; i++){
            valors[i] = (int)(1 + Math.random() * 100);
        }
    }
}
