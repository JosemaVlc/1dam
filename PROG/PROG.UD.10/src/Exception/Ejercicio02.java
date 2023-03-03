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
        //inicialitse variables
        int A, B;
        //inicialitse scanner        
        Scanner entrada = new Scanner(System.in);
        
        try{
            System.out.println("Escribe un entero");
            A = entrada.nextInt();

            System.out.println("Escribe otro entero");
            B = entrada.nextInt();
            
            System.out.printf("A / B = %d",A/B);
        }
        catch(ArithmeticException e){
            System.out.println("El divisor no puede ser 0");
        }
        catch(InputMismatchException e){
            System.out.println("No has escrito un entero valido");
        }

        
    }
}
