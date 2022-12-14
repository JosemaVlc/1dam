/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1;
import java.util.*;
/**
 *
 * @author jmore
 */
public class Ejercicio21 {
    public static void main(String[] args) {
        //llamo entrada al scanner
        Scanner entrada = new Scanner(System.in);
        //llamada a las variables
        String jugador1;
        String jugador2;
        //entrada de datos
        do{
            System.out.print("Turno del jugador 1(Introduce piedra, papel o tijera): ");
            jugador1=entrada.nextLine();
        }while(!"piedra".equals(jugador1)&&!"papel".equals(jugador1)&&!"tijera".equals(jugador1));
        do{
            System.out.print("Turno del jugador 2(Introduce piedra, papel o tijera): ");
            jugador2=entrada.nextLine();
        }while(!"piedra".equals(jugador2)&&!"papel".equals(jugador2)&&!"tijera".equals(jugador2));        
        //salida de datos
        if ("piedra".equals(jugador1)&&"tijera".equals(jugador2)||"papel".equals(jugador1)&&"piedra".equals(jugador2)||"tijeras".equals(jugador1)&&"papel".equals("jugador2")){
            System.out.println("Gana el jugador 1");
        }
        if ("piedra".equals(jugador2)&&"tijera".equals(jugador1)||"papel".equals(jugador2)&&"piedra".equals(jugador1)||"tijeras".equals(jugador2)&&"papel".equals("jugador1")){
            System.out.println("Gana el jugador 2");
        }        
        if (jugador1.equals(jugador2)){
            System.out.println("Empate");
        }
    }    
}
