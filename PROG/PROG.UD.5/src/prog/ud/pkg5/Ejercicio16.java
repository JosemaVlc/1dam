/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg5;
import java.util.*;
/**
 *
 * @author jmore
 */
public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        System.out.print("Dime un numero: ");
        int num=entrada.nextInt();
        int i=num;
        int primo=0;
        while(i!=0){
            if (num%i==0){
                primo++;
            }
            i--;
        }
        if (primo==2){
            System.out.println("Es primo.");
        }           
    }    
}
