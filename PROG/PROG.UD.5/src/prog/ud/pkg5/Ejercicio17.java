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
public class Ejercicio17 {
    public static void main(String[] args) {
        //Inicializar datos
        Scanner entrada = new Scanner(System.in);
        int cont=0;
        int fallo=0;
        int num1=0;
        System.out.print("Dime un numero inicial: ");
        int num=entrada.nextInt();
        while(num!=0){
            if(num>num1){
                cont++;
            }else{
                fallo++;
                System.out.println("Fallo, es menor");
            }
            num1=num;
            System.out.print("Dime un numero: ");
            num=entrada.nextInt();
        }
        System.out.println("Total de numeros introducidos: "+cont+"\nNumeros fallados: "+fallo);
    }
}
