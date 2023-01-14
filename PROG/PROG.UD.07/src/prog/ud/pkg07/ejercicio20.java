/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg07;

import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejercicio20 {
    public static void main(String[] args) {
        int a;
        Scanner entrada = new Scanner(System.in);
        for (int i=1; i<11; i++){
            for (int j=0; j<11; j++){
                System.out.printf("%02d * %02d = %02d %n", i, j, i*j);
            }
            System.out.println("");
        }
        System.out.print("Introduix el nombre de la taula de multiplicar a mostrar: ");
        a=entrada.nextInt();
        taula(a);
    }
    public static void taula(int a){
        for (int i=0; i<11; i++){
            System.out.printf("%02d * %02d = %02d %n", a, i, a*i);
        }
    }
}
