/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1;

import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int hh;
        int mm;
        int ss;
        do{
            System.out.print("Escribe hora: ");
            hh = entrada.nextInt();
            System.out.print("Escribe minuto: ");
            mm = entrada.nextInt();
            System.out.print("Escribe segundo: ");
            ss = entrada.nextInt();
        }while(hh>=24&&hh<0&&mm>=60&&mm<0&&ss>=60&&mm<=0);
        if(ss!=59){
            ss++;
            System.out.println(hh+"h "+mm+"m "+ss+"s");
        }
        else{
            ss=0;
            if(mm!=59){
                mm++;
                System.out.println(hh+"h "+mm+"m "+ss+"s");
            }
            else{
                mm=0;
                if (hh!=23){
                    System.out.println(hh+"h "+mm+"m "+ss+"s");
                }
                else{
                    hh=0;
                    System.out.println(hh+"h "+mm+"m "+ss+"s");
                }
            }         
        }
    }
}
