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
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("escribe tio mierdas: ");
        int num = entrada.nextInt();
        System.out.print(num+"!=");
        int i=num;
        while(i!=1){
            num=num*(i-1);
            System.out.print(i+"*");
            i--;
        }
        System.out.print(i+"="+num);
    }    
}
