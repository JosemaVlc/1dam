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
public class ejercicio17 {
    public static void main(String[] args){
        int nombre=0;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduix nombre a comprobar si es cosi: ");
        if (entrada.hasNextInt()){
            nombre = entrada.nextInt();
        }
        if (nombreCosi(nombre)==true){
            System.out.println("El nombre es cosi");
        }else{
            System.out.println("El nombre no es cosi");
        }
    }
    public static boolean nombreCosi(int nombre){
        boolean cosi = false;
        int vegadesDivisibles=0;
        for (int i=1; i<=nombre; i++){
            if (nombre%i == 0){
                vegadesDivisibles++;
            }
        }
        if (vegadesDivisibles==2){
            cosi = true;
        }
        
        return cosi;
    }
}
