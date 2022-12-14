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
public class Ejercicio20 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Dime un numero: ");
        int n=entrada.nextInt();
        for(int i=1;i<=n;i++){
            for(int it=0;it<i;it++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
