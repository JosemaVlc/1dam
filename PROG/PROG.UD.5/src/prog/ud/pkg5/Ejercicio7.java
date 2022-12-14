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
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int positivos = 0;
        int negativos = 0;
        for(int i=10;i>=1;i--){
            System.out.print(i+" Escribe numero: ");
            int num=entrada.nextInt();
            if(num<0){
                negativos++;   
            }else{
                positivos++;
            }
        }
        System.out.println("Se han leido "+positivos+" numeros positivos y "+negativos+" negativos.");   
    }
}
