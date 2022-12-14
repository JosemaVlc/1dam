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
public class ejercicio02 {
    public static void main(String[] args){
        Scanner entrada=new Scanner(System.in);
        float suma=0;
        float almacen[];
        almacen=new float[10];
        
        
        for (int i=0;i<almacen.length;i++){
            System.out.println(i+" - Introduce numero real: ");
            almacen[i]=entrada.nextFloat(); 
        }
        
        
        for (int i=0;i<almacen.length;i++){
            suma+=almacen[i];
        }
        
        System.out.println("La suma total de los numeros almacenados en el array es: "+suma);
    }
}
