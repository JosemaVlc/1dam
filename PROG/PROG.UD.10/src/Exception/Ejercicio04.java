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
 * 
 * Implementa un programa que cree un vector d'enters de grandària N (número aleatori entre
1 i 100) amb valors aleatoris entre 1 i 10. Després se li preguntarà a l'usuari quina posició del
vector vol mostrar per pantalla, repetint-se una vegada i una altra fins que s'introduïsca un
valor negatiu. Maneja totes les possibles excepcions.
 * 
 * 
 */

public class Ejercicio04 {
    public static void main(String[] args) {
        //Inicialitza el scanner y el array
        Scanner entrada = new Scanner(System.in);
        int vector[], posicion=0;
    
        //genera el numero aleatori entre el 1 i el 100
        double n = 1+(Math.random()*100);
        
        //asignamos el largo del vector, en este caso la variable n
        vector = new int[(int)n];
        
        //bucle para introducir datos aleatorios
        for (int i = 0; i < vector.length; i++) {
            double m = 1+(Math.random()*10);
            vector[i] = (int)m;
        }
        
        //Cliente introducira numero de posiciones a visualizar
        do{
            try{
                System.out.println("Que posicio del array vol veure?");
                posicion = entrada.nextInt();
                //devuelve el valor de la posicion
                System.out.printf("La posicio %d te el valor %d\n", posicion, vector[posicion]);
            }catch (InputMismatchException e){
                System.out.println("El valor no es valido");
                entrada.nextLine();
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Valor fora del rango de la array.");
                entrada.nextLine();
            }
        }while(posicion >= 0);
        System.out.println("tinga un bon dia");
    }

}
