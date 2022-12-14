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
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean negativo = false;
        for(int i=10;i>=1;i--){
            System.out.print(i+" Escribe numero: ");
            int num=entrada.nextInt();
            if(num<0){
                negativo=true;   
            }
        }
        if(negativo==true){
            System.out.println("Se ha leido un numero negativo");
        }
        
    }
}
