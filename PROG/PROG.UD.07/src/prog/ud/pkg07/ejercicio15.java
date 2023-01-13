/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg07;

/**
 *
 * @author jmore
 */
public class ejercicio15 {
    public static void main(String[] args){
        int nombres[]= new int[100];
        for (int i=0; i<100; i++){
            nombres[i]=i;
        }
        int suma = suma(nombres);
        String mitjana = String.format("%.2f", mitjana(nombres));
        System.out.println("En els primer 100 nombres naturals tenen el seguents datos");
        System.out.println("La suma dells fan: "+suma);
        System.out.println("La mitjana dells fan: "+mitjana);
        
        
    }
    public static int suma(int nombres[]){
        int suma = 0;
        for (int i=0; i<nombres.length; i++){
            suma = suma + nombres[i];
        }
        return suma;
    }
    public static double mitjana(int nombres[]){
        double mitjana=0;
        for (int i=0; i<nombres.length; i++){
            mitjana = mitjana + nombres[i];
        }
        mitjana = mitjana/nombres.length;
        return mitjana;
    }
    
}
