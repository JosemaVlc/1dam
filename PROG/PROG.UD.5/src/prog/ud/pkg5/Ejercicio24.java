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
public class Ejercicio24 {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un numero entero positivo: ");
        long num=entrada.nextLong();
        long copiaNum=num;
        int longitud=0;
        int suma=0;
        //contea la longitud de la cifra dividiendo entre 10 mientra que el numero sea mayor a 9
        while (num>9){
            num=num/10;
            longitud++;
        }
        System.out.print("Digitos pares: ");
        //for posicion por posicion usando la potencia de 10
        for (long posicion=longitud;posicion>=0;posicion--){
            double modulo = Math.pow(10, posicion+1);
            double cifra = copiaNum%modulo;
            //Divide entre 10 hasta que llega a la cifra de la izquierda
            while (cifra>9){
                cifra=(int) cifra/10; //result (int) para que %2 no sea dif a 0
            }
            //Mira si la cifra es par o impar y si es par, suma la cifra
            if (cifra%2==0){
                System.out.print((int)cifra+" "); //con (int) para que no imprima 0.0
                suma+=cifra; 
            }
        }
        System.out.println("\nSuma de los digitos pares es: "+suma);
    }
}
