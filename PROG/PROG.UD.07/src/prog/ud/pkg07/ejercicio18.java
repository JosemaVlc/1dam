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
public class ejercicio18 {
    public static void main (String[] args){
        int numero=0;
        char lletra;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escriu el nombre del DNI: ");
        if (entrada.hasNextInt()){
            numero = entrada.nextInt();
        }
        lletra = lletraDNI(numero);
        System.out.println("La lletra del DNI "+numero+" es "+lletra);
    }
    public static char lletraDNI(int numero){
        char lletra[]={'T','R','W','A','G','M','I','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int reste = numero%23;
        return lletra[reste];
    }
}
