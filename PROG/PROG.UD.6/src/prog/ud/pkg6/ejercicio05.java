/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg6;

import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejercicio05 {
    public static void main(String[] args){
        Scanner entrada =new Scanner(System.in);
        int suma=0;
        int media=0;
        int almacen[];
        almacen=new int[20];
        
        
        for(int i=0;i<almacen.length;i++){
            System.out.println(i+" - Inserta un numero: ");
            almacen[i]=entrada.nextInt();
        }
        
        
        for(int i=0;i<almacen.length;i++){
            suma+=almacen[i];    
        }
        
        media=suma/almacen.length;
        System.out.println("La media de los numeros almacenados es: "+media);
    }    
}
