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
public class ejercicio12 {
    public static void main(String[] args){
        int quilometres=0;
        String milles;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduix quilometres a traduir: ");
        if (entrada.hasNextInt()){
            quilometres = entrada.nextInt();
        }
        milles = String.format("%.2f", quilometres_a_milles(quilometres));
        System.out.println(quilometres+" quilometres son "+milles+" milles");
    }
    public static double quilometres_a_milles(int quilometres){
        double milles = quilometres / 1.60934;
        return milles;
    }
}
