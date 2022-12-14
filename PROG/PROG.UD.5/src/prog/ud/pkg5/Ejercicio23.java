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
public class Ejercicio23 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Dime un numero para realizar su piramide: ");
        int n=entrada.nextInt();
        //for para sumar lineas
        for(int lineas=n;lineas>0;lineas--){
            //imprime espacios
            int espacios=0;
            for(espacios=0;espacios<lineas-1;espacios++){
                System.out.print(" ");
            }
            //imprime los numeros ascendentes
            int numeros=0;
            for(numeros=0;numeros<n-espacios;numeros++){
                System.out.print(numeros+1);
            }
            //imprime los numeros descendentes
            while(numeros>1){
                System.out.print(numeros-1);
                numeros--;
            }
        //salto de linea            
        System.out.println();
        }
    }
}
