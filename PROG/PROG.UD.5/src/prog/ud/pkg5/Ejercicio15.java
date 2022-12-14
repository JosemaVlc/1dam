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
public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe un numero maximo :");
        int max=entrada.nextInt();
        for(int i=0;i<=max;i+=3){
            System.out.println(i);
        }
    }
}
