/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe PVP: ");
        double pvp = entrada.nextInt();
        System.out.print("Escribe PVR: ");
        double pvr = entrada.nextInt();
        double descuento = ((pvp-pvr)/pvp)*100;
        System.out.println("Se ha aplicado el "+descuento+"%");
    }
}
