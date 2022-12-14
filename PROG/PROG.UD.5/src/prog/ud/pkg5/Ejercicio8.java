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
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int positivos = 0;
        int negativos = 0;
        int num;
        do{
            System.out.print(" Escribe numero: ");
            num=entrada.nextInt();
            if(num<0){
                negativos++;
            }
            if(num>0){
                positivos++;
            }
        }while(num!=0);
        System.out.println("Se han leido "+positivos+" numeros positivos y "+negativos+" negativos.");   
    }
}
