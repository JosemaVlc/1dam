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
public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe el primer numero: ");
        int num1 = entrada.nextInt();
        System.out.print("Escribe el segundo numero: ");
        int num2 = entrada.nextInt();
        int suma=num1+num2;
        int resta=num1-num2;
        int multi=num1*num2;
        System.out.println("Los calculos con los numeros "+num1+" y "+num2+"\nSuma = "+suma+"\nResta = "+resta+"\nMultiplicacion = "+multi);
        if(num2!=0){
            int divi=num1/num2;
            System.out.println("Division = "+divi);
        }
        else{
            System.out.println("Error al dividir entre 0");
        }        
    }    
}
