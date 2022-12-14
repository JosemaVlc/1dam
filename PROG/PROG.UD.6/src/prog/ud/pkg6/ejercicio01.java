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
public class ejercicio01 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float almacen[];
        
        
        
        almacen=new float[10];
        for (int i=0;i<almacen.length;i++){
            System.out.println(i+" - Introduce un entero: ");
            almacen[i]=entrada.nextFloat();
        }
        
        
        System.out.print("El array contiene los siguientes numeros: {");
        for (int i=0;i<almacen.length;i++){
            System.out.print(almacen[i]);
            if (i<almacen.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("}");
    }
}
