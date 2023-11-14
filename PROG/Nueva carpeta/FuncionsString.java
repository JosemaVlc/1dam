/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcions1av;
import java.util.Scanner;
/**
 *
 * @author jose manuel moreno
 */
public class FuncionsString {
    public static void contarCaracter(String frase){
        Scanner entrada = new Scanner(System.in);
        int n=0;
        System.out.print("Introdueix una lletra: ");
        char x = entrada.nextLine().charAt(0);
        for (int i = 0; i < frase.length(); i++) {
            if (x == frase.charAt(i)){
                n++;
            }
        }
        System.out.println("La lletra "+x+" apareix "+n+" vegades");
    }
}
