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
public class ejercicio13 {
    public static void main (String[] args){
        double preuNormal=0, preuRebaixat=0; 
        String percentatgeDescompte;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduix preu normal: ");
        if (entrada.hasNextDouble()){
            preuNormal = entrada.nextDouble();
        }
        System.out.print("Introduix preu rebaixat: ");
        if (entrada.hasNextDouble()){
            preuRebaixat = entrada.nextDouble();
        }
        percentatgeDescompte = String.format("%.2f", percentatgeDescompte(preuRebaixat, preuNormal));
        System.out.println("El precentatge aplicat es del "+percentatgeDescompte+"%");
    }
    public static double percentatgeDescompte(double preuRebaixat, double preuNormal){
        double descompte = preuNormal - preuRebaixat;
        double percentatge = descompte * 100 / preuNormal;
        return percentatge;
    }
}
