/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg6;

import java.util.Scanner;

/**
 * Crea un programa que cree un array d'enters de grandària 100 i ho emplene amb 
 * valors enters aleatoris entre 1 i 10 (utilitza 1 + Math.random()10). 
 * Després demanarà un valor N i mostrarà en quines posicions del array apareix N.
 *
 * @author jmore
 */
public class ejercicio09 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int enteros[];
        enteros=new int[100];
        
        for (int i=0; i<enteros.length; i++){
            enteros[i]=(int)(1 + Math.random()*10);
        }
        
        System.out.print("Introduce un valor entero: ");
        int N=entrada.nextInt();
        System.out.print("Las siguientes posiciones del array tienen un valor iguale a valor introducido");
        
        for (int i=0; i<enteros.length;i++){
            if (enteros[i]==N){
                System.out.println(i);
            }
        }
    }
    
}
