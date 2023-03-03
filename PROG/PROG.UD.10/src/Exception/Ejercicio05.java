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
 * Implementa un programa amb tres funcions:
 *   ◦  void imprimeixPositiu(int p): Imprimeix el valor p. Llança una ‘Exception’ si p < 0
 *   ◦  void imprimeixNegatiu(int n): Imprimeix el valor n. Llança una ‘Exception’ si p >= 0
 *   ◦  La funció main per a realitzar proves. Pots cridar a totes dues funcions diverses vegades
 *      amb diferents valors, fer un bucle per a demanar valors per teclat i passar-los a les
 *      funcions, etc. Maneja les possibles excepcions.
 * 
 */
public class Ejercicio05 {
    public static void main(String[] args) {
        //initzialice l'escaner y les variables
        Scanner entrada = new Scanner (System.in);
        int num=0;
        
        //Proba en el 7
        num=7;
        try{
            imprimeixPositiu(num);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
        try{
            imprimeixNegatiu(num);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
        
        //Proba en el -3
        num=-3;
        try{
            imprimeixPositiu(num);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
        try{
            imprimeixNegatiu(num);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
        
        //bucle per a introduir numero
        do{
            try{
                System.out.println("Introdueix un numero");
                num=entrada.nextInt();
                //si el numero es 0, sort del programa
                if (num==0){
                    break;
                }
                //proba anb la funcio imprimeix positiu
                try{
                    imprimeixPositiu(num);
                //si falla imprimeix la falla
                }catch(InputMismatchException e){
                    System.out.println(e);
                }
                //proba anb la funcio imprimeix negatiu
                try{
                    imprimeixNegatiu(num);
                //si falla imprimeix la falla
                }catch(InputMismatchException e){
                    System.out.println(e);
                }
            //si num no es un valor valid imprimeix el error i borra cache
            }catch(InputMismatchException e){
                System.out.println("Valor erroneo");
                entrada.nextLine();
            }
            //si dona exception impriura que es negatiu y llamara la funcio

        }while(num!=0);
        
        
        
    }
    static void imprimeixPositiu(int p) throws InputMismatchException{
        InputMismatchException e1 = new InputMismatchException("El numero es negatiu");
        if (p < 0){
            throw (e1);
        }
        System.out.println("El valor positiu es: "+p);
    }
    static void imprimeixNegatiu(int n) throws InputMismatchException{
        InputMismatchException e2 = new InputMismatchException("El numero es positiu");
        if (n >= 0){
            throw (e2);
        }
        System.out.println("El valor negatiu es: "+n);
    }
            
}
