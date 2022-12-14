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
public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        boolean seguir = true;
        int max=1;
        int min=100;
        int anterior=0;
        System.out.println("Vamos a jugar a un juego... piensa en un numero y voy a tenerlo que adivinar");
        while (seguir==true){
            int num=(max+min)/2;
            if (num==anterior){
                num+=1;
            }
            System.out.print("El numero es "+num+"? (=,<o>)");
            String respuesta= entrada.next();
            switch (respuesta) {
                case ">" -> {
                    max=num;
                    anterior=num;
                    break;
                }
                case "<" -> {
                    min=num;
                    anterior=num;
                        break;
                }
                default -> seguir=false;
            }
        }
        System.out.println("LO ACERTE!!!");
    }
}
