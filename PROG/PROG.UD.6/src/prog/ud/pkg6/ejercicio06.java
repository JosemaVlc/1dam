/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg6;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class ejercicio06 {
    public static void main(String[] args){
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("Introduce el numero de espacios en tu array: ");
        int N=entrada.nextInt();
        
        System.out.println("Introduce valor todos todas las posiciones del array: ");
        int M=entrada.nextInt();
        
        int almacen[];
        almacen= new int[N];
        Arrays.fill(almacen,M); 
        
        System.out.print("Los valores del array son: {");
        for(int i=0;i<almacen.length;++i){
            System.out.print(almacen[i]);
            if (i<almacen.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("}");
    }
}
