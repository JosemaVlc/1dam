/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg5;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class Ejercicio21 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Dime un numero: ");
        int a = entrada.nextInt();
        int b;
        int cont=0;
        do{
            System.out.print("Dime otro numero mayor al anterior: ");
            b = entrada.nextInt();
            if (b<=a){
                System.out.println("B tiene que ser mayor que A");
            }
        }while(b<=a);
        for(int i=a;i<=b;i++){
            System.out.print(i+" ");
            if (i%2==0){
                cont++;
            }
        }
        System.out.println("\nLa cantidad de pares son: "+cont);
    }    
}
