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
public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        System.out.print("Introduce valor A: ");
        int valorA=entrada.nextInt();
        System.out.print("Introduce valor B: ");
        int valorB=entrada.nextInt();
        int resultado=valorA;
            int i=valorB;
            while(i>1){
            resultado=resultado*valorA;
            i--;
        }
        System.out.println(valorA+"^"+valorB+"="+resultado);
    }
}
