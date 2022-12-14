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
public class ejercicio04 {
   public static int dimeSigno(int a){
       int signo;
       if (a>0){
           signo=1;
       }else if(a==0){
           signo=0;
       }else{
           signo=-1;
       }
       return signo;
   }
   public static void main(String[] args){
       Scanner entrada = new Scanner(System.in);
       System.out.print("Escribe un numero entero: ");
       int num = entrada.nextInt();
       int signo=dimeSigno(num);
       if (signo==1){
           System.out.println("El numero escrito es positivo");
       }else if(signo==0){
           System.out.println("El numero escrito es cero");
       }else{
           System.out.println("El numero escrito es negativo");
       }
   }
}
