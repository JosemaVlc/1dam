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
public class ejercicio05 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int milles=0;
        System.out.println("Escriu un nombre enter de milles");
        if(entrada.hasNextInt()){
            milles = entrada.nextInt();
        }    
        System.out.println(milles+" milles son "+milles_a_quilometres(milles)+" kilometres");
    }
    public static double milles_a_quilometres(int milles){
        double quilometres=milles*1.60934;
        return quilometres;
    }
}
