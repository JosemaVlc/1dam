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
public class Ejercicio22 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Dime un numero para realizar su piramide: ");
        int n=entrada.nextInt();
        //for para sumar lineas
        for(int i=n;i>0;i--){
            //imprime espacios
            int cont=0;
            for(int it=0;it<i-1;it++){
                cont++;
                System.out.print(" ");
            }
            for(int it=0;it<(n-cont)*2-1;it++){
                System.out.print("*");
            }
        System.out.println();
        }
    }
}

