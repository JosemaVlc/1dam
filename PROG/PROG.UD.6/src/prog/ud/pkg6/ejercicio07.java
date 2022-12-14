/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg6;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author jmore
 */
public class ejercicio07 {
    public static void main(String[] args){
        Scanner entrada=new Scanner(System.in);
        
        System.out.print("Valor mas bajo: ");
        int P=entrada.nextInt();
        System.out.print("Valor mas alto: ");
        int Q=entrada.nextInt();
        
        int tamaño=Q-P+1;
        int numeros[];
        numeros=new int[tamaño];
        
        for (int i=0;i<numeros.length;i++){
            numeros[i]=P;
            P++;                    
        }
        
        System.out.print("El array contiene los siguientes valores: {");
        for (int i=0;i<numeros.length;i++){
            System.out.print(numeros[i]);
            if (i<numeros.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("}");
        
    }
}
