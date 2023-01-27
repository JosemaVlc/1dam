/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.numeros_y_letras;
import java.util.Random;
/**
 *
 * @author jmore
 */
public class randomize {
    public static void main(String[] args) {
        String tecnico[] = {"Nino", "Christofer", "Christian", "David", "Luis", "Salvador"};
        Random elAzar = new Random();
        System.out.println("***************************************************************");
        System.out.println("El tecnico agraciado para realizar la guardia es: "+tecnico[elAzar.nextInt(tecnico.length)]);
        System.out.println("***************************************************************");
    }
}
