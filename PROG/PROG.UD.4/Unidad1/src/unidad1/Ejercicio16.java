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
public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe tu cualificacion numerica: ");
        int num1 = entrada.nextInt();
        if (num1>=0&&num1<3){
            System.out.println("Muy Deficiente");
        }
        else if(num1>=3&&num1<5){
            System.out.println("Insuficiente");
        }
        else if(num1>=5&&num1<6){
            System.out.println("Bien");
        }
        else if(num1>=6&&num1<9){
            System.out.println("Notable");
        }        
        else if(num1>=9&&num1<=10){
            System.out.println("Excelente");
        }
    }    
}
