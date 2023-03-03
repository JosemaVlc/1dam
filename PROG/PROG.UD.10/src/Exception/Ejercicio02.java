/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jmore
 * Implementa un programa que demane dos valores int A i B utilitzant un nextInt() (de
Scanner), calcule A/B i mostre el resultat per pantalla. S'hauran de tractar de manera
independent les dues possibles excepcions, InputMismatchException i ArithmeticException,
mostrant en cada cas un missatge d'error diferent.
 */
public class Ejercicio02 {
    public static void main(String[] args) throws InputMismatchException, ArithmeticException{
        
        int A, B;
                
        Scanner entrada = new Scanner(System.in);
        
        InputMismatchException e = new InputMismatchException("Valor introduit incorrecte");
        ArithmeticException e1 = new ArithmeticException("Valor aritmetic erroni, no pot ser 0");
        
        System.out.println("Escribe un entero");
        if (entrada.hasNextInt()){
            A = entrada.nextInt();
        }else{
            throw e;
        }
        
        System.out.println("Escribe otro entero");
        if (entrada.hasNextInt()){
            B = entrada.nextInt();
        }else{
            throw e;
        }
        
        if (B == 0){
            throw e1;
        }
        
        System.out.println("A / B = "+A/B);
    }
}
