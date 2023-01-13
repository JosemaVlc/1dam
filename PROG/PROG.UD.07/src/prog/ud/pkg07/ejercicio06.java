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
public class ejercicio06 {
    public static void main(String[] args){
        double preu=0;
        Scanner entrada = new Scanner (System.in);
        System.out.println("Escriu el preu del article");
        if(entrada.hasNextDouble()){
            preu= entrada.nextDouble();
        }
        entrada.close();
        String preuAmbIVA = String.format("%.2f", preuAmbIVA(preu));
        System.out.println("Preu: "+preu+"\nPreu amb IVA: "+preuAmbIVA);
        
    }
    public static double preuAmbIVA(double preu){
        double preuAmbIVA = (preu * 0.21) + preu;
        return preuAmbIVA;
    }
}
