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
public class Ejercicio19 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Dime un numero: ");
        int num=entrada.nextInt();
        for(int i=num; i>0;i--){
            System.out.print("* ");
        }
    }
}
